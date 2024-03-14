package com.iron.bklog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iron.bklog.api.request.DecodingRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URLDecoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DecodingControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("url 디코딩 테스트")
    void urlDecoder() throws Exception {
        DecodingRequest decRequest = DecodingRequest.builder()
                .decStr("https%3A%2F%2Fmeyerweb.com%2Feric%2Ftools%2Fdencoder%2F")
                .charSet("UTF-8")
                .build();

        String result = URLDecoder.decode(decRequest.getDecStr(), decRequest.getCharSet());

        String json = objectMapper.writeValueAsString(decRequest);

        mockMvc.perform(post("/decoding/url")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("https://meyerweb.com/eric/tools/dencoder/"))
                .andDo(print());
    }

}