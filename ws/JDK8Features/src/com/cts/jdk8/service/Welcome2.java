package com.cts.jdk8.service;

public interface Welcome2 {
	
	static String wish() {
		return "Good Morning ";
	}
	
	default String doGreet(String username) {
		return "Good to see you again, "+username+"?";
	}
	
	String doWelcome(String username);
}
