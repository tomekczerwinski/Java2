package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Producer;


@Stateless
public class DistributorAssigningManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void assignGame(Long gameId, Long distributorId/*, Long producerId*/) {

		Distributor distributor = em.find(Distributor.class, distributorId);
		//Producer producer = em.find(Producer.class, producerId);
		Game game = em.find(Game.class, gameId);
		//game.setSold(true);
		
		distributor.setAvilable(false);

		game.setDistributor(distributor);
		
	/*	game.getProducers().add(producer);*/
	}

	@SuppressWarnings("unchecked")
	public List<Game> getAvailableGames() {
		return em.createNamedQuery("game.unsold").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Distributor> getAvailableDistributors() {
		return em.createNamedQuery("distributor.avilable").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Producer> getAllProducers() {
		return em.createNamedQuery("producer.all").getResultList();
	}
	
	

}
