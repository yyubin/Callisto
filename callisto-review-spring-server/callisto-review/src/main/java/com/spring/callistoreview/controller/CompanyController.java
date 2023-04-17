package com.spring.callistoreview.controller;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.model.CompanyDto;
import com.spring.callistoreview.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/{companyId}")
    public CompanyDto getCompanyById(@PathVariable UUID companyId) throws Exception {
        return companyService.getCompanyById(companyId);
    }

}
