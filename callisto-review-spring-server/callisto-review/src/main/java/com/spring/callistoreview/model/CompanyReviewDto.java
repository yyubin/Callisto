package com.spring.callistoreview.model;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CompanyReviewDto {

    private UUID companyReviewId;

    private UUID companyId;

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

    public CompanyReviewDto() {

    }

    public static CompanyReviewDto createCompanyReviewDto(CompanyReview companyReview) {
        return CompanyReviewDto.builder()
                .companyReviewId(companyReview.getCompanyReviewId())
                .companyId(companyReview.getCompany().getCompanyId())
                .reviewCount(companyReview.getReviewCount())
                .totalStars(companyReview.getTotalStars())
                .careerStars(companyReview.getCareerStars())
                .lifeStars(companyReview.getLifeStars())
                .cultureStars(companyReview.getCultureStars())
                .salaryStars(companyReview.getSalaryStars())
                .build();
    }
}
