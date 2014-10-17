package com.johnkuper.epam.model;

import java.math.BigDecimal;
import java.sql.Date;

public class SaleWeb {

	private int id;
	private CarWeb car;
	private CustomerWeb customer;
	private MerchantWeb merchant;
	private BigDecimal salePrice;
	private Date dateOfSale;

	public SaleWeb() {
	}

	public SaleWeb(CarWeb car, CustomerWeb customer, MerchantWeb merchant,
			BigDecimal salePrice, Date saleTime) {
		this.car = car;
		this.customer = customer;
		this.merchant = merchant;
		this.salePrice = salePrice;
		this.dateOfSale = saleTime;
	}

	@Override
	public String toString() {
		return String.format("SaleWeb: {id = " + id + "; salePrice = "
				+ salePrice + "; dateOfSale = " + dateOfSale + "%n" + car
				+ "%n" + customer + "%n" + merchant + "%n");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CarWeb getCar() {
		return car;
	}

	public void setCar(CarWeb car) {
		this.car = car;
	}

	public CustomerWeb getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerWeb customer) {
		this.customer = customer;
	}

	public MerchantWeb getMerchant() {
		return merchant;
	}

	public void setMerchant(MerchantWeb merchant) {
		this.merchant = merchant;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Date getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(Date dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

}
