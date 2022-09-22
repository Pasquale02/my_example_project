package com.postgresRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.postgresEntity.Utente;

public interface UtenteRepo extends JpaRepository <Utente, Integer>{

}
