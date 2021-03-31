package com.herring.faubook.config.security;

import com.herring.faubook.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private UserEntity user;
    private List<GrantedAuthority> roles;
    private String username;
    private String password;

    public ArrayList<String> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<String> tokens) {
        this.tokens = tokens;
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    public void removeToken(String token) {
        tokens.remove(token);
    }

    private ArrayList<String> tokens;

    public UserDetailsImpl(UserEntity user, List<GrantedAuthority> roles) {
        this.user = user;
        this.roles = roles;
        this.username = user.getLogin();
        this.password = user.getPassword();
    }

    public UserDetailsImpl() {
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public UserEntity getUser() {
        return user;
    }
}
