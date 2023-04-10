package routes

import (
	"admin-server/admin/controllers"

	"github.com/gofiber/fiber/v2"
)

func PrivateRoutes(a *fiber.App) {
	// Create routes group.
	route := a.Group("/admin")

	// Routes for POST method:
	route.Post("/notice", controllers.CreateNotice) // create a new book

}
