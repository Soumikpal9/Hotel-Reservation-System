package com.cg;

public class HotelDetailsRewardCustomer {
	public String name;
	public int ratesRewardCustomerWeekdays;
	public int ratesRewardCustomerWeekend;
	public int ratings;
	
	public HotelDetailsRewardCustomer(String name, int ratesRewardCustomerWeekdays, int ratesRewardCustomerWeekend, int ratings) {
		this.name = name;
		this.ratesRewardCustomerWeekdays = ratesRewardCustomerWeekdays;
		this.ratesRewardCustomerWeekend = ratesRewardCustomerWeekend;
		this.ratings = ratings;
	}
}
