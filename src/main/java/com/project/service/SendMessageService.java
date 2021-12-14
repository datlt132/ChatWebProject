package com.project.service;


import com.project.entity.SendMessageEntity;
import com.project.reposiroty.SendMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SendMessageService {
    @Autowired
    SendMessageRepository sendMessageRepository;

    public SendMessageEntity sendMessageToOne ( Long send_uid,  Long recv_uid,  Long mid){
        return sendMessageRepository.save(new SendMessageEntity(send_uid, recv_uid, mid));
    }

    public SendMessageEntity sendMessageToGroup ( Long send_uid,  Long gid,  Long mid){
        return null;
    }

    public List<SendMessageEntity> loadAllMessage(Long send_uid, Long recv_uid){
        return sendMessageRepository.findAllBySend_uidAndRecv_uidAndIs_deletedFalse(send_uid, recv_uid);
    }
}
