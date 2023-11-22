package com.decerto.librarymanager.domain

import com.decerto.librarymanager.library.domain.command.FindBookCommand

trait SampleFindBookCommand {
    FindBookCommand validCommand = new FindBookCommand(1L, "asdf", [])

}
