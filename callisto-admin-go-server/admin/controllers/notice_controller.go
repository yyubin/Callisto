package controllers

import (
	"admin-server/admin/models"
	"admin-server/pkg/utils"
	"admin-server/platform/database"
	"strconv"
	"time"

	"github.com/gofiber/fiber/v2"
)

func GetNotices(c *fiber.Ctx) error {
	db, err := database.OpenDBConnection()
	if err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	notices, err := db.GetNotices()
	if err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error": true,
			"msg":   "Notices were not found",
			"count": 0,
			"books": nil,
		})
	}

	return c.JSON(fiber.Map{
		"error": false,
		"msg":   nil,
		"count": len(notices),
		"books": notices,
	})
}

func GetNotice(c *fiber.Ctx) error {
	id, err := strconv.Atoi(c.Params("id"))
	if err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	db, err := database.OpenDBConnection()
	if err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	notice, err := db.GetNotice(id)
	if err != nil {
		return c.Status(fiber.StatusNotFound).JSON(fiber.Map{
			"error":  true,
			"msg":    "notice with the given ID is not found",
			"notice": nil,
		})
	}

	return c.JSON(fiber.Map{
		"error":  false,
		"msg":    nil,
		"notice": notice,
	})
}

func CreateNotice(c *fiber.Ctx) error {
	now := time.Now().Unix()

	claims, err := utils.ExtractTokenMetadata(c)
	if err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	expires := claims.Expires

	if now > expires {
		return c.Status(fiber.StatusUnauthorized).JSON(fiber.Map{
			"error": true,
			"msg":   "unauthorized, check expiration time of your token",
		})
	}

	notice := &models.Notice{}

	if err := c.BodyParser(notice); err != nil {
		return c.Status(fiber.StatusBadRequest).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	db, err := database.OpenDBConnection()
	if err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	notice.CreatedAt = time.Now()

	if err := db.CreateNotice(notice); err != nil {
		return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
			"error": true,
			"msg":   err.Error(),
		})
	}

	return c.JSON(fiber.Map{
		"error":  false,
		"msg":    nil,
		"notice": notice,
	})

}
