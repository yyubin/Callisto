package com.spring.callistoreview.model;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import com.spring.callistoreview.db.entity.Review;
import com.spring.callistoreview.db.entity.ReviewLike;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class ReviewDto {

    private UUID reviewId;

    private UUID companyReviewId;

    private UUID companyId;

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

    private int reviewLikeCount;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime deletedAt;

    public ReviewDto() {

    }

    public static List<ReviewDto> createReviews(List<Review> reviewList) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        for (Review review: reviewList) {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto.setCompanyReviewId(review.getCompanyReview().getCompanyReviewId());
            reviewDto.setCompanyId(review.getCompany().getCompanyId());
            reviewDto.setTotalStars(review.getTotalStars());
            reviewDto.setCareerStars(review.getCareerStars());
            reviewDto.setLifeStars(review.getLifeStars());
            reviewDto.setCultureStars(review.getCultureStars());
            reviewDto.setDirectorStars(review.getDirectorStars());
            reviewDto.setSalaryStars(review.getSalaryStars());
            reviewDto.setPositiveContents(review.getPositiveContents());
            reviewDto.setNegativeContents(review.getNegativeContents());
            reviewDto.setProfileId(review.getProfileId());
            reviewDto.setReviewLikeCount(review.getReviewLike().size());
            reviewDto.setCreatedAt(review.getCreatedAt());
            reviewDto.setUpdatedAt(review.getUpdatedAt());
            reviewDtoList.add(reviewDto);
        }
        return reviewDtoList;
    }

    public static ReviewDto createReview(Review review) {
        return ReviewDto.builder()
                .companyReviewId(review.getCompanyReview().getCompanyReviewId())
                .companyId(review.getCompany().getCompanyId())
                .totalStars(review.getTotalStars())
                .careerStars(review.getCareerStars())
                .lifeStars(review.getLifeStars())
                .cultureStars(review.getCultureStars())
                .salaryStars(review.getSalaryStars())
                .directorStars(review.getDirectorStars())
                .positiveContents(review.getPositiveContents())
                .negativeContents(review.getNegativeContents())
                .profileId(review.getProfileId())
                .reviewLikeCount(review.getReviewLike().size())
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .build();
    }
}
