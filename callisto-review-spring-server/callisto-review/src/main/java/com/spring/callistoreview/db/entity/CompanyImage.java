package com.spring.callistoreview.db.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;

@Entity
public class CompanyImage {

    @Id
    @Type(type="uuid-char")
    private UUID companyImageId;

    @OneToOne
    @JoinColumn(name = "companyId")
    private Company company;

    private String ImageId;

}
