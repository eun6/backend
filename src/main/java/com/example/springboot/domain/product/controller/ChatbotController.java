package com.example.springboot.domain.product.controller;

import com.example.springboot.domain.product.dto.RequestDto.ChatbotRequest;
import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotResult;
import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotKeyword;
import com.example.springboot.domain.product.dto.ResponseDto.ChatbotResponseDto.ChatbotResponse;
import com.example.springboot.domain.product.service.ChatbotService;
import com.example.springboot.domain.product.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chatGPT")
@RestController
public class ChatbotController {
    private final ChatbotService chatService;
    private KeywordService keywordService;
    //private final JwtService jwtService;

    @Autowired
    public ChatbotController(ChatbotService chatService, KeywordService keywordService) {
        this.chatService = chatService;
        this.keywordService = keywordService;
    }

    @ResponseBody
    @PostMapping("/askChatGPT")
    public ResponseEntity<ChatbotResult> askToChatGPT(@RequestBody ChatbotRequest chatGptReq){
        // int userIdx = jwtService.getUserIdx();
        String resultQuestion = chatGptReq.getQuestion();
        ChatbotResponse chatGptRes = chatService.getChatResponse(resultQuestion);
        ChatbotKeyword chatkeyword = keywordService.getChatKeyWord(chatGptRes.getResponse());
        System.out.println("[챗봇 응답] " + chatGptRes);
        System.out.println("[챗봇 키워드] " + chatkeyword);

        ChatbotResult chatbotResult= new ChatbotResult();
        chatbotResult.setText(chatGptRes);
        chatbotResult.setKeywords(chatkeyword);

        return ResponseEntity.status(HttpStatus.OK).body(chatbotResult);
    }
}