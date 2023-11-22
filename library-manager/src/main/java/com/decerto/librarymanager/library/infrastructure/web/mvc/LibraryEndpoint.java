package com.decerto.librarymanager.library.infrastructure.web.mvc;

import com.decerto.librarymanager.library.domain.command.OrderBookCommand;
import com.decerto.librarymanager.library.domain.dto.OrderedBookDto;
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook;
import com.decerto.librarymanager.library.domain.ports.incoming.OrderBook;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("{bookId}")
    FindBookResponse findBook(@PathVariable Long bookId, @RequestBody FindBookRequest request) {
        var command = request.command(bookId);
        findBook.handle(command);
        return new FindBookResponse(request.title());
    }

    @GetMapping("order/{bookId}")
    void orderBook(@PathVariable Long bookId) {
        log.info("bookId: {}", bookId);
        OrderedBookDto orderedBookDto = Optional.of(bookId)
                .map(OrderBookCommand::new)
                .map(orderBook::handle)
                .orElseThrow();
    }
}
