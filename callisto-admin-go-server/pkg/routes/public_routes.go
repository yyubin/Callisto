package routes

import (
	"admin-server/admin/controllers"

	"github.com/gofiber/fiber/v2"
)

// PublicRoutes func for describe group of public routes.
func PublicRoutes(a *fiber.App) {
	// Create routes group.
	route := a.Group("/admin")

	// Routes for GET method:
	route.Get("/notices", controllers.GetNotices)   // get list of all books
	route.Get("/notice/:id", controllers.GetNotice) // get one book by ID
}
