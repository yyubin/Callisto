package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    Company findByCompanyId(UUID companyId);
}
