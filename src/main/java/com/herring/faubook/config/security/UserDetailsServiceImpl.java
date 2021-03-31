package com.herring.faubook.config.security;

import com.herring.faubook.entity.RoleEntity;
import com.herring.faubook.entity.UserEntity;
import com.herring.faubook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UserEntity domainUser = userService.findByLogin(username);
        if (domainUser == null) {
            throw new UsernameNotFoundException("Could not find user with name '" + username + "'");
        }
        List<GrantedAuthority> roles = getAuthorities(domainUser.getRoles());
        return new UserDetailsImpl(domainUser, roles);
    }

    private List<GrantedAuthority> getAuthorities(
            Collection<RoleEntity> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
