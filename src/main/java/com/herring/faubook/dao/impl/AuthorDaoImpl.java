package com.herring.faubook.dao.impl;

import com.herring.faubook.dao.AbstractDao;
import com.herring.faubook.dao.AuthorDao;
import com.herring.faubook.entity.AuthorEntity;
import com.herring.faubook.entity.UserEntity;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDao implements AuthorDao {

    @Override
    public List<AuthorEntity> findAllAuthors() {
        return getAll(AuthorEntity.class, getSession());
    }

    @Override
    public void deleteAuthorById(long id) {
        AuthorEntity author = getSession().load(AuthorEntity.class, id);
        delete(author);
    }

    @Override
    public List<AuthorEntity> findByName(String name) {
        Query query= getSession().
                createQuery("from AuthorEntity where name=:name");
        query.setParameter("name", name);
        List<AuthorEntity> authors = (List<AuthorEntity>) query.getResultList();
        return authors;
    }

    @Override
    public AuthorEntity findById(long id) {
        return getSession().get(AuthorEntity.class, id);
    }

    @Override
    public void saveAuthor(AuthorEntity author) {
        getSession().save(author);
    }

    @Override
    public void updateAuthor(AuthorEntity author) {
        getSession().update(author);
    }
}
