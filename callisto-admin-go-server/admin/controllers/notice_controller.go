package controllers

import (
	"admin-server/admin/models"
	"admin-server/platform/database"
	"strconv"

	"github.com/gofiber/fiber/v2"
)

// GetNotices godoc
// @Summary Get notices
// @Description Get notices
// @Accept json
// @Produce json
// @Success 200 {object} models.Notice
// @Router /notices [get]
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
			"error":   true,
			"msg":     "Notices were not found",
			"count":   0,
			"notices": nil,
		})
	}

	return c.JSON(fiber.Map{
		"error":   false,
		"msg":     nil,
		"count":   len(notices),
		"notices": notices,
	})
}

// GetNotice godoc
// @Summary Get a notice by ID
// @Description Get notice by ID
// @Accept json
// @Produce json
// @Param id path int true "Notice ID"
// @Success 200 {object} models.Notice
// @Router /notice/{id} [get]
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

// @Description Create a new notice.
// @Summary create a new notice
// @Tags Notice
// @Accept json
// @Produce json
// @Param notice_title body string true "NoticeTitle"
// @Param notice_contents body string true "NoticeContents"
// @Param profile_id body uuid true "ProfileId"
// @Success 200 {object} models.Notice
// @Router /notice [post]
func CreateNotice(c *fiber.Ctx) error {
	// jwt
	//now := time.Now().Unix()

	//claims, err := utils.ExtractTokenMetadata(c)
	// if err != nil {
	// 	return c.Status(fiber.StatusInternalServerError).JSON(fiber.Map{
	// 		"error": true,
	// 		"msg":   err.Error(),
	// 	})
	// }

	// //expires := claims.Expires

	// if now > expires {
	// 	return c.Status(fiber.StatusUnauthorized).JSON(fiber.Map{
	// 		"error": true,
	// 		"msg":   "unauthorized, check expiration time of your token",
	// 	})
	// }

	notice := &models.NoticeUploadDto{}

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
