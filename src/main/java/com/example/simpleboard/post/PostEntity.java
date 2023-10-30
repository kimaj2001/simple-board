package com.example.simpleboard.post;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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
    @NotNull
    private Long boardId;
    @Size(max = 50)
    @NotBlank
    private String userName;
    @Size(max = 4)
    @NotBlank
    private String password;
    @Size(max = 100)
    @Email
    @NotBlank
    private String email;
    @Size(max = 100)
    @NotBlank
    private String status;
    @Size(max = 100)
    @NotBlank
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @NotNull
    private LocalDateTime postedAt;
}
