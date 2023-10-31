package com.example.simpleboard.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {
    private final PostService postService;
    @PostMapping
    public ResponseEntity<PostEntity> create(@Valid @RequestBody PostRequest postRequest) {
        log.info("info : {}", postRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postService.create(postRequest));
    }

    @PostMapping("/view")
    public ResponseEntity<PostEntity> view(@Valid @RequestBody PostViewRequest postViewRequest) {
        log.info("info : {}", postViewRequest);
        return ResponseEntity
                .ok()
                .body(postService.view(postViewRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostEntity>> all() {
        return ResponseEntity
                .ok()
                .body(postService.all());
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@Valid @RequestBody PostViewRequest postViewRequest) {
        log.info("info : {}", postViewRequest);
        postService.delete(postViewRequest);
        return ResponseEntity.ok().build();
    }
}
