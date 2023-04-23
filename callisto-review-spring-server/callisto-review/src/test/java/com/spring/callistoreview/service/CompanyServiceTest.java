package com.spring.callistoreview.service;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.Industry;
import com.spring.callistoreview.db.repository.CompanyRepository;
import com.spring.callistoreview.model.CompanyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCompanyById() throws Exception {
        UUID companyId = UUID.randomUUID();
        Company company = new Company();

        company.setCompanyId(companyId);
        company.setCompanyName("테스트 회사");

        Industry industry = new Industry();
        industry.setIndustryId(UUID.randomUUID());
        industry.setIndustryName("테스트 산업");
        company.setIndustry(industry);

        Mockito.when(companyRepository.findByCompanyId(companyId)).thenReturn(company);

        CompanyDto result = companyService.getCompanyById(companyId);

        assertNotNull(result);
        assertEquals(company.getCompanyId(), result.getCompanyId());
        assertEquals(company.getCompanyName(), result.getCompanyName());
        assertEquals(company.getIndustry().getIndustryId(), result.getIndustryId());
        assertEquals(company.getIndustry().getIndustryName(), result.getIndustryName());

        Mockito.verify(companyRepository).findByCompanyId(companyId);
    }

}