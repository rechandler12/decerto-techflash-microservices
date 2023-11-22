package com.decerto.librarymanager.library.infrastructure.web.mvc

import com.decerto.librarymanager.BaseIT
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.admin.model.ServeEventQuery
import com.github.tomakehurst.wiremock.client.WireMock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class LibraryEndpointAcceptanceIT extends BaseIT {

    @Autowired
    private ObjectMapper objectMapper

    def "should find book"() {
        given:
        def request = new FindBookRequest("title")

        expect:
        mvc.perform(get("/library/1").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                {
                  "title": "title"
                }
                """))
        WireMock.getAllServeEvents(ServeEventQuery.ALL_UNMATCHED).isEmpty()
    }

}
