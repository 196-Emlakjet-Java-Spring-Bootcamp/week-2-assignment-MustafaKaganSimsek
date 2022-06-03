package com.postservice.postservice.model;

import com.postservice.postservice.enumerations.CategoryEnum;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long id;

    @Column
    private String author;

    @Column
    private String title ;

    @Column
    private String text;

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryEnum categoryEnum;

    @Column
    private String updatedBy;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedAt;




}