package com.captain.accounts_api.dto;

public class ResponseDto {

    private String statusCode;
    private String statusMsg;

    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }
}
