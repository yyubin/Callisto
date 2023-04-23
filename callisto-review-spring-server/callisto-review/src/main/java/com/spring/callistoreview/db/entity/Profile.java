package com.spring.callistoreview.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Profile {

    @Id
    private UUID profileId;

    private String nickname;

    private int userClassId;

    private int jobId;

    public Profile() {

    }
}
