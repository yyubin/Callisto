package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyReview;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.CompanyReviewRepository;
import com.spring.callistoreview.model.CompanyReviewDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyReviewServiceTest {

    @InjectMocks
    private CompanyReviewService companyReviewService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private CompanyReviewRepository companyReviewRepository;

    @Test
    public void testGetCompanyReview() throws Exception {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();
        company.setCompanyId(companyId);
        CompanyReview companyReview = new CompanyReview();
        companyReview.setCompany(company);
        companyReview.setReviewCount(5);
        companyReview.setTotalStars(4.5);
        companyReview.setCareerStars(4.0);
        companyReview.setLifeStars(4.5);
        companyReview.setCultureStars(3.5);
        companyReview.setSalaryStars(4.0);

        when(companyRepository.findByCompanyId(companyId)).thenReturn(company);
        when(companyReviewRepository.findByCompany(company)).thenReturn(companyReview);

        CompanyReviewDto result = companyReviewService.GetCompanyReview(companyId);

        assertNotNull(result);
        assertEquals(companyId, result.getCompanyId());
        assertEquals(5, result.getReviewCount());
        assertEquals(4.5, result.getTotalStars(), 0.01);
        assertEquals(4.0, result.getCareerStars(), 0.01);
        assertEquals(4.5, result.getLifeStars(), 0.01);
        assertEquals(3.5, result.getCultureStars(), 0.01);
        assertEquals(4.0, result.getSalaryStars(), 0.01);

        Mockito.verify(companyRepository, times(1)).findByCompanyId(companyId);
        Mockito.verify(companyReviewRepository, times(1)).findByCompany(company);
    }
}