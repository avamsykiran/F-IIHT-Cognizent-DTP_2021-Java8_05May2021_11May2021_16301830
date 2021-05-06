package com.cts.jdk8.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.cts.jdk8.model.Employee;

public class EmployeeApp {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee(110, "Vamsy", LocalDate.now(), 45000),
				new Employee(101, "Arun", LocalDate.now().plusMonths(1), 24500),
				new Employee(107, "Zameer", LocalDate.now().minusMonths(1), 20500),
				new Employee(103, "Gopi", LocalDate.now().minusMonths(2), 54500),
				new Employee(104, "Srinu", LocalDate.now().plusMonths(2), 4500),
				new Employee(105, "Indu", LocalDate.now().plusMonths(3), 4500),
				new Employee(102, "Sharma", LocalDate.now(), 14500));

		for (Employee e : emps) {
			System.out.println(e);
		}

		System.out.println("--------------------------------------------");

		Collections.sort(emps);
		for (Employee e : emps) {
			System.out.println(e);
		}

		System.out.println("--------------------------------------------");

		Collections.sort(emps, (a, b) -> a.getName().compareTo(b.getName()));
		for (Employee e : emps) {
			System.out.println(e);
		}
		System.out.println("--------------------------------------------");

		Collections.sort(emps, (a, b) -> a.getHireDate().compareTo(b.getHireDate()));
		for (Employee e : emps) {
			System.out.println(e);
		}
		System.out.println("--------------------------------------------");

		Collections.sort(emps, (a, b) -> ((Double)a.getSalary()).compareTo(b.getSalary()));
		for (Employee e : emps) {
			System.out.println(e);
		}
	}

}
