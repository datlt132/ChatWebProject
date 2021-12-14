package com.project.resource;

import com.project.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResource {
    @Autowired
    MessageService messageService;


}
