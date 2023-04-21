package com.postgresService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresEntity.Actor;
import com.postgresRepo.ActorRepo;

@Service
public class ActorService {

	@Autowired
	ActorRepo actorRepo;

	public Actor create(Actor actor) {
		return actorRepo.save(actor);
	}

	public List<Actor> findAll() {
		List<Actor> actors = new ArrayList<>();
		actorRepo.findAll().forEach(actors::add);
		return actors;
	}

}
