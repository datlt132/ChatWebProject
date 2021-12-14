package com.project.reposiroty;

import com.project.entity.SendMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SendMessageRepository extends JpaRepository<SendMessageEntity, Long> {
    List<SendMessageEntity> findAllBySend_uidAndRecv_uidAndIs_deletedFalse(Long send_uid, Long recv_uid);
}
