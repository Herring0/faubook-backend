package com.herring.faubook.service.impl;

import com.herring.faubook.dao.AuthorDao;
import com.herring.faubook.entity.AuthorEntity;
import com.herring.faubook.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("authorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    public AuthorServiceImpl(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<AuthorEntity> findAllAuthors() {
        return dao.findAllAuthors();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void deleteAuthorById(long id) {
        dao.deleteAuthorById(id);
    }

    @Override
    public List<AuthorEntity> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public AuthorEntity findById(long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void saveAuthor(AuthorEntity author) {
        dao.saveAuthor(author);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public void updateAuthor(AuthorEntity author) {
        dao.updateAuthor(author);
    }
}
