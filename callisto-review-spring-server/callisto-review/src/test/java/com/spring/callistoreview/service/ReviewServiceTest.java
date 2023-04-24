package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.Review;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.ReviewRepository;
import com.spring.callistoreview.model.ReviewDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @InjectMocks
    private ReviewService reviewService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ReviewRepository reviewRepository;

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
}