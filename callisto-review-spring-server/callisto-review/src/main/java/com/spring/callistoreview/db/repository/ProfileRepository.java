package com.spring.callistoreview.db.repository;

import com.spring.callistoreview.db.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, String> {

    Profile findByProfileId(UUID profileId);
}
