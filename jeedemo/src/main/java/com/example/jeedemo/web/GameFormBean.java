package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.service.DistributorManager;
import com.example.jeedemo.service.GameManager;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;

@SessionScoped
@Named("gameBean")
public class GameFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Game game = new Game();
	private Distributor distributor = new Distributor();
	
	private ListDataModel<Game> games = new ListDataModel<Game>();
	
	private Game gameToShow = new Game();
	private ListDataModel<Game> ownedGames = new ListDataModel<Game>();

	private long gameId;
	private long distributorId;

	@Inject
	private GameManager gm;
	
	@Inject
	private SellingManager sm;
	
	@Inject
	private DistributorManager dm;

	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	

	
	
	public ListDataModel<Game> getAllGames() {
		games.setWrappedData(gm.getAllGames());
		return games;
	}


	
	// Actions
	public String addGame() {
		gm.addGame(game);
		return "showGames";
		//return null;
	}

	public String deleteGame() {
		Game gameToDelete = games.getRowData();
		gm.deleteGame(gameToDelete);
		return null;
	}
	
	public String showDetails() {
		gameToShow = games.getRowData();
		return "details";
	}
	

	
	public String saveAction() {
		Game gameToUpdate = games.getRowData();
		gm.updateGame(gameToUpdate);

		for (Game game : games){
			game.setEditable(false);
		}
		
		return null;
	}
	public String editAction() {
		Game toEdit = games.getRowData();
		
		toEdit.setEditable(true);
		return null;
	}
	
	public List<Distributor> getAllDistributors() {
		return dm.getDistributors();
	}
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(long distributorId) {
		this.distributorId = distributorId;
	}
	public Distributor getDistributor() {
		return distributor;
	}
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	
	/*public String disposeGame(){
		Game gameToDispose = ownedGames.getRowData();
		sm.disposeGame(gameToShow, gameToDispose);
		return null;
	}*/

}
