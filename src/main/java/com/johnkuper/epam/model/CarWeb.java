package com.johnkuper.epam.model;

public class CarWeb {

	private int id;
	private String car_mark;
	private String car_model;
	private int motorpower;
	private String car_color;

	public CarWeb() {
	}

	public CarWeb(String car_mark, String car_model, int motorpower,
			String car_color) {
		this.car_mark = car_mark;
		this.car_model = car_model;
		this.motorpower = motorpower;
		this.car_color = car_color;
	}

	@Override
	public String toString() {
		return "CarWeb: {id = " + id + "; car_mark = " + car_mark
				+ "; car_model = " + car_model + "; motorpower = " + motorpower
				+ "; car_color = " + car_color + "}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCar_mark() {
		return car_mark;
	}

	public void setCar_mark(String car_mark) {
		this.car_mark = car_mark;
	}

	public String getCar_model() {
		return car_model;
	}

	public void setCar_model(String car_model) {
		this.car_model = car_model;
	}

	public int getMotorpower() {
		return motorpower;
	}

	public void setMotorpower(int motorpower) {
		this.motorpower = motorpower;
	}

	public String getCar_color() {
		return car_color;
	}

	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}

}
