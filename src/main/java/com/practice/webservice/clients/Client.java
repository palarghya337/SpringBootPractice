package com.practice.webservice.clients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.springboot.utils.Log;
import com.practice.webservice.bean.Country;

public class Client {

	private static final String PORT = "http://localhost:8080/";
	public static void main(String[] args) {
		
		Log.logInfo("\n1. allCountries\n2. Country\n3. Update Country\n"
				+ "4. Add Country");
		try (Scanner scan = new Scanner(System.in)) {
			
			int input = scan.nextInt();
			switch(input) {
			case 1: {
				Collection<?> allCountries = callGETMethod("allCountries", Collection.class);
				allCountries.forEach(Log::logInfo);
				break;
			}
			case 2: {
				Country country = callGETMethod("country/3", Country.class);
				Log.logInfo(country);
				break;
			}
			case 3: {
				Country updateCountry = callGETMethod("country/2", Country.class);
				updateCountry.setPopulation(1110);
				boolean isSuccessful = callPUTMethod("updateCountry", updateCountry);
				Log.logInfo("isSuccessful: {0}", isSuccessful);
				break;
			}
			case 4: {
				Country newCountry = new Country(5, "Nepal");
				newCountry.setPopulation(3000);
				boolean isSuccessful = callPOSTMethod("addNewCountry", newCountry);
				Log.logInfo("isSuccessfull: {0}", isSuccessful);
				break;
			}
			case 5: {
				callDELETEMethod("deleteCountry", 5);
			}
			}
		}
	}

	private static void callDELETEMethod(String uri, int countryID) {
		/*
		 * 
		 * HttpClient client = HttpClientBuilder.create().build(); HttpDelete
		 * deleteRequest = new HttpDelete(PORT.concat(uri));
		 * deleteRequest.setEntity(createHttpEntity(countryID)); try { HttpResponse
		 * response = client.execute(deleteRequest); return
		 * convertJsonToObject(Boolean.class, response); } catch (IOException e) {
		 * Log.logInfo("Exception while getting response from server {0}", e); } return
		 * false;
		 */}
	private static boolean callPOSTMethod(String uri, Country newCountry) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(PORT.concat(uri));
		postRequest.setEntity(createHttpEntity(newCountry));
		try {
			HttpResponse response = client.execute(postRequest);
			return convertJsonToObject(Boolean.class, response);
		} catch (IOException e) {
			Log.logInfo("Exception while getting response from server {0}", e);
		}
		return false;
	}
	private static <T> boolean callPUTMethod(String uri, T toUpdateObject) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut putRequest = new HttpPut(PORT.concat(uri));
		putRequest.setEntity(createHttpEntity(toUpdateObject));
		try {
			HttpResponse response = client.execute(putRequest);
			return convertJsonToObject(Boolean.class, response);
		} catch (IOException e) {
			Log.logInfo("Exception while getting response from server", e);
		}
		return false;
	}
	private static <T> HttpEntity createHttpEntity(T toUpdateObject) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String value = mapper.writeValueAsString(toUpdateObject);
			StringEntity entity = new StringEntity(value);
			entity.setContentType(ContentType.APPLICATION_JSON.toString());
			return entity;
		} catch (JsonProcessingException | UnsupportedEncodingException e) {
			Log.logInfo("Exception while creating HttpEntity object", e);
		}
		return null;
	}
	private static <T> T callGETMethod(String uri, Class<T> outputClass) {
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet  getRequest = new HttpGet(PORT.concat(uri));
		try {
			HttpResponse response = client.execute(getRequest);
			return convertJsonToObject(outputClass, response);
		} catch (IOException e) {
			Log.logInfo("Exception while getting response from server", e);
		}
		return null;
	}
	private static <T> T convertJsonToObject(Class<T> outputClass, HttpResponse response)
			throws IOException, JsonParseException, JsonMappingException {
		HttpEntity entity = response.getEntity();
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(entity.getContent(), outputClass);
	}
}
