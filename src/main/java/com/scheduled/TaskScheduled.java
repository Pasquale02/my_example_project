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

import com.postgresEntity.Actor;
import com.postgresService.ActorService;

@Component
public class TaskScheduled {

	private static final Logger LOG = LogManager.getLogger(MethodHandles.lookup().lookupClass());

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	ActorService actorService;

	@Scheduled(fixedRate = 20000)
	public void reportCurrentTime() {
		LOG.info("INFO: The time is now {}", dateFormat.format(new Date()));
		LOG.debug("DEBUG: The time is now {}", dateFormat.format(new Date()));
		try {
			List<Actor> actors = actorService.findAll();
			/*
			 * foreach classico oppure lambda exp
			 * for (String actor : actors) { System.out.println(actor); }
			 */
			actors.forEach(actor -> System.out.println(actor));
		} catch (Exception e) {
			LOG.error("Eccezione nell'accesso a db: " + e.getMessage());
		}
	}
}
