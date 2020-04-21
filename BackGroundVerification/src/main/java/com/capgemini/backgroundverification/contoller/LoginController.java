package com.capgemini.backgroundverification.contoller;

import java.util.List;

import com.capgemini.backgroundverification.exception.IdNotFoundException;
import com.capgemini.backgroundverification.exception.UserNotFoundException;
import com.capgemini.backgroundverification.service.LoginService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.backgroundverification.entity.Logindata;

@RestController
@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")
public class LoginController {
	@Autowired
	LoginService serviceobj;

	// Add user
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody Logindata u) {
		Logindata e = serviceobj.addUser(u);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	
	// Get all users
	@GetMapping("/GetAllUsers")
	private ResponseEntity<List<Logindata>> getAllUsers() {
		List<Logindata> userlist = serviceobj.getAllUsers();
		return new ResponseEntity<List<Logindata>>(userlist, new HttpHeaders(), HttpStatus.OK);

	}

	//Update User
	@PutMapping("/UpdateUser")
	public ResponseEntity<String> updateUser(@RequestBody Logindata u) {
		Logindata e = serviceobj.updateUser(u);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	
	// Delete User
	@DeleteMapping("/DeleteUser/{userId}")
	private ResponseEntity<String> deleteUser(@PathVariable("userId") int userId) {
		Logindata e = serviceobj.deleteUser(userId);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("User deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	

	@PutMapping("/Loginuser")
	public ResponseEntity<String> loginUser(@RequestBody Logindata u)
	{
		
		 boolean flag=serviceobj.loginUser(u);
		if(flag==false)
		{
			throw new UserNotFoundException("User not found");
		}else {
			return new ResponseEntity<String>("Login successful", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}

