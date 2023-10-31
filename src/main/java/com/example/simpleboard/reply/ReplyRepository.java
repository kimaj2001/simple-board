package com.example.simpleboard.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    /**
     * SELECT * FROM reply WHERE reply.postid = ? And reply.status = ? ORDER BY reply.id DESC
     * @param postId 해당 게시글에 달린 답변을 찾는다.
     * @param status 답변의 상태가 REGISTERED 인지 확인한다.
     * @return 해당 게시글에 달린 모든 답변을 List로 반환한다.
     */
    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, String status);
}
