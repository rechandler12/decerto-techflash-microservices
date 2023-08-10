package com.decerto.librarymanager.library.infrastructure.adpters.external;

import com.decerto.librarymanager.library.domain.dto.OrderBookDto;
import com.decerto.librarymanager.library.domain.ports.outgoing.BookClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class ExternalBookClient implements BookClient {
    private final BookFeignClient bookFeignClient;

    @Override
    public boolean isAvailable(OrderBookDto dto) {
        log.info("LibraryFacade: {}", dto);
        return bookFeignClient.isAvailable(dto.bookId());
    }
}
