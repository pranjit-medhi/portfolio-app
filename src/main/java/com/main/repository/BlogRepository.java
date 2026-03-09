package com.main.repository;

import com.main.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<BlogPost, Long> {

    Optional<BlogPost> findBySlug(String slug);

    List<BlogPost> findByPublishedTrue();

    List<BlogPost> findByTagsContaining(String tag);
}
