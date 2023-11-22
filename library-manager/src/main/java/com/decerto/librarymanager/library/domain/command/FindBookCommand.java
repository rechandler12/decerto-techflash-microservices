package com.decerto.librarymanager.library.domain.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record FindBookCommand(@NotNull Long bookId, @NotBlank String title, List<SubBook> subbooks) {

    public record SubBook(@NotBlank String title) {
    }
}
