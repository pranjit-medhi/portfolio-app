package com.main.service;

import com.main.dto.BlogDTO;

import java.util.List;

public interface BlogPostService {
    List<BlogDTO> getAllBlogs();

    BlogDTO getBlogBySlug(String slug);

    BlogDTO createBlog(BlogDTO dto);

    BlogDTO updateBlog(Long id, BlogDTO dto);

    void deleteBlog(Long id);

    List<BlogDTO> getBlogsByTag(String tag);
}
