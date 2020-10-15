package com.cg;

public class HotelDetails {
	public String name;
	public int ratesRegularCustomerWeekdays;
	public int ratesRegularCustomerWeekend;
	
	public HotelDetails(String name, int ratesRegularCustomerWeekdays, int ratesRegularCustomerWeekend) {
		this.name = name;
		this.ratesRegularCustomerWeekdays = ratesRegularCustomerWeekdays;
		this.ratesRegularCustomerWeekend = ratesRegularCustomerWeekend;
	}
}
