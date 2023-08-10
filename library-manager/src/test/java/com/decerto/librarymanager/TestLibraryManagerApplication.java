package com.decerto.librarymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestLibraryManagerApplication {

    public static void main(String[] args) {
        SpringApplication.from(LibraryManagerApplication::main).with(TestLibraryManagerApplication.class).run(args);
    }

}
