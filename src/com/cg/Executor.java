package com.cg;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Executor {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome To Hotel Reservation System!!!");
		Scanner sc = new Scanner(System.in);
		
		List<HotelDetailsRewardCustomer> hotelBook = new ArrayList<>();
		HashMap<String, Float> totalPrice = new HashMap<>();
		List<Integer> ratingList = new ArrayList<>(); 
		LinkedHashMap<String, Float> linkedHashMap = new LinkedHashMap<>();
		LinkedHashMap<Float, Integer> linkedHashMapRating = new LinkedHashMap<>();
		ArrayList<Map.Entry<String, Float>> arrList = new ArrayList<>();
		
		HotelDetailsRewardCustomer lakewood = new HotelDetailsRewardCustomer("Lakewood", 80, 80, 3);
		HotelDetailsRewardCustomer bridgewood = new HotelDetailsRewardCustomer("Bridgewood", 110, 50, 4);
		HotelDetailsRewardCustomer ridgewood = new HotelDetailsRewardCustomer("Ridgewood", 100, 40, 5);
		
		hotelBook.add(lakewood);
		hotelBook.add(bridgewood);
		hotelBook.add(ridgewood);
		
		hotelBook.stream().forEach(i -> ratingList.add(i.ratings));
		
		
		System.out.println("Name And Ratings Of Hotel And Rates Of Regular Customers On Weekdays And Weekend Added");
		
		System.out.println("Enter the range of dates(comma seperated) : ");
		String dateRange = sc.nextLine();
		String[] dates = dateRange.split(",");
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
		
		Date checkin = (Date) sdf.parse(dates[0]);
		Date checkout = (Date) sdf.parse(dates[1]);
		long difference = checkout.getTime() - checkin.getTime();
		float noOfDays = (difference/(1000*60*60*24)) + 1;
		
		
		hotelBook.stream().forEach(j -> {
			float price = 0;
			int start  = checkin.getDay();
			for(int i = 0; i < noOfDays; i++) {
				if(start == 0 || start == 6) {
					price += j.ratesRewardCustomerWeekend;
				}
				else {
					price += j.ratesRewardCustomerWeekdays;
				}
				start = (start + 1) % 7;
			}
			totalPrice.put(j.name, price);
		});
		
		totalPrice.entrySet().stream().forEach(e -> arrList.add(e));
		
		Comparator<Entry<String, Float>> valueComparator = new Comparator<Map.Entry<String, Float>>(){
			@Override
			public int compare(Map.Entry<String, Float> e1, Map.Entry<String, Float> e2) {
				Float v1 = e1.getValue();
				Float v2 = e2.getValue();
				return v1.compareTo(v2);
			}
		};
		
		Collections.sort(arrList, valueComparator);
		
		int j = 0;
		for(Map.Entry<String, Float> e : arrList){
			linkedHashMap.put(e.getKey(), e.getValue());
			for(HotelDetailsRewardCustomer i : hotelBook){
				if(i.name.equals(e.getKey())) {
					if(j < 1) {
						System.out.println("The Cheapest Hotel With Best Rating Found : " + e + " With Rating : " + i.ratings);
						j++;
					}
				}
			}
		}
		
	}
}
