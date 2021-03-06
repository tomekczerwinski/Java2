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
		newGame.setDystrybutor(game.getDystrybutor());
		newGame.setDataWydania(game.getDataWydania());
		newGame.setRate(game.getRate());
		newGame.setUniqueId(game.getUniqueId());
		newGame.setProduceDate(game.getProduceDate());


		db.add(newGame);
		//Game.lastID=Game.lastID+1;
	}


	public void deleteGame(Game game) {
		Game gameToRemove = null;
		for (Game p : db) {
			if (game.getUuid() == p.getUuid()) {
				gameToRemove = p;
				break;
			}
		}
		if (gameToRemove != null)
			db.remove(gameToRemove);
	}
	
	public void updateGame(Game game) {
		Game newGame = new Game();
		newGame.setName(game.getName());
		newGame.setCena(game.getCena());
		newGame.setPegi(game.getPegi());
		newGame.setPlatforma(game.getPlatforma());
		newGame.setUuid(game.getUuid());
		
		Game gameToUpdate = null;
		int i=0;
		for (Game p : db) {
			i++;
			if (game.getUuid() == p.getUuid()) {
				gameToUpdate = p;
				break;
			}
		}
		if (gameToUpdate != null){
			db.set(i-1,newGame);

		}

	
		
	}
	
	public void updateGameFinish(Game game) {
		Game newGame = new Game();
		newGame.setName(game.getName());
		newGame.setCena(game.getCena());
		newGame.setPegi(game.getPegi());
		newGame.setPlatforma(game.getPlatforma());
		newGame.setUuid(game.getUuid());
		
		Game gameToUpdate = null;
		int i=0;
		for (Game p : db) {
			i++;
			if (game.getUuid() == p.getUuid()) {
				gameToUpdate = p;
				break;
			}
		}
		if (gameToUpdate != null){
			db.set(i-1,newGame);

		}
		
	}
	


	

	public List<Game> getAllGames() {
		return db;
	}
}
