package com.demo.api.dto.response.regrister;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponseObject {
    public int code;
    public String message;
    public RegisterResponseData data;

}
