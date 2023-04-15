package com.spring.callistoreview.db.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class ReviewLike {

    @Id @GeneratedValue
    private UUID reviewLikeId;

    private UUID profileId;

    @ManyToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
