package com.spring.callistoreview.db.entity;

import com.spring.callistoreview.model.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Review {

    @Id @GeneratedValue
    @Type(type="uuid-char")
    private UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyReviewId")
    private CompanyReview companyReview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId")
    private Company company;

    private UUID profileId;

    private double totalStars;

    private double careerStars;

    private double lifeStars;

    private double salaryStars;

    private double cultureStars;

    private double directorStars;

    private String title;

    private String positiveContents;

    private String negativeContents;

    @OneToMany
    @JoinColumn(name = "reviewLikeId")
    private List<ReviewLike> reviewLike;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime deletedAt;

    public Review() {

    }

    public static Review createReview(ReviewDto reviewDto, Company company, CompanyReview companyReview) {
        return  Review.builder()
                .company(company)
                .companyReview(companyReview)
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

}
