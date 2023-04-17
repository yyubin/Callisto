package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.*;
import com.spring.callistoreview.db.repository.*;
import com.spring.callistoreview.exception.ErrorMessage;
import com.spring.callistoreview.exception.NotFoundProfileException;
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
    private final ProfileRepository profileRepository;
    private final CompanyUserRepository companyUserRepository;

    public List<ReviewDto> GetReviews(UUID companyId) throws Exception {
        Company company = companyRepository.findByCompanyId(companyId);
        List<Review> reviewList = reviewRepository.findByCompany(company);

        return ReviewDto.createReviews(reviewList);
    }

    @Transactional
    public void InsertReview(ReviewDto reviewDto) throws Exception {
        Company company = companyRepository.findByCompanyId(reviewDto.getCompanyId());
        Profile profile = profileRepository.findByProfileId(reviewDto.getProfileId());

        if (!companyUserRepository.findByCompanyAndProfile(company, profile)) {
            throw new NotFoundProfileException(ErrorMessage.NOT_MATCH_USER_COMPANY.getMessage());
        }

        CompanyReview companyReview = companyReviewRepository.findByCompany(company);

        reviewRepository.save(Review.createReview(reviewDto, company, companyReview));
        companyReviewRepository.save(CompanyReview.createReviewAndUpdateCompanyReview(companyReview, reviewDto));
    }
}
