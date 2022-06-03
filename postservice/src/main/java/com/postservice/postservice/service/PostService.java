package com.postservice.postservice.service;

import com.postservice.postservice.dto.PostDto;
import com.postservice.postservice.enumerations.CategoryEnum;
import com.postservice.postservice.mapper.PostMapper;
import com.postservice.postservice.model.Post;
import com.postservice.postservice.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public List<PostDto> getAllPosts(){
        return postMapper.postToPostDto(postRepository.findAll());
    }

    public PostDto getPostById(Long id){
        Optional<Post> optionalPost =postRepository.findById(id);
        //Optional check
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            return postMapper.postToPostDto(post);
        }
        else {
            return null;
        }
    }

    public void createPost(PostDto postDto){
        postRepository.save(postMapper.postDtoToPost(postDto));
    }
    public void deletePost(Long id){
        Optional<Post> optionalPost = postRepository.findById(id);
        //Optional check
        if (optionalPost.isPresent()){
            Post post = optionalPost.get();
            postRepository.delete(post);
        }

    }
    public ResponseEntity updatePost(PostDto postDto){
        Optional<Post> post  = postRepository.findById(postDto.getId());
        if(post.isPresent()){
            postRepository.save(postMapper.postDtoToPost(postDto));
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public PostDto findPostByAuthor(String author){
        return postMapper.postToPostDto(postRepository.findByAuthor(author));
    }
    public PostDto findPostByCategory(CategoryEnum categoryName){
        return postMapper.postToPostDto(postRepository.findByCategory(categoryName));
    }
    //lastest three item
    public List<PostDto> getLatestThreePost(){
        return postMapper.postToPostDto( postRepository
                .findAll()
                .stream()
                .sorted(Comparator
                        .comparing(Post::getCreatedAt)
                        .reversed())
                .limit(3)
                .collect(Collectors.toList()));

    }
}
