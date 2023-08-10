package com.decerto.librarymanager.library.domain.ports.incoming;

import com.decerto.librarymanager.library.domain.command.FindBookCommand;
import com.decerto.librarymanager.library.domain.dto.BookDto;

public interface FindBook {
    BookDto handle(FindBookCommand command);
}
