package com.project.service;

import com.project.entity.GroupEntity;
import com.project.reposiroty.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public GroupEntity newGroup(String name) {return groupRepository.save(new GroupEntity(name));}

    public GroupEntity addUser(long uid, GroupEntity groupEntity) {
        groupEntity.setUid(uid);
        return groupRepository.save(groupEntity);
    }

    public GroupEntity deleteUser(long uid, long gid) {
        return groupRepository.deleteGroupEntitiesByUidAndGid(uid, gid);
    }

    public GroupEntity deleteGroup(long gid) {
        return groupRepository.deleteGroupEntitiesByGid(gid);
    }

}
