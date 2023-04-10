package queries

import (
	"admin-server/admin/models"

	"github.com/jmoiron/sqlx"
)

type NoticeQueries struct {
	*sqlx.DB
}

func (q *NoticeQueries) GetNotices() ([]models.Notice, error) {
	notices := []models.Notice{}
	query := `SELECT notice_id, notice_title, notice_contents, profile_id, created_at, updated_at FROM notice`

	err := q.Select(&notices, query)
	if err != nil {
		return notices, err
	}

	return notices, nil
}

func (q *NoticeQueries) GetNotice(id int) (models.Notice, error) {
	notice := models.Notice{}

	query := `SELECT notice_id, notice_title, notice_contents, profile_id, created_at, updated_at FROM notice WHERE notice_id = $1`

	err := q.Get(&notice, query, id)
	if err != nil {
		return notice, err
	}

	return notice, nil
}

func (q *NoticeQueries) CreateNotice(n *models.NoticeUploadDto) error {
	e := models.NoticeUploadDtoToEntity(n)

	query := `INSERT INTO notice (notice_title, notice_contents, profile_id) VALUES ($1, $2, $3);`

	_, err := q.Exec(query, e.NoticeTitle, e.NoticeContents, e.ProfileId)
	if err != nil {
		return err
	}

	return nil
}
