package com.cts.ddd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.ddd.application.UserService;
import com.cts.ddd.domain.user.Address;
import com.cts.ddd.domain.user.ContactInformation;
import com.cts.ddd.domain.user.FullName;
import com.cts.ddd.domain.user.User;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		FullName fullName = new FullName("AdminUser", "AdminUser");
		ContactInformation contactInformation = new ContactInformation();
		contactInformation.setEmailId("gow.cute@gmail.com");
		contactInformation.setTelephoneNo("1234567890");

		Address address = new Address();
		address.setCity("Vellore");
		address.setDoorNo("123");
		address.setPinCode("645678");
		address.setPlotNo("No.11");
		address.setStreetName("street 1");

		User user = new User("admin", "password", "admin", fullName, contactInformation, address);
		userService.addUser(user);
		
		user = new User("emp01", "password", "employee", fullName, contactInformation, address);
		userService.addUser(user);
		
		user = new User("user01", "password", "customer", fullName, contactInformation, address);
		userService.addUser(user);
	}
}
