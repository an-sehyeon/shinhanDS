package com.shinhan.spring.apitest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SolapiSmsService smsService;

    // 생성자 주입
    public SmsController(SolapiSmsService smsService) {
        this.smsService = smsService;
    }
    

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody Map<String, String> request) {
        String receiverNumber = request.get("to");

        // 서비스 클래스에 위임
        try {
            String verificationCode = smsService.sendSms(receiverNumber);
            return ResponseEntity.ok("인증번호 전송 완료: " + verificationCode);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("문자 전송 실패");
        }
    }
}
