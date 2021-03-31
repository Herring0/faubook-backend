package com.herring.faubook.dao;

import com.herring.faubook.entity.AuthorEntity;

import java.util.List;

public interface AuthorDao {

    List<AuthorEntity> findAllAuthors();

    void deleteAuthorById(long id);

    List<AuthorEntity> findByName(String name);

    AuthorEntity findById(long id);

    void saveAuthor(AuthorEntity author);

    void updateAuthor(AuthorEntity author);
}
