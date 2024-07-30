package com.iiht.ioc;

public class Apples implements Comparable<Apples> {
    private int quantity;
    private String company;
    private int expiryDays;

    public Apples(int quantity, String company, int expiryDays) {
        this.quantity = quantity;
        this.company = company;
        this.expiryDays = expiryDays;
    }

    public Apples() {
        // Default constructor
    }

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

    public void setExpiryDays(int expiryDays) {
        this.expiryDays = expiryDays;
    }

    @Override
    public String toString() {
        return "Apples [quantity=" + quantity + ", company=" + company + ", expiryDays=" + expiryDays + "]";
    }

    @Override
    public int compareTo(Apples other) {
        // Example comparison based on expiryDays
        return Integer.compare(this.expiryDays, other.expiryDays);
    }
}
