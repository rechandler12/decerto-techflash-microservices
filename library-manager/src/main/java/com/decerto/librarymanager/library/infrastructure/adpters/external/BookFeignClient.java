package com.decerto.librarymanager.library.infrastructure.adpters.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book", contextId = "BookFeignClient")
interface BookFeignClient {

    @GetMapping("books/{bookId}:isAvailable")
    boolean isAvailable(@PathVariable Long bookId);
}
