package com.shinhan.spring.apitest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SolapiSmsService smsService;

    // ������ ����
    public SmsController(SolapiSmsService smsService) {
        this.smsService = smsService;
    }
    

    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody Map<String, String> request) {
        String receiverNumber = request.get("to");

        // ���� Ŭ������ ����
        try {
            String verificationCode = smsService.sendSms(receiverNumber);
            return ResponseEntity.ok("������ȣ ���� �Ϸ�: " + verificationCode);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("���� ���� ����");
        }
    }
}
