package com.overthinkpro.appdemo.common;

import java.time.Instant;
import java.util.Date;

public class DateTime {
	public static void main(String[] args) {
//		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//		String str = new Date(date).toString();
//		System.out.println(date);
		System.out.println(new Date().toInstant());
		System.out.println(Instant.now());
		
//		Instant a = new Date().toInstant();
//		System.out.println(a.getClass());
		
	}
}
