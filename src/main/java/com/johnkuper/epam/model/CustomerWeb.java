package com.johnkuper.epam.model;

import java.util.Date;

public class CustomerWeb {

	private int id;
	private String custName;
	private String custSurname;
	private String custPatronymic;
	private String passportSeries;
	private String passportNumber;
	private Date dateOfBirth;

	public CustomerWeb() {
	}

	public CustomerWeb(String custName, String custSurname,
			String custPatronymic, String passportSeries,
			String passportNumber, Date dateOfBirth) {
		this.custName = custName;
		this.custSurname = custSurname;
		this.custPatronymic = custPatronymic;
		this.passportSeries = passportSeries;
		this.passportNumber = passportNumber;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "CustomerWeb: {id = " + id + "; custName = " + custName
				+ "; custSurname = " + custSurname + "; custPatronymic = "
				+ custPatronymic + "; passportSeries = " + passportSeries
				+ "; passportNumber = " + passportNumber + "; dateOfBirth = "
				+ dateOfBirth + "}";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustSurname() {
		return custSurname;
	}

	public void setCustSurname(String custSurname) {
		this.custSurname = custSurname;
	}

	public String getCustPatronymic() {
		return custPatronymic;
	}

	public void setCustPatronymic(String custPatronymic) {
		this.custPatronymic = custPatronymic;
	}

	public String getPassportSeries() {
		return passportSeries;
	}

	public void setPassportSeries(String passportSeries) {
		this.passportSeries = passportSeries;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
