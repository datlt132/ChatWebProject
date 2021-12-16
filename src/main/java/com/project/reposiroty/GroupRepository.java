package com.project.reposiroty;

import com.project.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    GroupEntity deleteGroupEntitiesByUidAndGid(long uid, long gid);
    GroupEntity deleteGroupEntitiesByGid(long gid);
}
