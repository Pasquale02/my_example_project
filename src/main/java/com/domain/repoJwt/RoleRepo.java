package com.domain.repoJwt;

import org.springframework.data.jpa.repository.JpaRepository;

import com.domainJwt.Ruolo;

/**
 * 
 * @author FLORIOP
 * @implNote first parameter class to manage, second parameter type of index
 */
public interface RoleRepo extends JpaRepository<Ruolo, Long> {

	Ruolo findByName(String rolename);

}
