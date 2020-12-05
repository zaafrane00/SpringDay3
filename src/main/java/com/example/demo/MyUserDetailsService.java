package com.example.demo;

import com.example.demo.dao.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User not found"));
       // return user.map(MyUserDetails::new).get();
        return new MyUserDetails(user.get());
    }
}
