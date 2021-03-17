package com.herring.faubook.service;

import com.herring.faubook.dao.UserDao;
import com.herring.faubook.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public void deleteUserByLogin(String login) {
        dao.deleteUserByLogin(login);
    }

    @Override
    public void deleteUserById(long id) {
        dao.deleteUserById(id);
    }

    @Override
    public UserEntity findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public UserEntity findById(long id) {
        return dao.findById(id);
    }
}
