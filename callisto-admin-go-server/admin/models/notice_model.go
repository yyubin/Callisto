package models

import (
	"time"

	"github.com/google/uuid"
)

// @Description 공지사항 모델
type Notice struct {
	NoticeId       int       `db:"notice_id" json:"notice_id"`
	NoticeTitle    string    `db:"notice_title" json:"notice_title" example:"notice_title"`
	NoticeContents string    `db:"notice_contents" json:"notice_contents" example:"notice_contents"`
	ProfileId      uuid.UUID `db:"profile_id" json:"profile_id" validate:"required,uuid"`
	CreatedAt      time.Time `db:"created_at" json:"created_at"`
	UpdatedAt      time.Time `db:"updated_at" json:"updated_at"`
}

// @Description 공지사항 등록 폼
type NoticeUploadDto struct {
	NoticeTitle    string    `db:"notice_title" json:"notice_title" example:"notice_title"`
	NoticeContents string    `db:"notice_contents" json:"notice_contents" example:"notice_contents"`
	ProfileId      uuid.UUID `db:"profile_id" json:"profile_id" example:"profile_id"`
}

type NoticeUploadEntity struct {
	NoticeTitle    string    `db:"notice_title" json:"notice_title"`
	NoticeContents string    `db:"notice_contents" json:"notice_contents"`
	ProfileId      uuid.UUID `db:"profile_id" json:"profile_id"`
}

func NoticeUploadDtoToEntity(dto *NoticeUploadDto) *NoticeUploadEntity {
	return &NoticeUploadEntity{
		NoticeTitle:    dto.NoticeTitle,
		NoticeContents: dto.NoticeContents,
		ProfileId:      dto.ProfileId,
	}
}

func NoticeUploadEntityToDto(entity *NoticeUploadEntity) *NoticeUploadDto {
	return &NoticeUploadDto{
		NoticeTitle:    entity.NoticeTitle,
		NoticeContents: entity.NoticeContents,
		ProfileId:      entity.ProfileId,
	}
}
