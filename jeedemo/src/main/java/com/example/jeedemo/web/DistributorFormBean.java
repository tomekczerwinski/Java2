package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;
import com.example.jeedemo.service.DistributorManager;


@SessionScoped
@Named("distributorBean")
public class DistributorFormBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Distributor distributor = new Distributor();
	private ListDataModel<Distributor> distributors = new ListDataModel<Distributor>();

	@Inject
	private DistributorManager dm;
	
	private Long distributorId;
	
	
	public String addDistributor() {
		dm.addDistributor(distributor);
		return "showGames";
		//return null;
	}
	
	public Distributor getDistributor() {
		return distributor;
	}
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public Long getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(Long distributorId) {
		this.distributorId = distributorId;
	}
}
