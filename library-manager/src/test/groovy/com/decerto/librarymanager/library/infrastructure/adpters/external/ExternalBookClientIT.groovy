package com.decerto.librarymanager.library.infrastructure.adpters.external

import com.decerto.librarymanager.BaseIT
import com.decerto.librarymanager.library.domain.dto.OrderBookDto
import com.github.tomakehurst.wiremock.admin.model.ServeEventQuery
import com.github.tomakehurst.wiremock.client.WireMock
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Subject

class ExternalBookClientIT extends BaseIT {

    @Subject
    @Autowired
    private ExternalBookClient externalBookClient

    def cleanup() {
        WireMock.resetAllScenarios()
        WireMock.resetAllRequests()
    }

    def "should return true when book is available"() {
        when:
        def isAvailable = externalBookClient.isAvailable(new OrderBookDto(1L))

        then:
        WireMock.getAllServeEvents(ServeEventQuery.ALL_UNMATCHED).isEmpty()
        isAvailable
    }
}
