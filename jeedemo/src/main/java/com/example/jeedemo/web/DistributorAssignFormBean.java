package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.domain.Person;
import com.example.jeedemo.service.DistributorAssigningManager;
import com.example.jeedemo.service.DistributorManager;
import com.example.jeedemo.service.GameManager;
import com.example.jeedemo.service.PersonManager;
import com.example.jeedemo.service.SellingManager;


@SessionScoped
@Named("assignDistributorBean")
public class DistributorAssignFormBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private DistributorAssigningManager dam;
	
	@Inject
	private DistributorManager dm;

	@Inject
	private GameManager gm;

	private Long gameId;
	private Long distributorId;
	
	
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Long getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
	
	
	public List<Distributor> getDistributors() {
		return dm.getDistributors();
	}

	public List<Game> getAllGames() {
		return gm.getAllGames();
	}

	public String assignGame() {
		dam.assignGame(distributorId, gameId);
		return null;
	}
}
