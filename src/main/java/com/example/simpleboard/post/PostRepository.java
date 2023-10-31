package com.example.simpleboard.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    /**
     * SELECT * FROM post WHERE post.id = ?1 AND post.status = ?2
     * @param id 해당 id 값을 가진 게시글이 존재하는지 확인한다.
     * @param status 게시글의 상태가 REGISTERED 인지 확인한다.
     * @return 게시글이 존재하지 않을 수 있기 때문에 Optional<>로 리턴한다.
     */
    Optional<PostEntity> findByIdAndStatus(Long id, String status);
}
