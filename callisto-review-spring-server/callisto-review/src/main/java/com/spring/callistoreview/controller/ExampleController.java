package com.spring.callistoreview.controller;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.Industry;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.IndustryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final IndustryRepository industryRepository;
    private final CompanyRepository companyRepository;

    @GetMapping("/example-data")
    public String initializingData() {
        Industry industry = new Industry();
        industry.setIndustryName("IT");

        industryRepository.save(industry);

        Company company = new Company();
        company.setCompanyName("Example Company");
        company.setIndustry(industry);

        companyRepository.save(company);

        return company.getCompanyId().toString();
    }
}
