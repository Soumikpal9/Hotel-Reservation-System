package com.cg;

import java.util.ArrayList;
import java.util.List;

public class HotelDetails {
	public String name;
	public int ratesRegularCustomerWeekdays;
	public int ratesRegularCustomerWeekend;
	public int ratings;
	
	public HotelDetails(String name, int ratesRegularCustomerWeekdays, int ratesRegularCustomerWeekend, int ratings) {
		this.name = name;
		this.ratesRegularCustomerWeekdays = ratesRegularCustomerWeekdays;
		this.ratesRegularCustomerWeekend = ratesRegularCustomerWeekend;
		this.ratings = ratings;
	}
}
