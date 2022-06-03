package com.postservice.postservice.controller;

import com.postservice.postservice.dto.PostDto;
import com.postservice.postservice.enumerations.CategoryEnum;
import com.postservice.postservice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    @GetMapping
    public List<PostDto> findAll(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        PostDto post = postService.getPostById(id);
        if (post == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(post);
        }
    }

    @PostMapping("/create")
    public void createPost(@RequestBody PostDto dto){
        postService.createPost(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletepost(@PathVariable Long id) {
        postService.deletePost(id);

    }

    @PostMapping("/update")
    public ResponseEntity updatePost(@RequestBody PostDto dto){
        return postService.updatePost(dto);
    }
    @GetMapping("/author/{author}")
    public ResponseEntity findPostByAuthor(@PathVariable String author){
        return ResponseEntity.ok(postService.findPostByAuthor(author));
    }
    @GetMapping("/category/{categoryName}")
    public PostDto findPostByCategory(@PathVariable CategoryEnum categoryName){
        return postService.findPostByCategory(categoryName);
    }

    @GetMapping("/lastest")
    public List<PostDto> getLatestThreePost(){
        return postService.getLatestThreePost();
    }


}
