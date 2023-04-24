package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyReviewRepository extends JpaRepository<CompanyReview, String> {

    CompanyReview findByCompany(Company company);

    CompanyReview findByCompanyReviewId(UUID companyReviewId);

}
