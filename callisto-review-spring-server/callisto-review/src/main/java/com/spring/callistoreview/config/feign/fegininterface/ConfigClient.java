package com.spring.callistoreview.config.feign.fegininterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "callisto-config-server")
public interface ConfigClient {

    @PostMapping ("/config/point/{profile_id}")
    void AddPointOfReview(@PathVariable String profile_id);

}
