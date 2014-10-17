package com.johnkuper.epam.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.johnkuper.epam.model.CarWeb;
import com.johnkuper.epam.model.CustomerWeb;
import com.johnkuper.epam.model.MerchantWeb;
import com.johnkuper.epam.model.StoreWeb;
import com.johnkuper.response.ResponseParserImpl;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientService {

	final static Logger logger = LoggerFactory.getLogger("JohnKuper");
	private Client client;
	private WebResource webResource;
	private ResponseParserImpl parser = new ResponseParserImpl();

	public ClientService() {

		this.client = Client.create();
		this.webResource = client.resource("http://localhost:8080/base/");
	}

	private String calledMethod(String methodName) {
		return String.format("--- Client method '%s' was called", methodName);
	}

	private void createOrUpdate(String jsonInput, String path) {

		ClientResponse response = webResource.path(path)
				.type("application/json").post(ClientResponse.class, jsonInput);

		String status = parser.getResponseStatus(response);
		logger.debug("--- Output from Server --- \n{}", status);

	}

	private <T> T findOne(int id, String path, Class<T> clazz) {

		ClientResponse response = webResource.path(path + "/findOne/" + id)
				.accept("application/json").get(ClientResponse.class);

		T model = parser.getSingleData(response, path, clazz);
		return model;
	}

	// cars resource requests
	public List<CarWeb> findCarByName(String name) {

		logger.debug(calledMethod("findCarByName"));
		ClientResponse response = webResource.path("cars/findByName/" + name)
				.accept("application/json").get(ClientResponse.class);

		List<CarWeb> cars = parser.getMultiData(response, "cars", CarWeb.class);
		return cars;

	}

	public CarWeb findCar(int id) {

		logger.debug(calledMethod("findCar"));
		CarWeb car = findOne(id, "cars", CarWeb.class);

		return car;

	}

	public void createCar() {

		logger.debug(calledMethod("createCar"));
		String jsonInput = "{\"car_mark\":\"Mercedes\",\"car_model\":\"R10\",\"motorpower\":\"567\",\"car_color\":\"Малиновый\"}";
		String path = "cars/create";
		createOrUpdate(jsonInput, path);
	}

	public void updateCar() {

		logger.debug(calledMethod("updateCar"));
		String jsonInput = "{\"id\":6,\"car_mark\":\"Audi\",\"car_model\":\"R10\",\"motorpower\":\"567\",\"car_color\":\"Бурый\"}";
		String path = "cars/update";
		createOrUpdate(jsonInput, path);

	}

	public List<CarWeb> findCarsByMotorPower(int minPower, int maxPower) {

		logger.debug(calledMethod("findCarsByMotorPower"));
		String min = String.valueOf(minPower);
		String max = String.valueOf(maxPower);
		ClientResponse response = webResource.path("cars/findByMotorPower")
				.queryParam("min", min).queryParam("max", max)
				.accept("application/json").get(ClientResponse.class);

		List<CarWeb> cars = parser.getMultiData(response, "cars", CarWeb.class);
		return cars;

	}

	// customers resource requests
	public void createCustomer() {

		logger.debug(calledMethod("createCustomer"));
		String jsonInput = "{\"custName\":\"Петр\",\"custSurname\":\"Грозный\",\"custPatronymic\":\"Васильевич\",\"passportSeries\":\"2390\",\"passportNumber\":\"906090\",\"dateOfBirth\":\"1990-05-22\"}";
		String path = "customers/create";
		createOrUpdate(jsonInput, path);

	}

	public CustomerWeb findCustomer(int id) {

		logger.debug(calledMethod("findCustomer"));
		CustomerWeb customer = findOne(id, "customers", CustomerWeb.class);

		return customer;
	}

	// merchants resource requests
	public MerchantWeb findMerchant(int id) {

		logger.debug(calledMethod("findCustomer"));
		MerchantWeb merchant = findOne(id, "merchants", MerchantWeb.class);

		return merchant;

	}

	public void createMerchant() {

		logger.debug(calledMethod("createMerchant"));
		String jsonInput = "{\"merchName\":\"Николай\",\"merchSurname\":\"Пчелкин\",\"merchPatronymic\":\"Ильин\"}";
		String path = "merchants/create";
		createOrUpdate(jsonInput, path);
	}

	// store resource requests

	public List<StoreWeb> findCarsBetweenPrices(BigDecimal minPrice,
			BigDecimal maxPrice) {

		logger.debug(calledMethod("findCarsBetweenPrices"));
		String min = String.valueOf(minPrice);
		String max = String.valueOf(maxPrice);
		ClientResponse response = webResource.path("store/findByPrice")
				.queryParam("min", min).queryParam("max", max)
				.accept("application/json").get(ClientResponse.class);

		List<StoreWeb> stores = parser.getMultiData(response, "store",
				StoreWeb.class);
		return stores;
	}

}
