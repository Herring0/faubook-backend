package com.herring.faubook.dao.impl;

import com.herring.faubook.dao.AbstractDao;
import com.herring.faubook.dao.RoleDao;
import com.herring.faubook.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao implements RoleDao {
    @Override
    public List<RoleEntity> findAllRoles() {
        return getAll(RoleEntity.class, getSession());
    }

    @Override
    public void saveRole(RoleEntity role) {
        getSession().save(role);
    }

    @Override
    public void updateRole(RoleEntity role) {
        getSession().update(role);
    }

    @Override
    public void deleteRoleByName(String name) {
        RoleEntity role = getSession().load(RoleEntity.class, name);
        delete(role);
    }

    @Override
    public void deleteRoleById(long id) {
        RoleEntity role = getSession().load(RoleEntity.class, id);
        delete(role);
    }
}
