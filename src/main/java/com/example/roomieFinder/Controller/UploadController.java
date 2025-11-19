package com.example.roomieFinder.Controller;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class UploadController {

    private final Cloudinary cloudinary;

    @Value("${cloudinary.upload_preset}")
    private String uploadPreset;

    @GetMapping("/signature")
    public Map<String, Object> getUploadSignature() {
        String apiSecret = cloudinary.config.apiSecret;
        long timestamp = System.currentTimeMillis() / 1000;

        Map<String, Object> paramsToSign = new TreeMap<>();
        paramsToSign.put("timestamp", timestamp);
        paramsToSign.put("upload_preset", uploadPreset);

        String signature = cloudinary.apiSignRequest(paramsToSign, apiSecret, 1);

        Map<String, Object> response = new HashMap<>();
        response.put("signature", signature);
        response.put("timestamp", timestamp);
        response.put("api_key", cloudinary.config.apiKey);

        return response;
    }
}