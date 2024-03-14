package com.iron.bklog.api.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DecodingRequest {

    private String decStr;
    private String charSet;

    public DecodingRequest() {
    }

    @Builder
    public DecodingRequest(String decStr, String charSet) {
        this.decStr = decStr;
        this.charSet = charSet;
    }
}
