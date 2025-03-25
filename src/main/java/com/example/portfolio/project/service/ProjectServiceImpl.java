package com.example.portfolio.project.service;

import com.example.portfolio.common.BaseReponse;
import com.example.portfolio.project.dto.ProjectRequest;
import com.example.portfolio.project.model.Project;
import com.example.portfolio.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

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
}
