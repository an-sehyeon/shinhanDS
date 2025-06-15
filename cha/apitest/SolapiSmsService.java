package com.shinhan.spring.apitest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class SolapiSmsService {

    private final String apiKey = "NCSFMVMAQYZBMUH2";
    private final String apiSecret = "FOMAJEI0LW4I5VZPUJCCK2I1IMDJ4HV4";
    private final String senderNumber = "01084123416";

    private final String requestUrl = "/messages/v4/send";
    private final String requestHost = "https://api.solapi.com";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String sendSms(String receiverNumber) throws Exception {
        String verificationCode = generateVerificationCode();

        // 메시지 구성
        Map<String, Object> message = Map.of(
                "to", receiverNumber,
                "from", senderNumber,
                "text", "[인증번호] " + verificationCode
        );

        Map<String, Object> body = new HashMap<>();
        body.put("messages", List.of(message));

        // JSON 문자열로 변환 (시그니처 생성용)
        String bodyJson = objectMapper.writeValueAsString(body);

        // 타임스탬프 및 솔트 생성
        String timestamp = Long.toString(System.currentTimeMillis());
        String salt = UUID.randomUUID().toString();

        // 시그니처 생성
        String signature = makeSignature("POST", requestUrl, timestamp, salt, bodyJson);

        // 헤더 구성
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "HMAC-SHA256 " + signature);
        headers.set("x-api-key", apiKey);
        headers.set("x-api-timestamp", timestamp);
        headers.set("x-api-salt", salt);

        HttpEntity<String> entity = new HttpEntity<>(bodyJson, headers);
        RestTemplate restTemplate = new RestTemplate();

        // 요청 전송
        ResponseEntity<String> response = restTemplate.postForEntity(
                requestHost + requestUrl,
                entity,
                String.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return verificationCode;
        } else {
            throw new RuntimeException("문자 전송 실패: " + response.getBody());
        }
    }

    private String makeSignature(String method, String url, String timestamp, String salt, String body) throws Exception {
        String message = method + " " + url + "\n" + timestamp + "\n" + salt + "\n" + body;
        Mac hasher = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        hasher.init(keySpec);
        byte[] hash = hasher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    private String generateVerificationCode() {
        Random random = new Random();
        int code = 100000 + random.nextInt(900000);
        return String.valueOf(code);
    }
}
