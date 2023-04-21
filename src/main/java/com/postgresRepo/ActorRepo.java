package com.postgresRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresEntity.Actor;

public interface ActorRepo extends JpaRepository <Actor, Integer>{

}
