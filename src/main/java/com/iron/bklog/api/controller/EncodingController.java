package com.iron.bklog.api.controller;

import com.iron.bklog.api.request.EncodingRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/encoding")
public class EncodingController {

    @PostMapping(value = "/url")
    public String urlEncoder(@RequestBody EncodingRequest request) throws UnsupportedEncodingException {
        return URLEncoder.encode(request.getEncStr(), request.getCharSet());
    }


}
