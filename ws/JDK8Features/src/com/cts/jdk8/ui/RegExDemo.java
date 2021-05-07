package com.cts.jdk8.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo {

	public static void main(String[] args) {
		String mobile = "9052224753";
		String mobile2 = "12345";
		
		//System.out.println(mobile.matches("[1-9][0-9]{9}"));
		//System.out.println(mobile2.matches("[1-9][0-9]{9}"));
		
		Pattern mobP = Pattern.compile("[1-9][0-9]{9}");
		
		Matcher m1 = mobP.matcher(mobile);
		System.out.println(m1.matches());
		
		System.out.println(mobP.matcher(mobile2).matches());
		
		
		String passage = "I have to port 9052224753 into a new 9948016004, and yet want to keep 9948016004";
		Matcher m2 = mobP.matcher(passage);
		System.out.println(m2.matches());
		System.out.println(m2.find());
		
		
	}

}
