package com.example.portfolio.project.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProjectResponse {
    private Integer id;
    private String title;
    private String developedFor;
    private String description;
    private List<String> images ;
    private String startDate;
    private String endDate;
    private List<String> uiTech;
    private List<String> beTech;
}
