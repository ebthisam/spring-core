package com.iiht.ioc;

public class Milk {
	int quantity;
    String company;
    int expiryDays;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getExpiryDays() {
		return expiryDays;
	}
	public void setExpiryDate(int expiryDays) {
		this.expiryDays = expiryDays;
	}
	public Milk(int quantity, String company, int expiryDays) {
		super();
		this.quantity = quantity;
		this.company = company;
		this.expiryDays = expiryDays;
	}
	@Override
	public String toString() {
		return "Milk [quantity=" + quantity + ", company=" + company + ", expiryDate=" + expiryDays + "]";
	}
    public Milk() {
		// TODO Auto-generated constructor stub
	}

}
