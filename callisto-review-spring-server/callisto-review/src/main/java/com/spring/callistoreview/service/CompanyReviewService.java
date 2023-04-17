package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.CompanyReviewRepository;
import com.spring.callistoreview.model.CompanyReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyReviewService {

    private final CompanyReviewRepository companyReviewRepository;
    private final CompanyRepository companyRepository;

    public CompanyReviewDto GetCompanyReview(UUID companyId)throws Exception {
        Company company = companyRepository.findByCompanyId(companyId);
        CompanyReview companyReviewList = companyReviewRepository.findByCompany(company);

        return CompanyReviewDto.createCompanyReviewDto(companyReviewList);
    }
}
