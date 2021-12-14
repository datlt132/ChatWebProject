package com.project.service;

import com.project.entity.MessageEntity;
import com.project.reposiroty.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public MessageEntity addMessage(String message) {
        return messageRepository.save(new MessageEntity(message));
    }

    public MessageEntity deleteMessage(Long mid){
        MessageEntity messageEntity = messageRepository.findByMid(mid);
        messageEntity.setIs_deleted(true);
        messageEntity.setUpdated_time(new Timestamp(System.currentTimeMillis()));
        return messageRepository.save(messageEntity);
    }
}
