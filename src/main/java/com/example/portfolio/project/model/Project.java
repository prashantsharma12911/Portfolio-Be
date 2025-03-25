package com.example.portfolio.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private int id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DEVELOPED_FOR")
    private String developedFor;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGES")
    private String images ;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "UI_TECH")
    private String uiTech;

    @Column(name = "BE_TECH")
    private String beTech;
}
