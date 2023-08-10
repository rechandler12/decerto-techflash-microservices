package com.decerto.librarymanager.library.infrastructure.mvc;

import com.decerto.librarymanager.library.domain.command.FindBookCommand;
import com.decerto.librarymanager.library.domain.command.OrderBookCommand;
import com.decerto.librarymanager.library.domain.dto.OrderedBookDto;
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook;
import com.decerto.librarymanager.library.domain.ports.incoming.OrderBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("library")
@RequiredArgsConstructor
class LibraryEndpoint {
    private final FindBook findBook;
    private final OrderBook orderBook;

    @GetMapping
    void findBook() {
        findBook.handle(new FindBookCommand());
    }

    @GetMapping("order/{bookId}")
    void orderBook(@PathVariable Long bookId) {
        log.info("bookId: {}", bookId);
        OrderedBookDto orderedBookDto = Optional.ofNullable(bookId)
                .map(OrderBookCommand::new)
                .map(orderBook::handle)
                .orElseThrow();
    }
}
