package com.practice.webservice.bean;

import org.springframework.stereotype.Component;

@Component(value = "country")
public class Country {

	private int id;
	private String name;
	private Integer population;
	
	public Country() {
		// Default constructor
	}
	public Country(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
}
