package com.example.simpleboard.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostEntity create(PostRequest postRequest) {
        var entity = PostEntity.builder()
                .boardId(1L) // 임시 고정
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .status("REGISTERED")
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    /**
     * 하나의 게시글을 리턴한다.
     * [확인사항]
     * 1. 게시글이 있는가?
     * 2. 비밀번호가 맞는가?
     * @param postViewRequest 게시글의 Id값과 해당 작성자의 패스워드가 담겨있다.
     * @return 게시글이 있다면 PostEntity 를 반환한다.
     */
    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findByIdAndStatus(postViewRequest.getPostId(), "REGISTERED")
                .map(it -> {
                    if (!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }
                    return it;
                })
                .orElseThrow( () ->
                        new RuntimeException("해당 게시글이 존재 하지 않습니다. : " + postViewRequest.getPostId())
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    /**
     * 하나의 게시글을 삭제한다.
     * [확인사항]
     * 1. 게시글이 있는가?
     * 2. 비밀번호가 맞는가?
     * @param postViewRequest 게시글의 Id값과 해당 작성자의 패스워드가 담겨있다.
     */
    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
                .map(it -> {
                    if (!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }
                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                })
                .orElseThrow( () ->
                        new RuntimeException("해당 게시글이 존재 하지 않습니다. : " + postViewRequest.getPostId())
                );
    }
}
