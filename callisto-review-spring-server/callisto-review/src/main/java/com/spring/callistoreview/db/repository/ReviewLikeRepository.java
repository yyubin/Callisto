package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.ReviewLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewLikeRepository extends JpaRepository<ReviewLike, String> {
}
