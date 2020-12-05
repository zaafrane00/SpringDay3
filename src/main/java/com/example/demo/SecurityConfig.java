package com.example.demo;

import com.example.demo.dao.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.net.Authenticator;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.userDetailsService(getUserDetailsService());
    }

    @Bean
    public UserDetailsService getUserDetailsService() {
        return  new MyUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and().formLogin().loginPage("/login");
    }

    @PostConstruct
        public void init(){
            if(userRepository.findAll().size()==0){
                User entity=new User();
                entity.setActive(true);
                entity.setEmail("admin");
                entity.setRoles("ROLE_ADMIN,ROLE_USER");
                entity.setPassword(passwordEncoder.encode("admin"));
                userRepository.save(entity);
            }
    }

}
