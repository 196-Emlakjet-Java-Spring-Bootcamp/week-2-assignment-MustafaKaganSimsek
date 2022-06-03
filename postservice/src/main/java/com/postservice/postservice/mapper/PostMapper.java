package com.postservice.postservice.mapper;

import com.postservice.postservice.dto.PostDto;
import com.postservice.postservice.model.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto postToPostDto(Post entity);
    Post postDtoToPost(PostDto dto);
    List<Post> postDtoToPost(List<PostDto> postDto);
    List<PostDto>postToPostDto(List<Post> post);

}
