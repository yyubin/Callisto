package com.spring.callistoreview.db.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Company {

    @Id @GeneratedValue
    private UUID companyId;

    private String companyName;

    @ManyToOne
    @JoinColumn(name = "industryId")
    private Industry industry;

    @OneToOne
    @JoinColumn(name = "companyImageId")
    private CompanyImage companyImage;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;
}
