package com.example.portfolio.project.repository;

import com.example.portfolio.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    @Query(value = "select p from Project p where (:name is null or p.title =:name)")
    List<Project> findByName(String name);
}
