package com.postservice.postservice.dto;

import com.postservice.postservice.enumerations.CategoryEnum;
import lombok.Data;

@Data
public class PostDto {

    private Long id;

    private String author;

    private CategoryEnum categoryEnum;

    private String title ;

    private String text;

}
