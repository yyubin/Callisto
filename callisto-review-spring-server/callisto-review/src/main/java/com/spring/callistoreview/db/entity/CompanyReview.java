package com.spring.callistoreview.db.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CompanyReview {

    @Id @GeneratedValue
    @Type(type="uuid-char")
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

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    private LocalDateTime deletedAt;

}
