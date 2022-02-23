package com.my.api.rest.v1.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.my.api.rest.v1.domain.req.DataRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers

@AutoConfigureMockMvc
@SpringBootTest
internal class DataControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun createData() {

        val dataRequest = DataRequest("aa", "a1a1")
        val reqStr = objectMapper.writeValueAsString(dataRequest)
        val uri = "/v1/data"

        mockMvc.perform(
            MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "")
                .content(reqStr)
        ).andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun getData() {

        val uri = "/v1/data"

        mockMvc.perform(
            MockMvcRequestBuilders.get(uri)
                .header("Authorization", "")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(MockMvcResultHandlers.print())
    }
}
