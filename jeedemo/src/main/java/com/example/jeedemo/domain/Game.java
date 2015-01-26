package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@NamedQueries({ 
	@NamedQuery(name = "game.all", query = "Select g from Game g"),
	@NamedQuery(name = "game.unsold", query = "Select g from Game g where g.sold = false")
	/*@NamedQuery(name = "game.owns", query = "Select pg from Game_Person pg")*/
	
})
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String make;
	private String name;
	private Boolean sold = false;
	
	private ArrayList<String> platforma = null;
	private float cena =0;
	private String pegi ="";
	
	
	private List<Producer> producers = new ArrayList<Producer>();

	private int rate =0;
	private boolean editable=false;
	@Temporal(TemporalType.DATE)
	private Date produceDate = new Date();

	@OneToOne(fetch = FetchType.EAGER)
	private Distributor distributor;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	



	

	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public Boolean getSold() {
		return sold;
	}
	public void setSold(Boolean sold) {
		this.sold = sold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public ArrayList<String> getPlatforma() {
		return platforma;
	}
	public void setPlatforma(ArrayList<String> platforma) {
		this.platforma = platforma;
	}
	
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getPegi() {
		return pegi;
	}
	public void setPegi(String pegi) {
		this.pegi = pegi;
	}
	

	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	
    public Distributor getDistributor() {
        return distributor;
    }

    public void setDistributor(Distributor distributor) {
        this.distributor = distributor;
    }
    

    
    


	public Date getProduceDate() {
		return produceDate;
	}
	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}
	
	@OneToMany(fetch = FetchType.EAGER)
	public List<Producer> getProducers() {
		return producers;
	}
	public void setProducers(List<Producer> producers) {
		this.producers = producers;
	}

	


}
