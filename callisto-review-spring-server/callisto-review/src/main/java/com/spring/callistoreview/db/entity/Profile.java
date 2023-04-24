package com.spring.callistoreview.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    private UUID profileId;

    private String nickname;

    private int userClassId;

    private int jobId;

}
