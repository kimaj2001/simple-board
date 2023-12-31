package com.example.simpleboard.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {
    private final ReplyService replyService;

    @PostMapping
    public ResponseEntity<ReplyEntity> create(@Valid @RequestBody ReplyRequest replyRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(replyService.create(replyRequest));
    }

}
