package com.domain.repoJwt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domainJwt.Role;

/**
 * 
 * @author FLORIOP
 * @implNote first parameter class to manage, second parameter type of index
 */
public interface RoleRepo extends JpaRepository<Role, Long> {

	Role findByName(String rolename);

}
