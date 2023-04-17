package com.spring.callistoreview.controller;

import com.spring.callistoreview.model.ReviewDto;
import com.spring.callistoreview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews/{companyId}")
    public List<ReviewDto> GetReviews(@PathVariable UUID companyId) throws Exception {
        return reviewService.GetReviews(companyId);
    }

    @PostMapping("/review")
    public void InsertReview(@RequestBody ReviewDto reviewDto) throws Exception {
        reviewService.InsertReview(reviewDto);
    }
}
