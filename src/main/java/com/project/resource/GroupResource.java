package com.project.resource;


import com.project.entity.GroupEntity;
import com.project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
public class GroupResource {

    @Autowired
    private GroupService groupService;

    @GetMapping("/{nameGroup}")
    public GroupEntity createGroup(@PathVariable("nameGroup") String name) {
        return groupService.newGroup(name);
    }


    @PostMapping("/addUser")
    public GroupEntity addUser(@RequestBody  long uid, @RequestBody GroupEntity groupEntity) {
        return groupService.addUser(uid, groupEntity);
    }

    @DeleteMapping ("/deleteUser")
    public GroupEntity deleteUser(@RequestParam long uid, @RequestParam long gid) {
        return groupService.deleteUser(uid, gid);
    }

    @DeleteMapping("/deleteGroup/{gid}")
    public ResponseEntity deleteTodo(@PathVariable(name = "gid") Long id){
        groupService.deleteGroup(id);
        return ResponseEntity.ok().build();
    }

}
