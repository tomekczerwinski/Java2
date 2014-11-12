package com.example.servletjspdemo.service;
import java.util.ArrayList;
import java.util.List;

import com.example.servletjspdemo.domain.OsobaBaza;
import com.example.servletjspdemo.domain.Person;


public class StorageServiceTomek {
	
	private List<OsobaBaza> db = new ArrayList<OsobaBaza>();
	
	public void add(OsobaBaza osoba){
		OsobaBaza nowaOsoba = new OsobaBaza(osoba.getName(), osoba.getRokUr(),osoba.getPlec(), osoba.getHobby(), osoba.getOpis(), osoba.getWyksztalcenie(), osoba.getPrawoJazdy());
		db.add(nowaOsoba);
	}
	
	public List<OsobaBaza> getAllPersons(){
		return db;
	}
	
	public int size()
		{
			return db.size();
		}

}
