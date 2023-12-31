package com.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employeeList = new ArrayList<Employee>();
        
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
		
		
		System.out.println(employeeList.stream()
        .filter(e -> (e.getGender()=="Male" && e.getDepartment()=="Product Development"))
		.collect(Collectors.minBy(Comparator.comparing(Employee::getAge))));
		

		System.out.println(employeeList.stream()
        .filter(e -> (e.getGender()=="Male" && e.getDepartment()=="Product Development"))
		.min(Comparator.comparing(Employee::getAge)));

		// https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
		
	
		Map<String, Long> noOfMaleAndFemaleEmployees =
		employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		// The partitioningBy() method takes a Predicate, whereas groupingBy() takes a Function.         
		System.out.println(noOfMaleAndFemaleEmployees);
		System.out.println(employeeList.stream().map(Employee::getGender)
				.filter(e -> e.equalsIgnoreCase("male")).count());
		System.out.println(employeeList.stream()
				.collect(Collectors.partitioningBy(e-> e.getGender().equalsIgnoreCase("Male"), 
						Collectors.counting())));
		
		
		// HashMap
		
		Map<String, Integer> budget = new HashMap<>(); 
		budget.put("clothes", 120); 
		budget.put("grocery", 150); 
		budget.put("transportation", 100); 		
		budget.put("utility", 130); 
		budget.put("rent", 1150); 
		budget.put("miscellneous", 90);

		Map<String, Integer> sortedByValueDesc = budget.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, 
				               Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		// now let's sort the map in decreasing order of keys 
		Map<String, Integer> sorted = budget
				.entrySet() 
				.stream() 
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey())) 
				.collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		
			
	}

}
