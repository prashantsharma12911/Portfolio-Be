package com.example.portfolio.project.controller;

import com.example.portfolio.common.BaseReponse;
import com.example.portfolio.constants.ApplicationConstants;
import com.example.portfolio.project.dto.ProjectRequest;
import com.example.portfolio.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectAdmin {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/saveProject")
    public ResponseEntity<Object> saveProject(@RequestBody(required = true) ProjectRequest request){
        return ResponseEntity.ok(projectService.saveProject(request));
    }

    @GetMapping(value = "/getProject" )
    public ResponseEntity<Object> getProjects( @RequestParam(required = false) String name ){
        return ResponseEntity.ok(projectService.getProjects(name));
    }
}
