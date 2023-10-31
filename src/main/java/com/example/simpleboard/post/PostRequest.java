package com.example.simpleboard.post;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequest {
    @Size(max = 50)
    @NotBlank
    private String userName;
    @Size(min = 4, max = 4)
    @NotBlank
    private String password;
    @Size(max = 100)
    @Email
    @NotBlank
    private String email;
    @Size(max = 100)
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
