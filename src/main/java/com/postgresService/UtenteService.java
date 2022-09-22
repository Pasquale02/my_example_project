package com.postgresService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresEntity.Utente;
import com.postgresRepo.UtenteRepo;

@Service
public class UtenteService {
	
	@Autowired
	UtenteRepo utenteRepo;
	
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<>();
		utenteRepo.findAll().forEach(utenti::add);
		return utenti;
	}

}
