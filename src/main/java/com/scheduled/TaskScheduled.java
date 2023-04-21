package com.scheduled;

import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.postgresEntity.Utente;
import com.postgresService.UtenteService;

@Component
public class TaskScheduled {

	private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	UtenteService utenteService;

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		LOG.info("INFO: The time is now {}", dateFormat.format(new Date()));
		LOG.debug("DEBUG: The time is now {}", dateFormat.format(new Date()));
		try {
			utenteService.deleteAll();

			Utente user = new Utente(1, "nome", "cognome");
			Utente user2 = new Utente(2, "nome2", "cognome2");
			Utente user3 = new Utente(3, "nome3", "cognome3");
			utenteService.create(user);
			utenteService.create(user2);
			utenteService.create(user3);
			List<Utente> utenti = utenteService.findAll();
			LOG.debug("utenti == " + utenti);
		} catch (Exception e) {
			LOG.error("Eccezione nell'accesso a db: " + e.getMessage());
		}
	}
}
