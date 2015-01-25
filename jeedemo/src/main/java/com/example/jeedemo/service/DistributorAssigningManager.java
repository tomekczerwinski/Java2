package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;


@Stateless
public class DistributorAssigningManager {
	
	@PersistenceContext
	EntityManager em;
	
	public void assignGame(Long gameId, Long distributorId) {

		Distributor distributor = em.find(Distributor.class, distributorId);
		Game game = em.find(Game.class, gameId);
		//game.setSold(true);

		game.setDistributor(distributor);
	}

	@SuppressWarnings("unchecked")
	public List<Game> getAvailableGames() {
		return em.createNamedQuery("game.unsold").getResultList();
	}
	
	

}
