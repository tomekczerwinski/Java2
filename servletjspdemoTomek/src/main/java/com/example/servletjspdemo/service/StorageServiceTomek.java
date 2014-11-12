package com.example.servletjspdemo.service;
import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.Game;
import com.example.servletjspdemo.domain.Person;


public class StorageServiceTomek {
	
	private List<Game> db = new ArrayList<Game>();
	
	public void add(Game game){
		Game newGame = new Game( game.getDataWydania(), game.getId(), game.getName(), game.getName(), game.getDystrybutor(), game.getPlatforma(), game.getCena());
		
		db.add(newGame);
		
	}
	
	public List<Game> getAllGames(){
		return db;
	}
	
	public void delete(int id){
		/*for (com.example.servletjspdemo.domain.Game gameTodelete : getAllGames()) {
			if(id == gameTodelete.id){
				//System.out.println("yolo");
				db.remove(gameTodelete);
			}
			
		
		}*/
		int i=0;
		while(db.get(i).id != id)
			i++;
		
		if(db.get(i).id == id)
			db.remove(i);
		
	}
	
	public int size()
		{
			return db.size();
		}

}
