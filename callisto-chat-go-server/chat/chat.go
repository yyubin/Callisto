package chat

import (
	"chat/utils"
	"context"
	"fmt"
	"log"
	"net/http"
	"strings"
	"time"

	"github.com/gorilla/websocket"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
)

type Chat struct {
	users      map[string]*User
	messages   chan *Message
	join       chan *User
	leave      chan *User
	collection *mongo.Collection
}

var upgrader = websocket.Upgrader{
	ReadBufferSize:  512,
	WriteBufferSize: 512,
	CheckOrigin: func(r *http.Request) bool {
		log.Printf("%s %s%s %v\n", r.Method, r.Host, r.RequestURI, r.Proto)
		return r.Method == http.MethodGet
	},
}

func (c *Chat) Handler(w http.ResponseWriter, r *http.Request) {
	conn, err := upgrader.Upgrade(w, r, nil)
	if err != nil {
		log.Fatalln("Error on websocket connection:", err.Error())
	}

	keys := r.URL.Query()
	username := keys.Get("username")
	if strings.TrimSpace(username) == "" {
		username = fmt.Sprintf("anon-%d", utils.GetRandomI64())
	}

	user := &User{
		Username: username,
		Conn:     conn,
		Global:   c,
	}

	c.join <- user

	user.Read()
}

func (c *Chat) Run() {
	for {
		select {
		case user := <-c.join:
			c.add(user)
		case message := <-c.messages:
			c.broadcast(message)
		case user := <-c.leave:
			c.disconnect(user)
		}
	}
}

func (c *Chat) add(user *User) {
	if _, ok := c.users[user.Username]; !ok {
		c.users[user.Username] = user

		body := fmt.Sprintf("%s join the chat", user.Username)
		c.broadcast(NewMessage(body, "Server"))
	}
}

func (c *Chat) broadcast(message *Message) {
	log.Printf("Broadcast message: %v\n", message)

	_, err := c.collection.InsertOne(context.Background(), bson.M{"username": message.Sender, "body": message.Body, "time": time.Now()})
	if err != nil {
		log.Printf("Error inserting message into MongoDB: %v\n", err)
	}

	for _, user := range c.users {
		user.Write(message)
	}
}

func (c *Chat) disconnect(user *User) {
	if _, ok := c.users[user.Username]; ok {
		defer user.Conn.Close()
		delete(c.users, user.Username)

		body := fmt.Sprintf("%s left the chat", user.Username)
		c.broadcast(NewMessage(body, "Server"))
	}
}

func Start(port string) {

	log.Printf("Chat listening on http://localhost%s\n", port)

	client, collection := utils.ConnectMongoDB()
	defer client.Disconnect(context.Background())

	c := &Chat{
		users:      make(map[string]*User),
		messages:   make(chan *Message),
		join:       make(chan *User),
		leave:      make(chan *User),
		collection: collection,
	}

	http.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Write([]byte("Welcome to Go WebChat!"))
	})

	http.HandleFunc("/chat", c.Handler)

	go c.Run()

	log.Fatal(http.ListenAndServe(port, nil))
}
