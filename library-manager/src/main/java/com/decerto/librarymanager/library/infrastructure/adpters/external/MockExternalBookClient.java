package com.decerto.librarymanager.library.infrastructure.adpters.external;

import com.decerto.librarymanager.library.domain.dto.OrderBookDto;
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient;

public class MockExternalBookClient implements BookClient {
    @Override
    public boolean isAvailable(OrderBookDto command) {
        return false;
    }
}
