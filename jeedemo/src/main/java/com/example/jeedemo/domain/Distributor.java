package com.example.jeedemo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
@NamedQueries({
    @NamedQuery(name = "distributor.all", query = "select d from Distributor d order by d.id"),
    @NamedQuery(name = "distributor.avilable", query = "Select d from Distributor d where d.avilable = true")
})
public class Distributor implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private boolean avilable=true;

    private String name;

    public Distributor() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }

	public boolean isAvilable() {
		return avilable;
	}

	public void setAvilable(boolean avilable) {
		this.avilable = avilable;
	}

}
