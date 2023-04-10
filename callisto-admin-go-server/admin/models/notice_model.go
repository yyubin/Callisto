package models

import (
	"time"

	"github.com/google/uuid"
)

type Notice struct {
	NoticeId       int       `db:"notice_id" json:"notice_id"`
	NoticeTitle    string    `db:"notice_title" json:"notice_title"`
	NoticeContents string    `db:"notice_contents" json:"notice_contents"`
	ProfileId      uuid.UUID `db:"profile_id" json:"profile_id"`
	CreatedAt      time.Time `db:"created_at" json:"created_at"`
	UpdatedAt      time.Time `db:"updated_at" json:"updated_at"`
	DeletedAt      time.Time `db:"deleted_at" json:"deleted_at"`
}
