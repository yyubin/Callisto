package com.spring.callistoreview.db.entity;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Builder
public class CompanyUser {

    @Id @GeneratedValue
    @Type(type="uuid-char")
    private UUID companyUserId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "companyId")
    private Company company;

    public CompanyUser() {

    }

}
