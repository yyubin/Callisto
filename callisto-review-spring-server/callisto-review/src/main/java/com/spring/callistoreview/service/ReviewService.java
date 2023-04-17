package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import com.spring.callistoreview.db.entity.Review;
import com.spring.callistoreview.db.entity.ReviewLike;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.CompanyReviewRepository;
import com.spring.callistoreview.db.repository.ReviewLikeRepository;
import com.spring.callistoreview.db.repository.ReviewRepository;
import com.spring.callistoreview.model.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final CompanyRepository companyRepository;

    private final CompanyReviewRepository companyReviewRepository;
    private final ReviewRepository reviewRepository;

    public List<ReviewDto> GetReviews(UUID companyId) throws Exception {
        Company company = companyRepository.findByCompanyId(companyId);
        List<Review> reviewList = reviewRepository.findByCompany(company);

        return ReviewDto.createReviews(reviewList);
    }

    @Transactional
    public void InsertReview(ReviewDto reviewDto) throws Exception {
        Company company = companyRepository.findByCompanyId(reviewDto.getCompanyId());
        CompanyReview companyReview = companyReviewRepository.findByCompany(company);

        reviewRepository.save(Review.createReview(reviewDto, company, companyReview));
        companyReviewRepository.save(CompanyReview.createReviewAndUpdateCompanyReview(companyReview, reviewDto));
    }
}
