package com.decerto.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("books")
public class BookController {

    @GetMapping("{bookId}:isAvailable")
    boolean isAvailable(@PathVariable Long bookId) {
        log.info("bookId: {}", bookId);
        return true;
    }
}
