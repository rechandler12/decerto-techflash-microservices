package com.decerto.librarymanager.library.domain;

import com.decerto.librarymanager.library.domain.command.FindBookCommand;
import com.decerto.librarymanager.library.domain.command.OrderBookCommand;
import com.decerto.librarymanager.library.domain.dto.BookDto;
import com.decerto.librarymanager.library.domain.dto.OrderBookDto;
import com.decerto.librarymanager.library.domain.dto.OrderedBookDto;
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook;
import com.decerto.librarymanager.library.domain.ports.incoming.OrderBook;
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient;
import jakarta.validation.Validator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibraryFacade implements FindBook, OrderBook {
    private final CommandValidator commandValidator;
    private final BookClient bookClient;

    public LibraryFacade(Validator validator, BookClient bookClient) {
        this.commandValidator = new CommandValidator(validator);
        this.bookClient = bookClient;
    }

    @Override
    public BookDto handle(@NonNull FindBookCommand command) {
        commandValidator.validate(command);
        log.info("LibraryFacade: {}", command);
        bookClient.isAvailable(new OrderBookDto(1L));
        return new BookDto();
    }

    @Override
    public OrderedBookDto handle(@NonNull OrderBookCommand command) {
        log.info("LibraryFacade: {}", command);
        bookClient.isAvailable(new OrderBookDto(command.bookId()));
        return new OrderedBookDto();
    }
}
