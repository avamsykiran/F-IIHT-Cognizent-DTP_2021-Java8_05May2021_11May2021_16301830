package com.cts.jdk8.ui;

import com.cts.jdk8.service.Computable;
import com.cts.jdk8.service.Computator;

public class LambdaExpressionDemoApp {
	public static void main(String a[]) {
		Computator cpt = new Computator();
		System.out.println(cpt.compute(12, 22));

		Computable cpt2 = new Computable() {
			@Override
			public int compute(int a, int b) {
				return a * b;
			}
		};
		System.out.println(cpt2.compute(12, 22));

		Computable cpt3 = (n1, n2) -> n1 > n2 ? n1 : n2;
		System.out.println(cpt3.compute(12, 22));
	}
}