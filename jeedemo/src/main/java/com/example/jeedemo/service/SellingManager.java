package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class SellingManager {

	@PersistenceContext
	EntityManager em;

	public void sellGame(Long personId, Long gameId) {

		Person person = em.find(Person.class, personId);
		Game game = em.find(Game.class, gameId);
		game.setSold(true);

		person.getGames().add(game);
	}

	@SuppressWarnings("unchecked")
	public List<Game> getAvailableGames() {
		return em.createNamedQuery("game.unsold").getResultList();
	}

	public void disposeGame(Person person, Game game) {

		person = em.find(Person.class, person.getId());
		game = em.find(Game.class, game.getId());

		Game toRemove = null;
		// lazy loading here (person.getCars)
		for (Game aGame : person.getGames())
			if (aGame.getId().compareTo(game.getId()) == 0) {
				toRemove = aGame;
				break;
			}

		if (toRemove != null)
			person.getGames().remove(toRemove);
		
		game.setSold(false);
	}
}
