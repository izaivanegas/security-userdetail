package com.example.securityuserdetail.service;

import com.example.securityuserdetail.domain.User;
import com.example.securityuserdetail.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername....");
        User user = userRepository.findByUsername(username);
        System.out.println("User:"+user.getUsername());
        return new SecutiryUser(user);
    }
}
