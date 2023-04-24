package com.spring.callistoreview.db.entity;

import com.spring.callistoreview.model.ReviewDto;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id @GeneratedValue
    @Type(type="uuid-char")
    private UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    private UUID profileId;

    private UUID companyReviewId;

    private Double totalStars;

    private Double careerStars;

    private Double lifeStars;

    private Double salaryStars;

    private Double cultureStars;

    private Double directorStars;

    private String title;

    private String positiveContents;

    private String negativeContents;

    @OneToMany
    @JoinColumn(name = "reviewLikeId")
    private List<ReviewLike> reviewLike;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime deletedAt;

    public void setCompany(Company company) {
        this.company = company;
    }

    public static Review createReview(ReviewDto reviewDto, Company company) {
        return  Review.builder()
                .company(company)
                .companyReviewId(reviewDto.getCompanyReviewId())
                .profileId(reviewDto.getProfileId())
                .totalStars(reviewDto.getTotalStars())
                .careerStars(reviewDto.getCareerStars())
                .cultureStars(reviewDto.getCultureStars())
                .directorStars(reviewDto.getDirectorStars())
                .salaryStars(reviewDto.getSalaryStars())
                .lifeStars(reviewDto.getLifeStars())
                .title(reviewDto.getTitle())
                .positiveContents(reviewDto.getPositiveContents())
                .negativeContents(reviewDto.getNegativeContents())
                .build();
    }

    public static Review updateReview(ReviewDto reviewDto, Review oldReivew) {
        return Review.builder()
                .company(oldReivew.company)
                .companyReviewId(oldReivew.getCompanyReviewId())
                .profileId(oldReivew.getProfileId())
                .totalStars(reviewDto.getTotalStars())
                .careerStars(reviewDto.getCareerStars())
                .cultureStars(reviewDto.getCultureStars())
                .directorStars(reviewDto.getDirectorStars())
                .salaryStars(reviewDto.getSalaryStars())
                .lifeStars(reviewDto.getLifeStars())
                .title(reviewDto.getTitle())
                .positiveContents(reviewDto.getPositiveContents())
                .negativeContents(reviewDto.getNegativeContents())
                .build();
    }

    public void updateFrom(Review newReview) {
        if (newReview.getTotalStars() != null) {
            this.totalStars = newReview.getTotalStars();
        }
        if (newReview.getCareerStars() != null) {
            this.careerStars = newReview.getCareerStars();
        }
        if (newReview.getCultureStars() != null) {
            this.cultureStars = newReview.getCultureStars();
        }
        if (newReview.getDirectorStars() != null) {
            this.directorStars = newReview.getDirectorStars();
        }
        if (newReview.getLifeStars() != null) {
            this.lifeStars = newReview.getLifeStars();
        }
        if (newReview.getSalaryStars() != null) {
            this.salaryStars = newReview.getSalaryStars();
        }
        if (newReview.getTitle() != null) {
            this.title = newReview.getTitle();
        }
        if (newReview.getPositiveContents() != null) {
            this.positiveContents = newReview.getPositiveContents();
        }
        if (newReview.getNegativeContents() != null) {
            this.negativeContents = newReview.getNegativeContents();
        }
    }
}
