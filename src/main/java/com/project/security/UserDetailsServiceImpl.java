package com.project.security;


import com.project.entity.UserEntity;
import com.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find user " + username);
        }
        CustomUserDetails userDetails = new CustomUserDetails(user.getName(), user.getPassword(), user.getId(), username);

        return userDetails;
    }

    public UserDetails loadUserByUserId(Long userId) {
        UserEntity user = userService.findUser(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find user with id:" + userId);
        }
        CustomUserDetails userDetails = new CustomUserDetails(user.getName(), user.getPassword(), userId, user.getEmail());

        return userDetails;
    }
}

