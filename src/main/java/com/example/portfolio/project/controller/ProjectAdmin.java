package com.example.portfolio.project.controller;

import com.example.portfolio.project.dto.ProjectRequest;
import com.example.portfolio.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/project")
public class ProjectAdmin {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/saveProject" , consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> saveProject(@RequestBody(required = true) ProjectRequest request){
        return ResponseEntity.ok(projectService.saveProject(request));
    }
}
