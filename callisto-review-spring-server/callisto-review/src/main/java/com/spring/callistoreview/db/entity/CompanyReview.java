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

    public void setCompanyReviewId(UUID companyReviewId) {
        this.companyReviewId = companyReviewId;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public void setTotalStars(double totalStars) {
        this.totalStars = totalStars;
    }

    public void setCareerStars(double careerStars) {
        this.careerStars = careerStars;
    }

    public void setLifeStars(double lifeStars) {
        this.lifeStars = lifeStars;
    }

    public void setSalaryStars(double salaryStars) {
        this.salaryStars = salaryStars;
    }

    public void setCultureStars(double cultureStars) {
        this.cultureStars = cultureStars;
    }

    public void setDirectorStars(double directorStars) {
        this.directorStars = directorStars;
    }


}
