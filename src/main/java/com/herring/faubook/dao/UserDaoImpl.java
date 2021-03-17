package com.herring.faubook.dao;
import com.herring.faubook.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Override
    public List<UserEntity> findAllUsers() {
        return getAll(UserEntity.class, getSession());
    }

    @Override
    public void deleteUserByLogin(String login) {
        UserEntity user = getSession().load(UserEntity.class, login);
        delete(user);
    }

    @Override
    public void deleteUserById(long id) {
        UserEntity user = getSession().load(UserEntity.class, id);
        delete(user);
    }

    @Override
    public UserEntity findByLogin(String login){
        return getSession().get(UserEntity.class, login);
    }

    @Override
    public UserEntity findById(long id) {
        return getSession().get(UserEntity.class, id);
    }

}
