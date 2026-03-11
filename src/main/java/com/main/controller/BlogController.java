package com.main.controller;

import com.main.dto.BlogDTO;
import com.main.service.BlogPostService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {
    private final BlogPostService service;

    public BlogController(BlogPostService service) {
        this.service = service;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public List<BlogDTO> getAllBlogs() {
        return service.getAllBlogs();
    }

    @GetMapping("/{slug}")
    public BlogDTO getBlog(@PathVariable String slug) {
        return service.getBlogBySlug(slug);
    }

    @PostMapping
    public BlogDTO createBlog(@RequestBody BlogDTO dto) {
        return service.createBlog(dto);
    }

    @PutMapping("/{id}")
    public BlogDTO updateBlog(@PathVariable Long id,
                              @RequestBody BlogDTO dto) {
        return service.updateBlog(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Long id) {
        service.deleteBlog(id);
    }

    @GetMapping("/tag/{tag}")
    public List<BlogDTO> getBlogsByTag(@PathVariable String tag) {
        return service.getBlogsByTag(tag);
    }
}
