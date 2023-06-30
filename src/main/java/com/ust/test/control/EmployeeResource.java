package com.ust.test.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeResource {

@GetMapping("/forall")	// /verum pol all of them can access
public String greet() {
	return "working..";
}
	
@GetMapping
@RequestMapping("/admin")  //here admin access it
public String greetAdmin() {
	return "Admin@work";
}

@GetMapping
@RequestMapping("/user")  //here useraccess it
public String greetuser() {
	return "User@work";
}


}
