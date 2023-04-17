package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.db.repository.IndustryRepository;
import com.spring.callistoreview.model.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;


    public CompanyDto getCompanyById(UUID companyId) {
        Company company = companyRepository.findByCompanyId(companyId);
        return CompanyDto.builder()
                .companyId(company.getCompanyId())
                .companyName(company.getCompanyName())
                .industryId(company.getIndustry().getIndustryId())
                .industryName(company.getIndustry().getIndustryName())
                .build();
    }
}
