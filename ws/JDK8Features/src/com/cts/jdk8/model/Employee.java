package com.cts.jdk8.model;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>{
	
	private int empId;
	private String name;
	private LocalDate hireDate;
	private double salary;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String name, LocalDate hireDate, double salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.hireDate = hireDate;
		this.salary = salary;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public int compareTo(Employee o) {
		return this.empId==o.empId?0:this.empId>o.empId?1:-1;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", hireDate=" + hireDate + ", salary=" + salary + "]";
	}
	
	

}
