package com.postservice.postservice.repository;

import com.postservice.postservice.enumerations.CategoryEnum;
import com.postservice.postservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    @Query("SELECT p FROM Post p WHERE p.author = ?1 ")
    Post findByAuthor(String name);

    @Query("SELECT p FROM Post p WHERE p.categoryEnum = ?1 ")
    Post findByCategory(CategoryEnum categoryEnum);

}