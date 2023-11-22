package com.decerto.librarymanager.library.infrastructure.web.mvc;

import com.decerto.librarymanager.library.domain.command.FindBookCommand;

record FindBookRequest(String title) {

    FindBookCommand command(Long bookId) {
        return new FindBookCommand(bookId, title, null);
    }
}
