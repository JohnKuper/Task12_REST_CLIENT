package com.johnkuper.epam.main;

import java.math.BigDecimal;

import com.johnkuper.epam.service.ClientService;

public class ClientApp {

	public static void main(String[] args) {

		ClientService service = new ClientService();
		service.findCar(1);
		service.findCarByName("Audi");
		service.createCar();
		service.updateCar();
		service.findCarsByMotorPower(100, 500);
		service.createCustomer();
		service.findCustomer(6);
		service.createMerchant();
		service.findMerchant(4);
		BigDecimal minPrice = new BigDecimal(400500.50);
		BigDecimal maxPrice = new BigDecimal(900900.90);
		service.findCarsBetweenPrices(minPrice, maxPrice);
		service.getAllCarsFromStore();
		service.buyCar();
	}

}
