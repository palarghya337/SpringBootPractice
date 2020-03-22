package com.practice.webservice.services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.practice.webservice.bean.Country;

@Service(value = "countryService")
public class CountryService {

	private static final Map<Integer, Country> COUNTRY_MAP = new HashMap<>();
	
	public CountryService() {
		// Default countries
		COUNTRY_MAP.put(1, new Country(1, "India"));
		COUNTRY_MAP.put(2, new Country(2, "Bangladesh"));
		COUNTRY_MAP.put(3, new Country(3, "Srilanka"));
		COUNTRY_MAP.put(4, new Country(4, "Pakisthan"));
	}

	public Collection<Country> getAllCountries() {
		return Collections.unmodifiableCollection(COUNTRY_MAP.values());
	}

	public Country getCountry(int id) {
		return COUNTRY_MAP.get(id);
	}

	public boolean updateCountry(Country country) {
		
		Objects.requireNonNull(country);
		COUNTRY_MAP.put(country.getId(), country);
		return true;
	}
}
