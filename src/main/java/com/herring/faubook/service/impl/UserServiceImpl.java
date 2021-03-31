package com.herring.faubook.service.impl;

import com.herring.faubook.dao.UserDao;
import com.herring.faubook.entity.UserEntity;
import com.herring.faubook.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao dao;

    private final PasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserDao dao, PasswordEncoder bCryptPasswordEncoder) {
        this.dao = dao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<UserEntity> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void deleteUserByLogin(String login) {
        dao.deleteUserByLogin(login);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void saveUser(UserEntity user) {
        user.setCreationDateTime(new Timestamp(new Date().getTime()));
        user.setPassword(bCryptPasswordEncoder
                .encode(user.getPassword()));
        dao.saveUser(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void updateUser(UserEntity user) {
        dao.updateUser(user);
    }
}
