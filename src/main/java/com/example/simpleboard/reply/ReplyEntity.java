package com.example.simpleboard.reply;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "reply")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long postId;
    @Size(max = 50)
    @NotBlank
    private String userName;
    @Size(max = 4)
    @NotBlank
    private String password;
    @Size(max = 100)
    @NotBlank
    private String status;
    @Size(max = 100)
    @NotBlank
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @NotNull
    private LocalDateTime repliedAt;
}
