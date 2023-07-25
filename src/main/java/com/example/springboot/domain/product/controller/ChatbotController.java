package com.example.springboot.domain.product.controller;

import com.example.springboot.domain.product.dto.RequestDto.ChatbotRequest;
import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponse;
import com.example.springboot.domain.product.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chatGPT")
@RestController
public class ChatbotController {
    String qreQuestion = "안녕! chatGpt에 물어볼 것이 있어";
    private final ChatbotService chatService;
    //private final JwtService jwtService;

    @Autowired
    public ChatbotController(ChatbotService chatService) {
        this.chatService = chatService;
    }

    @ResponseBody
    @PostMapping("/askChatGPT")
    public ResponseEntity<ChatbotResponse> askToChatGPT(@RequestBody ChatbotRequest chatGptReq){
        // int userIdx = jwtService.getUserIdx();
        String resultQuestion = qreQuestion + chatGptReq.getQuestion();
        ChatbotResponse chatGptRes = chatService.getChatResponse(resultQuestion);
        System.out.println("[챗봇 응답] " + chatGptRes);
        return ResponseEntity.status(HttpStatus.OK).body(chatGptRes);
    }
}