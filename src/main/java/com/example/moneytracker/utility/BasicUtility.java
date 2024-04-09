package com.example.moneytracker.utility;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

@Component
public class BasicUtility {
    public String str2Sha256(String string) {
        return Hashing.sha256()
        .hashString(string, StandardCharsets.UTF_8)
        .toString();
    }
}
