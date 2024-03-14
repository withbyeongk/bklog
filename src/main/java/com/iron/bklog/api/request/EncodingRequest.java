package com.iron.bklog.api.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class EncodingRequest {
    private String encStr;
    private String charSet;

    public EncodingRequest() {
    }

    @Builder
    public EncodingRequest(String encStr, String charSet) {
        this.encStr = encStr;
        this.charSet = charSet;
    }
}
