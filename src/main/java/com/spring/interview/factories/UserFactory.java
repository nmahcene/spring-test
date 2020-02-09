package com.spring.interview.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.spring.interview.objects.user.Admin;
import com.spring.interview.objects.user.Employee;
import com.spring.interview.objects.user.Manager;
import com.spring.interview.objects.user.User;
import com.spring.interview.objects.user.User.Permission;

public class UserFactory {

    private static char letter = 'A';

    /**
     * Implement the getUser factory method.
     * @param admin 
     * 
     * @return the new User created.
     * 
     * Some refactoring are needed, just to demonstrate the logic ( What i understand )
     */
    public static User getUser(User.Permission p) {
    	Random random = new Random();
    	switch (p) 
    	{
        case ADMIN:
	          User adminUSer = new Admin();
	          adminUSer.setName(getRandomName());
	          adminUSer.setBirthDay(RandomBirthDate.getBirthDay());
	          adminUSer.setActive(random.nextInt() % 2 == 0 ? true: false);
	          return adminUSer;
        case MANAGER :
	          User managerUSer = new Manager();
	          managerUSer.setName(getRandomName());
	          managerUSer.setBirthDay(RandomBirthDate.getBirthDay());
	          managerUSer.setActive(random.nextInt() % 2 == 0 ? true: false);
	          return managerUSer;
    	case EMPLOYEE :
	          User EmployeeUser = new Employee();
	          EmployeeUser.setName(getRandomName());
	          EmployeeUser.setBirthDay(RandomBirthDate.getBirthDay());
	          EmployeeUser.setActive(random.nextInt() % 2 == 0 ? true: false);
	          return EmployeeUser;
     	default:
      	  return null;
    	}
    }

    private static String getRandomName() {
        return new StringBuilder()
			.append(nextLetter())
			.append(nextLetter())
			.append(nextLetter())
			.append(nextLetter())
			.toString();
    }

    private static char nextLetter() {
        if (UserFactory.letter >= 'Z') {
        	UserFactory.letter = 'A';
        }
        return UserFactory.letter++;
    }

	public static List<User> generateUsers() {
		List<User> result = new ArrayList<>();
		List<User> adminUsers = GenerateUsers(2,Permission.ADMIN);
		
		/**
		 * Assume that each admin have the same list of manager ( My understand )
		 */
		List<User> managerUsers = GenerateUsers(5,Permission.MANAGER);
		List<Manager> managers = managerUsers.stream().map(e -> (Manager)e).collect(Collectors.toList());
		Manager[] manager = managers.toArray(new Manager[managers.size()]);
		adminUsers.stream().map(e -> (Admin)e).forEach(e -> e.addManagers(manager));
		

		/**
		 * Assume that each manager manager have the same list of employee ( My understand )
		 */

		List<User> employeeUsers = GenerateUsers(13,Permission.EMPLOYEE);
		List<Employee> employees = employeeUsers.stream().map(e -> (Employee)e).collect(Collectors.toList());
		Employee[] employee = employees.toArray(new Employee[employees.size()]);
		managerUsers.stream().map(e -> (Manager)e).forEach(e -> e.addEmployees(employee));

		/**
		 * Aggregate all lists
		 */
		
        result.addAll(adminUsers);
        result.addAll(managerUsers);
        result.addAll(employeeUsers);
        return result;
	}
	

	private static List<User> GenerateUsers(Integer usersNumbers, Permission permission) {
		List<User> users = new ArrayList<User>(usersNumbers);
		IntStream.range(0, usersNumbers).forEach(nbr -> users.add(getUser(permission)));
	    return users;
	}

}
