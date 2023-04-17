package com.spring.callistoreview.controller;

import com.spring.callistoreview.model.ReviewDto;
import com.spring.callistoreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{companyId}")
    public List<ReviewDto> GetReviews(@PathVariable UUID companyId) throws Exception {
        return reviewService.GetReviews(companyId);
    }
}
