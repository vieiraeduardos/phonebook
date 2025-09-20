package com.example.phonebook.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
    private String access_token;
    private String token_type = "Bearer";
    private long expires_in = 864_000_000;
}