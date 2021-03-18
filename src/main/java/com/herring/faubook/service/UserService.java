package com.herring.faubook.service;

import com.herring.faubook.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllUsers();

    void deleteUserByLogin(String login);

    void deleteUserById(long id);

    UserEntity findByLogin(String login);

    UserEntity findById(long id);

    void saveUser(UserEntity user);

    void updateUser(UserEntity user);
}
