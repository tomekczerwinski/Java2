package com.example.servletjspdemo.domain;

public class Game {

	private int dataWydania =0;
	public int id =0;
	private String nazwaD = "";
	private String name = "";
	private String dystrybutor = "";
	private String platforma = "";
	private float cena =0;
	private String pegi ="";
	public static int lastID = 0;


	

	public Game() {
		super();
	}
	
	public Game(int dataWydania, int id, String nameD, String name, String dystrybutor, String platforma, float cena, String pegi) {
		super();
		this.dataWydania = dataWydania;
		this.id = id;
		this.nazwaD = nazwaD;
		this.name = name;
		this.dystrybutor = dystrybutor;
		this.platforma = platforma;
		this.cena = cena;
		this.pegi = pegi;

	}

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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDystrybutor() {
		return dystrybutor;
	}
	public void setDystrybutor(String dystrybutor) {
		this.dystrybutor = dystrybutor;
	}
	
	public String getPlatforma() {
		return platforma;
	}
	public void setPlatforma(String platforma) {
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

}
