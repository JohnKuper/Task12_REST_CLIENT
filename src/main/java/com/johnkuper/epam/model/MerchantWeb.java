package com.johnkuper.epam.model;


public class MerchantWeb {

	private int id;
	private String merchName;
	private String merchSurname;
	private String merchPatronymic;

	public MerchantWeb() {
	}

	public MerchantWeb(String merchName, String merchSurname,
			String merchPatronymic) {
		this.merchName = merchName;
		this.merchSurname = merchSurname;
		this.merchPatronymic = merchPatronymic;
	}

	@Override
	public String toString() {
		return "MerchantWeb: {id = " + id + "; merchName = " + merchName
				+ "; merchSurname = " + merchSurname + "; merchPatronymic = "
				+ merchPatronymic + "}";
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMerchName() {
		return merchName;
	}

	public void setMerchName(String merchName) {
		this.merchName = merchName;
	}

	public String getMerchSurname() {
		return merchSurname;
	}

	public void setMerchSurname(String merchSurname) {
		this.merchSurname = merchSurname;
	}

	public String getMerchPatronymic() {
		return merchPatronymic;
	}

	public void setMerchPatronymic(String merchPatronymic) {
		this.merchPatronymic = merchPatronymic;
	}

}
