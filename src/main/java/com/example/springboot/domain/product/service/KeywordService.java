package com.example.springboot.domain.product.service;

import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotKeyword;


public interface KeywordService {
   ChatbotKeyword getChatKeyWord(String responseMessage);
}
