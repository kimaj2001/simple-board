package com.example.simpleboard.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostEntity> create(@Valid @RequestBody PostRequest postRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postService.create(postRequest));
    }
}
