package com.example.portfolio.project.service;

import com.example.portfolio.project.dto.ProjectRequest;

public interface ProjectService {
    Object saveProject(ProjectRequest request);

    Object getProjects(String name);
}
