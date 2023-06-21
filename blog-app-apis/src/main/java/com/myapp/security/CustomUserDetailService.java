package com.myapp.security;

import com.myapp.entities.User;
import com.myapp.exceptions.ResourceNotFoundException;
import com.myapp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //loading user from database by username
        User user=this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "Username"+username, 0));

        return user;
    }
}
