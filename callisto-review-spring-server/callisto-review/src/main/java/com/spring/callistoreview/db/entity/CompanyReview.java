package com.spring.callistoreview.db.entity;

import com.spring.callistoreview.model.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public static CompanyReview createReviewAndUpdateCompanyReview(CompanyReview companyReview, ReviewDto review) {
        int oldReviewCount = companyReview.reviewCount;
        int newReviewCount = companyReview.reviewCount + 1;

        double oldTotalStars = companyReview.totalStars * oldReviewCount;
        double oldCareerStars = companyReview.careerStars * oldReviewCount;
        double oldLifeStars = companyReview.lifeStars * oldReviewCount;
        double oldSalaryStars = companyReview.salaryStars * oldReviewCount;
        double oldCultureStars = companyReview.cultureStars * oldReviewCount;
        double oldDirectorStars = companyReview.directorStars * oldReviewCount;

        double newTotalStars = oldTotalStars + review.getTotalStars();
        double newCareerStars = oldCareerStars + review.getCareerStars();
        double newLifeStars = oldLifeStars + review.getLifeStars();
        double newSalaryStars = oldSalaryStars + review.getSalaryStars();
        double newCultureStars = oldCultureStars + review.getCultureStars();
        double newDirectorStars = oldDirectorStars + review.getDirectorStars();

        double newAvgTotalStars = newTotalStars / newReviewCount;
        double newAvgCareerStars = newCareerStars / newReviewCount;
        double newAvgLifeStars = newLifeStars / newReviewCount;
        double newAvgSalaryStars = newSalaryStars / newReviewCount;
        double newAvgCultureStars = newCultureStars / newReviewCount;
        double newAvgDirectorStars = newDirectorStars / newReviewCount;

        return CompanyReview.builder()
                .companyReviewId(companyReview.getCompanyReviewId())
                .company(companyReview.company)
                .totalStars(newAvgTotalStars)
                .careerStars(newAvgCareerStars)
                .lifeStars(newAvgLifeStars)
                .salaryStars(newAvgSalaryStars)
                .cultureStars(newAvgCultureStars)
                .directorStars(newAvgDirectorStars)
                .updatedAt(LocalDateTime.now())
                .build();

    }

}
