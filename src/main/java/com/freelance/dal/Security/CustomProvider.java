package com.freelance.dal.Security;

import com.freelance.dal.Entity.MyUser;
import com.freelance.dal.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class CustomProvider implements AuthenticationProvider{
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        String lowercaseLogin = username.toLowerCase();

        MyUser myUser;

        myUser = userRepository.findByUserNameAndPassword(username, password);

        if(myUser == null){
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("WRITE"));

        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
