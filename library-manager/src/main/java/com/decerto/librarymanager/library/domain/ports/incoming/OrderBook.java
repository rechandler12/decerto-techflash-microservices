package com.decerto.librarymanager.library.domain.ports.incoming;

import com.decerto.librarymanager.library.domain.command.OrderBookCommand;
import com.decerto.librarymanager.library.domain.dto.OrderedBookDto;

public interface OrderBook {
    OrderedBookDto handle(OrderBookCommand command);
}
