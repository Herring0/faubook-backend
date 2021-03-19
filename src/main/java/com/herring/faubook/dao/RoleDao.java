package com.herring.faubook.dao;

import com.herring.faubook.entity.RoleEntity;

import java.util.List;

public interface RoleDao {

    List<RoleEntity> findAllRoles();

    void saveRole(RoleEntity role);

    void updateRole(RoleEntity role);

    void deleteRoleByName(String name);

    void deleteRoleById(long id);

}
