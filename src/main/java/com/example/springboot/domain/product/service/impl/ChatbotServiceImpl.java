package com.example.springboot.domain.product.service.impl;

import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotResponse;
import com.example.springboot.domain.product.service.ChatbotService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatbotServiceImpl implements ChatbotService {
    private ChatgptService chatgptService;

    @Autowired
    public ChatbotServiceImpl(ChatgptService chatgptService){
        this.chatgptService = chatgptService;
    }

    public ChatbotResponse getChatResponse(String prompt) {
        try {
            // ChatGPT 에게 질문, 공백 문자 2열 들어가서 자름.
            String responseMessage = chatgptService.sendMessage(prompt).substring(2);
            return new ChatbotResponse(responseMessage);
        } catch (Exception e){
            return new ChatbotResponse(e.getMessage());
        }
    }
}
