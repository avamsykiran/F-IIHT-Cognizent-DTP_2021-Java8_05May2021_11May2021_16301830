package com.cts.jdk8.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.cts.jdk8.model.Employee;

public class EmployeeStreamApp {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
				new Employee(110, "Vamsy", LocalDate.now(), 45000, Arrays.asList("Java", "Mysql", "Spring")),
				new Employee(101, "Arun", LocalDate.now().plusMonths(1), 24500, Arrays.asList("Java", "Mysql")),
				new Employee(107, "Zameer", LocalDate.now().minusMonths(1), 20500, Arrays.asList("Java", "Spring")),
				new Employee(103, "Gopi", LocalDate.now().minusMonths(2), 54500, Arrays.asList("Java", "Spring")),
				new Employee(104, "Srinu", LocalDate.now().plusMonths(2), 4500, Arrays.asList("Angular", "Mongo")),
				new Employee(105, "Indu", LocalDate.now().plusMonths(3), 4500, Arrays.asList("DevOps")),
				new Employee(102, "Sharma", LocalDate.now(), 14500, Arrays.asList("Desing", "UML")));

		// emps.stream().forEach(e -> System.out.println(e));
		emps.stream().forEach(System.out::println);

		System.out.println("-----------------------------------------");
		Map<Integer, Employee> empsMap = emps.stream().collect(Collectors.toMap(e -> e.getEmpId(), e -> e));
		System.out.println(empsMap);

		System.out.println("-----------------------------------------");
		Set<Employee> empSet = emps.stream().collect(Collectors.toSet());
		System.out.println(empSet);

		System.out.println("-------------------------------------------");
		Optional<Employee> highestPaid = emps.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
		System.out.println(highestPaid.isPresent() ? highestPaid.get() : null);

		System.out.println("-------------------------------------------");
		Optional<Employee> senior = emps.stream()
				.reduce((e1, e2) -> e1.getHireDate().isBefore(e2.getHireDate()) ? e1 : e2);
		System.out.println(senior.isPresent() ? senior.get() : null);

		System.out.println("-------------------------------------------");
		// emps.stream().map(e -> e.getName()).forEach(System.out::println);
		List<String> names = emps.stream().map(e -> e.getName()).collect(Collectors.toList());
		System.out.println(names);

		System.out.println("-------------------------------------------");
		emps.stream().filter(e -> e.getHireDate().getMonth() == LocalDate.now().getMonth())
				.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		// emps.stream().map(e -> e.getName()).forEach(System.out::println);
		//List<List<String>> skills = emps.stream().map(e -> e.getSkills()).collect(Collectors.toList());
		
		//List<String> skills = emps.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.toList());
		List<String> skills = emps
				.stream()
				.flatMap(e -> e.getSkills().stream())
				.distinct()							
				.collect(Collectors.toList());
		
		System.out.println(skills);

	}

}
