package com.spring.callistoreview.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Review {

    @Id @GeneratedValue
    private UUID reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyReviewId")
    private CompanyReview companyReview;

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

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
