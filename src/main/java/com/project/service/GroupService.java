package com.project.service;

import com.project.entity.GroupEntity;
import com.project.reposiroty.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    GroupEntity newGroup(String name){return groupRepository.save(new GroupEntity(name));}
}
