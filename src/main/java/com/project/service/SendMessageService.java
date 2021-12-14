package com.project.service;

import com.project.entity.SendMessageEntity;
import com.project.reposiroty.SendMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SendMessageService {
    @Autowired
    SendMessageRepository sendMessageRepository;

    SendMessageEntity sendMessageToOne (@RequestBody Long send_uid, @RequestBody Long recv_uid, @RequestBody Long mid){
        return sendMessageRepository.save(new SendMessageEntity(send_uid, recv_uid, mid));
    }

    SendMessageEntity sendMessageToGroup (@RequestBody Long send_uid, @RequestBody Long gid, @RequestBody Long mid){
        return null;
    }

}
