package com.JWT.demo.Repository;

import com.JWT.demo.Model.RolesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.RoleList;


@Repository
public interface UserRepo extends JpaRepository<RolesList,String> {
    RolesList findByUsername(String username);
}
