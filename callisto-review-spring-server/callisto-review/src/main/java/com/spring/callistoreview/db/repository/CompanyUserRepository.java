package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.CompanyUser;
import com.spring.callistoreview.db.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyUserRepository extends JpaRepository<CompanyUser, String> {

    boolean findByCompanyAndProfile(Company company, Profile profile);
}
