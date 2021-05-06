package com.cts.jdk8.service;

public class WelcomeImpl2 implements Welcome,Welcome2{

	@Override
	public String doWelcome(String username) {
		return "Hello " + username;
	}

	@Override
	public String doGreet(String username) {
		//return Welcome.super.doGreet(username);
		//return Welcome2.super.doGreet(username);
		return Welcome.super.doGreet(username) + "\n" +
		Welcome2.super.doGreet(username);
	}

}
