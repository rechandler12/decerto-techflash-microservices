package com.decerto.librarymanager.domain

import com.decerto.librarymanager.library.domain.LibraryFacade
import com.decerto.librarymanager.library.domain.command.FindBookCommand
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient
import jakarta.validation.Validator
import spock.lang.Specification
import spock.lang.Subject

class FindBookSpec extends Specification implements SampleFindBookCommand, SampleBook {

    @Subject
    FindBook findBook

    def setup() {
        Validator validator = Stub()
        BookClient bookClient = Stub() {
            isAvailable(_) >> true
        }

        findBook = new LibraryFacade(validator, bookClient)
    }

    def "should find book"() {
        when:
        def dto = findBook.handle(validCommand)

        then:
        dto == expectedBook
    }

    def "should throw NPE when command is null"() {
        when:
        def dto = findBook.handle((FindBookCommand) null)

        then:
        thrown(NullPointerException)
    }
}
