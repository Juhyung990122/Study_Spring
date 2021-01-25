package com.example.spring_practive.repository;

import com.example.spring_practive.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    
}
