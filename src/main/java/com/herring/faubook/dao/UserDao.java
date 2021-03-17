package com.herring.faubook.dao;

import com.herring.faubook.entity.UserEntity;

import java.util.List;

public interface UserDao {

    List<UserEntity> findAllUsers();

    void deleteUserByLogin(String login);

    void deleteUserById(long id);

    UserEntity findByLogin(String login);

    UserEntity findById(long id);
}
