package com.johnkuper.epam.main;

import com.johnkuper.epam.service.ClientService;

public class ClientApp {

	public static void main(String[] args) {

		ClientService service = new ClientService();
		service.findCar(1);
		service.findCarByName("Audi");
		//service.createCar();
		service.updateCar();
		service.findCarsByMotorPower(100, 500);
	}

}
