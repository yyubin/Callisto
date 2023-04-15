package com.spring.callistoreview.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
public class CompanyDto {

    private UUID companyId;

    private String companyName;

    private UUID industryId;

    private String industryName;


}
