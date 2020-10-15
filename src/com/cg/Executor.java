package com.cg;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Executor {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome To Hotel Reservation System!!!");
		Scanner sc = new Scanner(System.in);
		
		List<HotelDetails> hotelBook = new ArrayList<>();
		List<Float> totalPrice = new ArrayList<>();
		
		HotelDetails lakewood = new HotelDetails("Lakewood", 110);
		HotelDetails bridgewood = new HotelDetails("Bridgewood", 160);
		HotelDetails ridgewood = new HotelDetails("Ridgewood", 220);
		
		hotelBook.add(lakewood);
		hotelBook.add(bridgewood);
		hotelBook.add(ridgewood);
		
		System.out.println("Name Of Hotel And Rates Of Regular Customers Added");
		
	}
}
