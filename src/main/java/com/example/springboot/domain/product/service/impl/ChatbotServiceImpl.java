package com.example.springboot.domain.product.service.impl;

import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponse;
import com.example.springboot.domain.product.service.ChatbotService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatbotServiceImpl implements ChatbotService {
    private ChatgptService chatgptService;
    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    public ChatbotServiceImpl(ChatgptService chatgptService){
        this.chatgptService = chatgptService;
    }

    public ChatbotResponse getChatResponse(String prompt) {
        try {
            // ChatGPT 에게 질문을 던집니다.
            String responseMessage = chatgptService.sendMessage(prompt);
            return new ChatbotResponse(responseMessage);
        } catch (Exception e){
            return new ChatbotResponse(e.getMessage());
            //throw new BaseException(BaseResponseStatus.SERVER_ERROR);
        }
    }
}
