package com.spring.callistoreview.db.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CompanyReview {

    @Id @GeneratedValue
    private UUID companyReviewId;

    @OneToOne
    @JoinColumn(name = "companyId")
    private Company company;

    private int reviewCount;

    private double totalStars;

    private double careerStars;

    private double lifeStars;

    private double salaryStars;

    private double cultureStars;

    private double directorStars;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
