package com.project.reposiroty;

import com.project.entity.SendMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendMessageRepository extends JpaRepository<SendMessageEntity, Long> {
    
}
