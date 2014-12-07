package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Game;

@ApplicationScoped
public class GameMenager {
	private List<Game> db = new ArrayList<Game>();

	public void addGame(Game game) {
		Game newGame = new Game();

		newGame.setName(game.getName());
		newGame.setCena(game.getCena());
		newGame.setPegi(game.getPegi());
		newGame.setPlatforma(game.getPlatforma());
		newGame.setId(Game.lastID);
		
		/*
		newGame.setPin(game.getPin());
		newGame.setDateOfBirth(game.getDateOfBirth());
		newGame.setMarried(game.isMarried());
		newGame.setWeight(game.getWeight());
		newGame.setNumOfChildren(game.getNumOfChildren());
*/
		db.add(newGame);
		Game.lastID++;
	}

	// Removes the person with given PIN
	public void deleteGame(Game game) {
		Game gameToRemove = null;
		for (Game p : db) {
			if (game.getId() == p.getId()) {
				gameToRemove = p;
				break;
			}
		}
		if (gameToRemove != null)
			db.remove(gameToRemove);
	}
	
	public void updateGame(Game game) {
		Game gameToUpdate = null;
		for (Game p : db) {
			if (game.getId() == p.getId()) {
				gameToUpdate = p;
				break;
			}
		}
		if (gameToUpdate != null){
			// gameToUpdate.setCanEdit(true);
			Game newGame = new Game();

			newGame.setName(game.getName());
			newGame.setCena(game.getCena());
			newGame.setPegi(game.getPegi());
			newGame.setPlatforma(game.getPlatforma());
			newGame.setId(game.getId());
			}
	
		
	}
	
	public void updateGameFinish(Game game) {
		Game newGame = new Game();
		newGame.setName(game.getName());
		newGame.setCena(game.getCena());
		newGame.setPegi(game.getPegi());
		newGame.setPlatforma(game.getPlatforma());
		newGame.setId(game.getId());
		
		Game gameToUpdate = null;
		int i=0;
		for (Game p : db) {
			i++;
			if (game.getId() == p.getId()) {
				gameToUpdate = p;
				break;
			}
		}
		if (gameToUpdate != null){
			db.set(i-1,newGame);

		}
		
	}

	
	 public String editGame(Game game){
		      game.setCanEdit(true);
		      return null;
		   }

	public List<Game> getAllGames() {
		return db;
	}
}
