package com.example.simpleboard.post;

import com.example.simpleboard.reply.ReplyEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "post")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long boardId;
    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;
    @Transient
    private List<ReplyEntity> replyList = new ArrayList<>();
}
