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
	query := `SELECT * FROM notice`

	err := q.Get(&notices, query)
	if err != nil {
		return notices, err
	}

	return notices, nil
}

func (q *NoticeQueries) GetNotice(id int) (models.Notice, error) {
	notice := models.Notice{}

	query := `SELECT * FROM notice WHERE notice_id = $1`

	err := q.Get(&notice, query, id)
	if err != nil {
		return notice, err
	}

	return notice, nil
}

func (q *NoticeQueries) CreateNotice(n *models.Notice) error {
	query := `INSERT INTO notice VALUES ($1, $2, $3, $4)`

	_, err := q.Exec(query, n.NoticeTitle, n.NoticeContents, n.ProfileId)
	if err != nil {
		return err
	}

	return nil
}
