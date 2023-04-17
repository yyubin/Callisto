package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.Company;
import com.spring.callistoreview.db.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, String> {

    List<Review> findByCompany(Company company);


}
