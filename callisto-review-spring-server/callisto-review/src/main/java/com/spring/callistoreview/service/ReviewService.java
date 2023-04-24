package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.*;
import com.spring.callistoreview.db.repository.*;
import com.spring.callistoreview.exception.ErrorMessage;
import com.spring.callistoreview.exception.NotFoundProfileException;
import com.spring.callistoreview.model.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

        reviewRepository.save(Review.createReview(reviewDto, company));
        companyReviewRepository.save(CreateReviewAndUpdateCompanyReview(companyReview, reviewDto));
    }

    @Transactional
    public void DeleteReview(UUID profileId) throws Exception {
        // (추가 예정) JWT parser 사용해서 받은 profileId와 jwt 로그인 아이디가 동일한지 확인해야 함
        Review review = reviewRepository.findByProfileId(profileId);
        CompanyReview companyReview = companyReviewRepository.findByCompanyReviewId(review.getCompanyReviewId());


        reviewRepository.deleteByProfileId(profileId);
        companyReviewRepository.save(DeleteReviewAndUpdateCompanyReview(companyReview, review));
    }

    public CompanyReview CreateReviewAndUpdateCompanyReview(CompanyReview companyReview, ReviewDto review) {
        int oldReviewCount = companyReview.getReviewCount();
        int newReviewCount = companyReview.getReviewCount() + 1;

        double oldTotalStars = companyReview.getTotalStars() * oldReviewCount;
        double oldCareerStars = companyReview.getCareerStars() * oldReviewCount;
        double oldLifeStars = companyReview.getLifeStars() * oldReviewCount;
        double oldSalaryStars = companyReview.getSalaryStars() * oldReviewCount;
        double oldCultureStars = companyReview.getCultureStars() * oldReviewCount;
        double oldDirectorStars = companyReview.getDirectorStars() * oldReviewCount;

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
                .company(companyReview.getCompany())
                .totalStars(newAvgTotalStars)
                .careerStars(newAvgCareerStars)
                .lifeStars(newAvgLifeStars)
                .salaryStars(newAvgSalaryStars)
                .cultureStars(newAvgCultureStars)
                .directorStars(newAvgDirectorStars)
                .updatedAt(LocalDateTime.now())
                .build();

    }

    public CompanyReview DeleteReviewAndUpdateCompanyReview(CompanyReview companyReview, Review review) {
        int oldReviewCount = companyReview.getReviewCount();
        int newReviewCount = companyReview.getReviewCount() - 1;

        double oldTotalStars = companyReview.getTotalStars() * oldReviewCount;
        double oldCareerStars = companyReview.getCareerStars() * oldReviewCount;
        double oldLifeStars = companyReview.getLifeStars() * oldReviewCount;
        double oldSalaryStars = companyReview.getSalaryStars() * oldReviewCount;
        double oldCultureStars = companyReview.getCultureStars() * oldReviewCount;
        double oldDirectorStars = companyReview.getDirectorStars() * oldReviewCount;

        double newTotalStars = oldTotalStars - review.getTotalStars();
        double newCareerStars = oldCareerStars - review.getCareerStars();
        double newLifeStars = oldLifeStars - review.getLifeStars();
        double newSalaryStars = oldSalaryStars - review.getSalaryStars();
        double newCultureStars = oldCultureStars - review.getCultureStars();
        double newDirectorStars = oldDirectorStars - review.getDirectorStars();

        double newAvgTotalStars = newTotalStars / newReviewCount;
        double newAvgCareerStars = newCareerStars / newReviewCount;
        double newAvgLifeStars = newLifeStars / newReviewCount;
        double newAvgSalaryStars = newSalaryStars / newReviewCount;
        double newAvgCultureStars = newCultureStars / newReviewCount;
        double newAvgDirectorStars = newDirectorStars / newReviewCount;

        return CompanyReview.builder()
                .companyReviewId(companyReview.getCompanyReviewId())
                .company(companyReview.getCompany())
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
