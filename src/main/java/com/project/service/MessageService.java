package com.project.service;

import com.project.entity.MessageEntity;
import com.project.reposiroty.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    MessageEntity addMessage(@RequestBody String message){return messageRepository.save(new MessageEntity(message));}
}
