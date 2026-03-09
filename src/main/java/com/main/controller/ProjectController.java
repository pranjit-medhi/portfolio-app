package com.main.controller;

import com.main.dto.ProjectDTO;
import com.main.response.ApiResponse;
import com.main.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectDTO>>> getAllProjects() {
       /**
        final List<ProjectDTO> allProjects = service.getAllProjects();
        final ApiResponse<List<ProjectDTO>> listApiResponse = ApiResponse.success(allProjects);
        return new ResponseEntity<>(listApiResponse, HttpStatus.OK);
    */
        List<ProjectDTO> projects = service.getAllProjects();
        if (projects.isEmpty()) {
            return ResponseEntity.ok(ApiResponse.success("No projects found", projects));
        }

        return ResponseEntity.ok(ApiResponse.success("Projects fetched successfully", projects));
        }

    @GetMapping("/{id}")
    public ProjectDTO getProject(@PathVariable Long id) {
        return service.getProjectById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectDTO>> createProject(@RequestBody ProjectDTO dto) {
        final ProjectDTO project = service.createProject(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success("Project created successfully", project));
    }

    @PutMapping("/{id}")
    public ProjectDTO updateProject(
            @PathVariable Long id,
            @RequestBody ProjectDTO dto
    ) {
        return service.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        service.deleteProject(id);
    }
}
