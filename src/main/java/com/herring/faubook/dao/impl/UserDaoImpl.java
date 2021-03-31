package com.herring.faubook.dao.impl;
import com.herring.faubook.dao.AbstractDao;
import com.herring.faubook.dao.UserDao;
import com.herring.faubook.entity.AuthorEntity;
import com.herring.faubook.entity.UserEntity;
import org.hibernate.query.Query;
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
        Query query = getSession().
                createQuery("from UserEntity where login=:login");
        query.setParameter("login", login);
        UserEntity user = (UserEntity) query.getSingleResult();
        return user;
//        return getSession().get(UserEntity.class, login);
    }

    @Override
    public UserEntity findById(long id) {
        return getSession().get(UserEntity.class, id);
    }

    @Override
    public void saveUser(UserEntity user) {
        getSession().save(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        getSession().update(user);
    }

}
