package com.taffy.neko.controller;


import com.taffy.neko.Result.R;
import com.taffy.neko.entity.Chat;
import com.taffy.neko.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/chat")
@Api(tags = "私信模块")
public class ChatController {

    @Resource
    private ChatService chatService;


    @GetMapping("/oneChat")
    @ApiOperation(value = "查询两个人所有的私信记录")
    public R<?> getOneChat(@RequestParam String fromId, @RequestParam String toId) {
        return chatService.selectOneChat(fromId, toId);
    }

    @PostMapping("/sendChat")
    @ApiOperation(value = "添加私信")
    public R<?> sendChat(@RequestBody Chat chat) {
        return chatService.sendChat(chat);
    }

    @GetMapping("/getLeftInfo")
    @ApiOperation(value = "消息记录")
    public R<?> getChatLeftInfo(@RequestParam String userId) {
        return chatService.getChatLeft(userId);
    }

    @PutMapping("/readMsg")
    @ApiOperation(value = "让私信变成已读")
    public R<?> readMsg(@RequestParam String fromId,@RequestParam String toId) {
        return chatService.readMsg(fromId,toId);
    }
}
