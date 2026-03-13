package com.main.service.impl;

import com.main.dto.ProjectDTO;
import com.main.entity.Project;
import com.main.event.ProjectEvent;
import com.main.exception.ResourceNotFound;
import com.main.repository.ProjectRepository;
import com.main.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final ModelMapper mapper;
    private final ApplicationEventPublisher publisher;

    public ProjectServiceImpl(ProjectRepository repository, ModelMapper mapper, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.mapper = mapper;
        this.publisher = publisher;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return repository.findAll()
                .stream()
                .map(project -> mapper.map(project, ProjectDTO.class))
                .toList();
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Project not found with id: " + id));

        return mapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO createProject(ProjectDTO dto) {
        Project project = mapper.map(dto, Project.class);
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        Project savedProject = repository.save(project);
        publisher.publishEvent(new ProjectEvent("Project Created"));
        return mapper.map(savedProject, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        Project existingProject = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Project not found with id: " + id));
        mapper.map(dto, existingProject);
        existingProject.setUpdatedAt(LocalDateTime.now());
        Project updatedProject = repository.save(existingProject);
        return mapper.map(updatedProject, ProjectDTO.class);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Project not found with id: " + id));
        repository.delete(project);
    }
}
