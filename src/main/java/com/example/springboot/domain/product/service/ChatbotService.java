package com.example.springboot.domain.product.service;

import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponse;

public interface ChatbotService {
    ChatbotResponse getChatResponse(String prompt);
}
