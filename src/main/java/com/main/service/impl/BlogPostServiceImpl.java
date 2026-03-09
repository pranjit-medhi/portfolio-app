package com.main.service.impl;

import com.main.dto.BlogDTO;
import com.main.entity.BlogPost;
import com.main.repository.BlogRepository;
import com.main.service.BlogPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class BlogPostServiceImpl implements BlogPostService {

    private BlogRepository blogRepository;
    private ModelMapper modelMapper;

    public BlogPostServiceImpl(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.findByPublishedTrue()
                .stream()
                .map(blog-> modelMapper.map(blog, BlogDTO.class))
                .toList();
    }

    @Override
    public BlogDTO getBlogBySlug(String slug) {

        BlogPost post = blogRepository.findBySlug(slug)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        return modelMapper.map(post, BlogDTO.class);
    }

    @Override
    public BlogDTO createBlog(BlogDTO dto) {

        BlogPost post = modelMapper.map(dto, BlogPost.class);

        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());

        BlogPost saved = blogRepository.save(post);

        return modelMapper.map(saved, BlogDTO.class);
    }

    @Override
    public BlogDTO updateBlog(Long id, BlogDTO dto) {


        BlogPost post = blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        post.setUpdatedAt(LocalDateTime.now());

        BlogPost updated = blogRepository.save(post);

        return modelMapper.map(updated, BlogDTO.class);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<BlogDTO> getBlogsByTag(String tag) {

        return blogRepository.findByTagsContaining(tag)
                .stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .toList();
    }
    }

