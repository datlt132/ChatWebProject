package com.project.resource;


import com.project.entity.UserEntity;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class UserResource {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public ResponseEntity<UserEntity> register(@Valid @RequestBody UserEntity
                                                            user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
       service.register(user,  getSiteURL(request));
       return ResponseEntity.ok(user);
    }


    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

}
