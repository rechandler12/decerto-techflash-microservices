package com.decerto.librarymanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
public class ExampleRestController {

    @GetMapping
    String hello() {
        return "Hello World";
    }
}
