package com.decerto.librarymanager.library.domain;

import com.decerto.librarymanager.library.domain.command.FindBookCommand;
import com.decerto.librarymanager.library.domain.command.OrderBookCommand;
import com.decerto.librarymanager.library.domain.dto.BookDto;
import com.decerto.librarymanager.library.domain.dto.OrderBookDto;
import com.decerto.librarymanager.library.domain.dto.OrderedBookDto;
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook;
import com.decerto.librarymanager.library.domain.ports.incoming.OrderBook;
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class LibraryFacade implements FindBook, OrderBook {
    private final BookClient bookClient;

    @Override
    public BookDto handle(FindBookCommand command) {
        return new BookDto();
    }

    @Override
    public OrderedBookDto handle(OrderBookCommand command) {
        log.info("LibraryFacade: {}", command);
        bookClient.isAvailable(new OrderBookDto(command.bookId()));
        return new OrderedBookDto();
    }
}
