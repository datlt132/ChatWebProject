package com.project.resource;

import com.project.entity.MessageEntity;
import com.project.entity.SendMessageEntity;
import com.project.security.CustomUserDetails;
import com.project.service.MessageService;
import com.project.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageResource {
    @Autowired
    MessageService messageService;

    @Autowired
    SendMessageService sendMessageService;

    @GetMapping("/loadAllMessageToOne")
    List<SendMessageEntity> AllMessage(@AuthenticationPrincipal CustomUserDetails currentUser,
                                 @RequestBody Long recv_uid){
        List<SendMessageEntity> FromYou = sendMessageService.loadAllMessage(currentUser.getUserId(), recv_uid);
        List<SendMessageEntity> FromTheir = sendMessageService.loadAllMessage(recv_uid, currentUser.getUserId());
        FromYou.addAll(FromTheir);
        return FromYou;
    }

    @PostMapping("/sendToOne")
    SendMessageEntity newMessageToOne(@AuthenticationPrincipal CustomUserDetails currentUser,
                                      @RequestBody Long recv_uid,
                                      @RequestBody String message ){
        MessageEntity messageEntity = messageService.addMessage(message);
        messageEntity.setSend_at(new Timestamp(System.currentTimeMillis()));
        Long send_uid = currentUser.getUserId();
        return sendMessageService.sendMessageToOne(send_uid, recv_uid, messageEntity.getMid());
    }

    @DeleteMapping("/deleteMessage")
    MessageEntity deleteMessage(@RequestBody Long mid){
        return messageService.deleteMessage(mid);
    }

}
