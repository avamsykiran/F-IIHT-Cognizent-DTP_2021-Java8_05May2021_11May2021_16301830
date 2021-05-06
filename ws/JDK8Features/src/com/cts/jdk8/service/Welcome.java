package com.cts.jdk8.service;

public interface Welcome {
	
	static String wish() {
		return "Good Morning ";
	}
	
	default String doGreet(String username) {
		return "How are you doing today, "+username+"?";
	}
	
	String doWelcome(String username);
}
