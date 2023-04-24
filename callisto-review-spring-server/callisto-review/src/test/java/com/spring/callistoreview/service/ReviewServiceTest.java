package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import com.spring.callistoreview.db.entity.Profile;
import com.spring.callistoreview.db.entity.Review;
import com.spring.callistoreview.db.repository.*;
import com.spring.callistoreview.model.CompanyReviewDto;
import com.spring.callistoreview.model.ReviewDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private CompanyUserRepository companyUserRepository;

    @Mock
    private CompanyReviewRepository companyReviewRepository;

    @Test
    void testGetReviews() throws Exception {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setCompanyId(companyId);
        List<Review> reviewList = new ArrayList<>();

        Review review1 = new Review();
        // Set review1 properties
        reviewList.add(review1);
        review1.setCompany(company);

        Review review2 = new Review();
        // Set review2 properties
        reviewList.add(review2);
        review2.setCompany(company);

        when(companyRepository.findByCompanyId(companyId)).thenReturn(company);
        when(reviewRepository.findByCompany(company)).thenReturn(reviewList);

        // When
        List<ReviewDto> result = reviewService.GetReviews(companyId);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateReviews() {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setCompanyId(companyId);

        List<Review> reviewList = new ArrayList<>();
        Review review1 = new Review();
        review1.setCompany(company);
        // Set review1 properties
        reviewList.add(review1);
        Review review2 = new Review();
        review2.setCompany(company);
        // Set review2 properties
        reviewList.add(review2);

        // When
        List<ReviewDto> result = ReviewDto.createReviews(reviewList);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testInsertReview() throws Exception {

        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setCompanyId(companyId);

        Profile profile = new Profile();
        profile.setProfileId(UUID.randomUUID());

        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setCompanyId(companyId);
        reviewDto.setProfileId(profile.getProfileId());
        reviewDto.setTotalStars(4.5);
        reviewDto.setCareerStars(4.0);
        reviewDto.setLifeStars(3.5);
        reviewDto.setSalaryStars(3.0);
        reviewDto.setCultureStars(4.5);
        reviewDto.setDirectorStars(3.0);

        CompanyReview companyReview = new CompanyReview();
        companyReview.setCompany(company);
        companyReview.setTotalStars(4.0);
        companyReview.setCareerStars(3.5);
        companyReview.setLifeStars(3.0);
        companyReview.setSalaryStars(3.5);
        companyReview.setCultureStars(3.0);
        companyReview.setDirectorStars(3.5);

        when(companyRepository.findByCompanyId(companyId)).thenReturn(company);
        when(profileRepository.findByProfileId(profile.getProfileId())).thenReturn(profile);
        when(companyUserRepository.findByCompanyAndProfile(company, profile)).thenReturn(true);
        when(companyReviewRepository.findByCompany(company)).thenReturn(companyReview);

        reviewService.InsertReview(reviewDto);

        Mockito.verify(reviewRepository, times(1)).save(any(Review.class));
        Mockito.verify(companyReviewRepository, times(1)).save(any(CompanyReview.class));
    }

}