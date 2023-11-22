package com.decerto.librarymanager.domain

import com.decerto.librarymanager.BaseIT
import com.decerto.librarymanager.library.domain.command.FindBookCommand
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook
import jakarta.validation.ConstraintViolationException
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject
import spock.lang.Unroll

class FindBookValidationIT extends BaseIT {

    @Subject
    @Autowired
    private FindBook findBook

    @Unroll
    def "should throw ConstraintViolationException with message [#message] when bookId [#bookId], title [#title], subbooks[#subbooks]"() {
        given:
        def command = new FindBookCommand(bookId, title, subbooks)

        when:
        findBook.handle(command)

        then:
        def e = thrown(ConstraintViolationException)
        e.message == message

        where:
        bookId | title   | subbooks || message
        null   | "valid" | []       || "bookId: must not be null"
        1L     | null    | []       || "title: must not be blank"
        1L     | ""      | []       || "title: must not be blank"
        1L     | "  "    | []       || "title: must not be blank"
    }
}
