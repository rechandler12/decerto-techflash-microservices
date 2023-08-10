package com.decerto.librarymanager.library.domain.ports.outgoing;

import com.decerto.librarymanager.library.domain.dto.OrderBookDto;

public interface BookClient {
    boolean isAvailable(OrderBookDto dto);
}
