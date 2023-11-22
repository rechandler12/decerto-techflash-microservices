package com.decerto.librarymanager

import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

@Testcontainers
@SpringBootTest
@ContextConfiguration
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
@TestPropertySource(properties = [
        'spring.cloud.discovery.client.simple.instances.book[0].uri=http://localhost:${wiremock.server.port}'
])
class BaseIT extends Specification {

    @Autowired
    protected MockMvc mvc

    @TestConfiguration(proxyBeanMethods = false)
    static class BaseConfiguration {

        @PostConstruct
        static void configureDefaultLocale() {
            LocaleContextHolder.setDefaultLocale(Locale.US)
        }
    }
}
