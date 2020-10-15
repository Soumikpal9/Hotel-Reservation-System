package com.cg;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Executor {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome To Hotel Reservation System!!!");
		Scanner sc = new Scanner(System.in);
		
		List<HotelDetails> hotelBook = new ArrayList<>();
		TreeMap<String, Float> totalPrice = new TreeMap<>();
		
		HotelDetails lakewood = new HotelDetails("Lakewood", 110, 90);
		HotelDetails bridgewood = new HotelDetails("Bridgewood", 150, 50);
		HotelDetails ridgewood = new HotelDetails("Ridgewood", 220, 150);
		
		hotelBook.add(lakewood);
		hotelBook.add(bridgewood);
		hotelBook.add(ridgewood);
		
		System.out.println("Name Of Hotel And Rates Of Regular Customers On Weekdays And Weekend Added");
		
		System.out.println("Enter the range of dates(comma seperated) : ");
		String dateRange = sc.nextLine();
		String[] dates = dateRange.split(",");
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		float noOfDays = (difference/(1000*60*60*24)) + 1;
		
		int start  = checkin.getDay();
		for(HotelDetails j : hotelBook) {
			float price = 0;
			for(int i = 0; i < noOfDays; i++) {
				if(start == 0 || start == 6) {
					price += j.ratesRegularCustomerWeekend;
				}
				else {
					price += j.ratesRegularCustomerWeekdays;
				}
				start = (start + 1) % 7;
			}
			totalPrice.put(j.name, price);
		}
		
		System.out.println("The Cheapest Hotel Found : " + totalPrice.firstEntry());
		
	}
}
