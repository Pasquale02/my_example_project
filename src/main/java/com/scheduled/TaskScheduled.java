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
		LOG.info("The time is now {}", dateFormat.format(new Date()));
		List<Utente> utenti = utenteService.findAll();
		System.out.println("utenti == "+ utenti);
	}
}
