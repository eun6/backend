package com.example.springboot.domain.product.dto.ResponseDto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChatbotResponseDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ChatbotResponse {
        private String response;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ChatbotKeyword {
        private ArrayList keyword;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ChatbotResult {
        private ChatbotResponse text;
        private ChatbotKeyword keywords;
    }
}