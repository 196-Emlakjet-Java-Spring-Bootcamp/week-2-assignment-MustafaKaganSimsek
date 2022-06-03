package com.postservice.postservice.mapper;

import com.postservice.postservice.dto.PostDto;
import com.postservice.postservice.model.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-03T19:41:03+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Amazon.com Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto postToPostDto(Post entity) {
        if ( entity == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setId( entity.getId() );
        postDto.setAuthor( entity.getAuthor() );
        postDto.setCategoryEnum( entity.getCategoryEnum() );
        postDto.setTitle( entity.getTitle() );
        postDto.setText( entity.getText() );

        return postDto;
    }

    @Override
    public Post postDtoToPost(PostDto dto) {
        if ( dto == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( dto.getId() );
        post.setAuthor( dto.getAuthor() );
        post.setTitle( dto.getTitle() );
        post.setText( dto.getText() );
        post.setCategoryEnum( dto.getCategoryEnum() );

        return post;
    }

    @Override
    public List<Post> postDtoToPost(List<PostDto> postDto) {
        if ( postDto == null ) {
            return null;
        }

        List<Post> list = new ArrayList<Post>( postDto.size() );
        for ( PostDto postDto1 : postDto ) {
            list.add( postDtoToPost( postDto1 ) );
        }

        return list;
    }

    @Override
    public List<PostDto> postToPostDto(List<Post> post) {
        if ( post == null ) {
            return null;
        }

        List<PostDto> list = new ArrayList<PostDto>( post.size() );
        for ( Post post1 : post ) {
            list.add( postToPostDto( post1 ) );
        }

        return list;
    }
}
