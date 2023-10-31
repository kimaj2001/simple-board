package com.example.simpleboard.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardEntity> create(@Valid @RequestBody BoardRequest boardRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(boardService.create(boardRequest));
    }

}
