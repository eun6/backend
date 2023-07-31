package com.example.springboot.domain.product.service.impl;

import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotKeyword;
import com.example.springboot.domain.product.service.KeywordService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KeywordServiceImpl implements KeywordService {

    public ChatbotKeyword getChatKeyWord(String responseMessage) {
        // 응답에서 단어 추출 (공백으로 분리)
        String[] words = responseMessage.split("\\s+");

        // 첫 문장을 쉼표로 연결하여 반환
        ArrayList result = new ArrayList();
        for (int i = 0; i < Math.min(5, words.length); i++) {
            result.add(words[i]);
        }
        ChatbotKeyword keyword= new ChatbotKeyword(result);
        return keyword;
    }
}
