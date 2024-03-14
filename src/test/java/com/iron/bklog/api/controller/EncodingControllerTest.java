package com.iron.bklog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iron.bklog.api.request.EncodingRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URLEncoder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class EncodingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("url 인코딩 테스트")
    void urlEncoder() throws Exception {
        EncodingRequest encRequest = EncodingRequest.builder()
                .encStr("Hello World!")
                .charSet("UTF-8")
                .build();

        String result = URLEncoder.encode(encRequest.getEncStr(), encRequest.getCharSet());

        String json = objectMapper.writeValueAsString(encRequest);

        mockMvc.perform(post("/encoding/url")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(result))
                .andDo(print());


    }

}