package com.spring.callistoreview.controller;

import com.spring.callistoreview.model.CompanyReviewDto;
import com.spring.callistoreview.service.CompanyReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company/review")
public class CompanyReviewController {

    private final CompanyReviewService companyReviewService;

    @GetMapping("/{companyId}")
    public CompanyReviewDto GetCompanyReview(@PathVariable UUID companyId) throws Exception {
        return companyReviewService.GetCompanyReview(companyId);
    }

}
