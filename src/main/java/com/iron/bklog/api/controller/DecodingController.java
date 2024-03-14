package com.iron.bklog.api.controller;

import com.iron.bklog.api.request.DecodingRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
@Slf4j
@RequestMapping("/decoding")
public class DecodingController {

    @RequestMapping(value = "/url")
    public String urlDecoder(@RequestBody DecodingRequest request) throws UnsupportedEncodingException {
        return URLDecoder.decode(request.getDecStr(), request.getCharSet());
    }

}
