package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Distributor;
import com.example.jeedemo.domain.Game;


@Stateless
public class DistributorManager {
	
	@PersistenceContext
	EntityManager em;
	
	
	public void addDistributor(Distributor distributor) {
		distributor.setId(null);
		em.persist(distributor);
	}
	
	@SuppressWarnings("unchecked")
	public List<Distributor> getDistributors() {
		return em.createNamedQuery("distributor.all").getResultList();
	}

}
