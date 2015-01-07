package com.example.jsfdemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Game {
	private int dataWydania =0;
	private String name = "";
	private String dystrybutor = "";
	private ArrayList<String> platforma = null;
	private float cena =0;
	private String pegi ="";
	private long uuid = UUID.randomUUID().getLeastSignificantBits();
	private String uniqueId ="";
	private Date produceDate = new Date();
	private int rate =0;
	private boolean editable=false;


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDataWydania() {
		return dataWydania;
	}
	public void setDataWydania(int dataWydania) {
		this.dataWydania = dataWydania;
	}
	
	public String getDystrybutor() {
		return dystrybutor;
	}
	public void setDystrybutor(String dystrybutor) {
		this.dystrybutor = dystrybutor;
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
	
	
	public long getUuid() {
		return uuid;
	}
	public void setUuid(long uuid) {
		this.uuid = uuid;
	}	
	/*
	private String firstName = "unknown";
	private String zipCode = "";
	private String pin = "";
	private Date dateOfBirth = new Date();
	private double weight;
	private boolean married;
	private int numOfChildren;
	
	@Size(min = 2, max = 20)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Pattern(regexp = "[0-9]{2}-[0-9]{3}")
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	@Size(min = 2)
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	@Min(0)
	public int getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	
	@Past
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	


public class Game {
	   private String name;
	   private String platforma;
	   private double cena;
	   private String pegi;
	   private boolean canEdit;

	   public Game (String name,String platforma,double cena,String pegi){
	      this.name = name;
	      this.platforma = platforma;
	      this.cena = cena;
	      this.pegi = pegi;
	      canEdit = false;
	   }

	   public String getName() {
	      return name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getPlatforma() {
	      return platforma;
	   }

	   public void setPlatforma(String platforma) {
	      this.platforma = platforma;
	   }

	   public double getCena() {
	      return cena;
	   }

	   public void setAge(double cena) {
	      this.cena = cena;
	   }

	   public String getPegi() {
	      return pegi;
	   }

	   public void setPegi(String pegi) {
	      this.pegi = pegi;
	   }

	   public boolean isCanEdit() {
	      return canEdit;
	   }

	   public void setCanEdit(boolean canEdit) {
	      this.canEdit = canEdit;
	   }*/
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public Date getProduceDate() {
		return produceDate;
	}
	public void setProduceDate(Date produceDate) {
		this.produceDate = produceDate;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	}
	
