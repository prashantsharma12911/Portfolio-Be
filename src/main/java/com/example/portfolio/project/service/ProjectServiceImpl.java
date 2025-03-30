package com.example.portfolio.project.service;

import com.example.portfolio.common.BaseReponse;
import com.example.portfolio.project.dto.ProjectRequest;
import com.example.portfolio.project.dto.ProjectResponse;
import com.example.portfolio.project.model.Project;
import com.example.portfolio.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Object saveProject(ProjectRequest request) {
        if(Objects.isNull(request)){
            return BaseReponse.builder().error(true).message("Invalid request !").build();
        }

        Project project = Objects.nonNull(request.getId()) ? projectRepository.findById(request.getId()).get() : new Project();

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setDevelopedFor(request.getDevelopedFor());
        project.setStartDate(Objects.isNull(request.getStartDate()) ? new Date() : request.getStartDate());
        project.setEndDate(Objects.isNull(request.getEndDate()) ? new Date() : request.getEndDate());
        project.setBeTech(request.getBeTech());
        project.setUiTech(request.getUiTech());
        project.setImages(request.getImages());

        projectRepository.save(project);

        return BaseReponse.builder().error(false).message("Project saved successfully !").data(project).build();

    }

    @Override
    public Object getProjects(String name) {
        List<Project> projects = new ArrayList<>();
        if(StringUtils.hasLength(name)) {
            projects = projectRepository.findByName(name);
        }else{
            projects = projectRepository.findAll();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");

        List<ProjectResponse> responses = new ArrayList<>();
        projects.forEach(p -> responses.add(ProjectResponse.builder()
                        .id(p.getId())
                        .beTech(StringUtils.hasLength(p.getBeTech()) ? Arrays.stream(p.getBeTech().split(",")).collect(Collectors.toList()) : null)
                        .uiTech(StringUtils.hasLength(p.getUiTech()) ? Arrays.stream(p.getUiTech().split(",")).collect(Collectors.toList()) : null)
                        .startDate(Objects.nonNull(p.getStartDate()) ? sdf.format(p.getStartDate()) : null)
                        .endDate(Objects.nonNull(p.getEndDate()) ? sdf.format(p.getEndDate()) : null)
                        .description(p.getDescription())
                        .title(p.getTitle())
                        .developedFor(p.getDevelopedFor())
                        .images(StringUtils.hasLength(p.getImages()) ? Arrays.stream(p.getImages().split(",")).collect(Collectors.toList()) : null)
                .build()));

        return BaseReponse.builder().data(responses).error(false).build();
    }
}
