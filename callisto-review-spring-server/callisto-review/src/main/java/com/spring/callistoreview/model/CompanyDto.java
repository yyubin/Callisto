package com.spring.callistoreview.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private UUID companyId;

    private String companyName;

    private UUID industryId;

    private String industryName;


}
