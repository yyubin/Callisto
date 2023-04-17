package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.Review;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.ReviewRepository;
import com.spring.callistoreview.model.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final CompanyRepository companyRepository;
    private final ReviewRepository reviewRepository;

    public List<ReviewDto> GetReviews(UUID companyId) throws Exception {
        Company company = companyRepository.findByCompanyId(companyId);
        List<Review> reviewList = reviewRepository.findByCompany(company);

        return ReviewDto.createReviews(reviewList);
    }
}
