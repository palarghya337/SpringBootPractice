package com.practice.webservice.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.webservice.bean.Country;
import com.practice.webservice.services.CountryService;

@RestController
public class CountryController {

	@Autowired
	@Qualifier(value = "countryService")
	private CountryService countryService;
	
	@GetMapping(path = "allCountries")
	public Collection<Country> getAllCountries() {
		return countryService.getAllCountries();
	}
	@GetMapping(path = "country/{id}")
	public Country getCountryByID(@PathVariable int id) {
		return countryService.getCountry(id);
	}
	@PutMapping(path = "updateCountry{id}")
	public boolean updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);
	}
}
