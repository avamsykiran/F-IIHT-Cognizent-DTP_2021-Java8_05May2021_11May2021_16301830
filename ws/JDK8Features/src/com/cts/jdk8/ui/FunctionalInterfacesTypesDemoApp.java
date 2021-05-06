package com.cts.jdk8.ui;

import java.time.LocalDateTime;

import com.cts.jdk8.service.BiPredicate;
import com.cts.jdk8.service.IntegerPredicate;
import com.cts.jdk8.service.StringConsumer;
import com.cts.jdk8.service.StringSupplier;

public class FunctionalInterfacesTypesDemoApp {

	public static void main(String[] args) {
	
		StringSupplier orgTitle = () -> "Congnizent";
		StringSupplier domain = () -> "cts.com";
		
		StringSupplier greet = () -> {
			String greeting=null;
			int h = LocalDateTime.now().getHour();
			
			if(h>=3 && h<=11)
				greeting="Good Morning";
			else if(h>=12 && h<=16)
				greeting="Good Afternoon";
			else
				greeting="Good Evening";
			
			return greeting;
		};
		
		StringConsumer printLength = s -> System.out.println(s.length());
		
		IntegerPredicate isEven = n -> n%2==0;
		IntegerPredicate isPrime = a -> {
			int count=2;
			for(int i=2;i<=a/2;i++) {
				if(a%i==0) {
					count++;
					break;
				}
			}
			return count==2;
		};
		
		BiPredicate<Object, Object> areComaprable = (o1,o2) -> {		
			return o1 instanceof Comparable || o2 instanceof Comparable ;
		};
		
		System.out.println(orgTitle.get());
		System.out.println(domain.get());
		System.out.println(greet.get());
		printLength.use("Vamsy");
		System.out.println(isEven.check(78));
		System.out.println(isPrime.check(78));
	}

}
