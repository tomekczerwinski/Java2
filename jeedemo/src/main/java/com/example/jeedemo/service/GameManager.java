package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.domain.Producer;


@Stateless
public class GameManager {

	@PersistenceContext
	EntityManager em;
	
    public Game get(Long id) {
        return em.find(Game.class, id);
    }

	public void addGame(Game game) {
		
		//Distributor distributor = em.find(Distributor.class, distributorId);
		
		game.setId(null);

		em.persist(game);
		
	}
	
	public void assignGameToProducer(Long gameId, Long producerId) {

		Producer producer = em.find(Producer.class, producerId);
		Game game = em.find(Game.class, gameId);
		//game.setSold(true);
		//producer.setAvilable(false);

		game.getProducers().add(producer);
		em.merge(game);
	}

	public void assignGameToDistributor(Long gameId, Long distributorId/*, Long producerId*/) {

		Distributor distributor = em.find(Distributor.class, distributorId);
		//Producer producer = em.find(Producer.class, producerId);
		Game game = em.find(Game.class, gameId);
		//game.setSold(true);
		
		distributor.setAvilable(false);

		game.setDistributor(distributor);
		em.merge(game);
		
		
		
	/*	game.getProducers().add(producer);*/
	}
	
	public void deleteGame(Game game) {
        game = em.find(Game.class, game.getId());
        em.remove(game);
	}
	
	public void updateGame(Game game){
		game = em.find(Game.class, game.getId());
		game.setName(game.getName());
		game.setCena(game.getCena());
		game.setPlatforma(game.getPlatforma());
		game.setPegi(game.getPegi());
		em.merge(game);
	}
	
/*	public void update(Long id, String name, float cena) {

        Game game = em.find(Game.class, id);
        game.setName(name);
        game.setCena(cena);

        em.merge(game);


    }*/
	

	@SuppressWarnings("unchecked")
	public List<Game> getAllGames() {
		return em.createNamedQuery("game.all").getResultList();
	}
	


/*	public List<Game> getOwnedGames(Game game) {
		game = em.find(Game.class, game.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Game> games = new ArrayList<Game>(game.getCars());
		return games;
	}*/
}
