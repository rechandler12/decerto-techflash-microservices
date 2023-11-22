package com.decerto.librarymanager.domain

import com.decerto.librarymanager.library.domain.dto.BookDto
import groovy.transform.CompileStatic

@CompileStatic
trait SampleBook {
    BookDto expectedBook = new BookDto()
}
