package com.decerto.librarymanager.library.infrastructure.configuration;

import com.decerto.librarymanager.library.domain.LibraryFacade;
import com.decerto.librarymanager.library.domain.ports.incoming.FindBook;
import com.decerto.librarymanager.library.domain.ports.incoming.OrderBook;
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient;
import com.decerto.librarymanager.library.infrastructure.adpters.external.MockExternalBookClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class LibraryConfiguration {

    @Bean
    FindBook findBook(BookClient bookClient) {
        return new LibraryFacade(bookClient);
    }

    @Bean
    OrderBook orderBook(BookClient bookClient) {
        return new LibraryFacade(bookClient);
    }

    static FindBook findBook() {
        return new LibraryFacade(new MockExternalBookClient());
    }

    static OrderBook orderBook() {
        return new LibraryFacade(new MockExternalBookClient());
    }
}
