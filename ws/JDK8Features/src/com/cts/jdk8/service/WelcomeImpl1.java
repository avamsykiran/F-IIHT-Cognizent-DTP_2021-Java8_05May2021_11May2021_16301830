package com.cts.jdk8.service;

public class WelcomeImpl1 implements Welcome{

	@Override
	public String doWelcome(String username) {
		return "Namasthey " + username;
	}

}
