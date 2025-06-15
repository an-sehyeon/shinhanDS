package com.shinhan.spring.apitest;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class SolapiJwtTokenUtil {

    public static String generateToken(String apiKey, String apiSecret) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 1000 * 60 * 3; // 3�� ��ȿ

        return Jwts.builder()
                .setIssuer(apiKey)            // iss �ʵ忡 API Key
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(expMillis))
                .signWith(SignatureAlgorithm.HS256, apiSecret.getBytes())
                .compact();
    }
}

