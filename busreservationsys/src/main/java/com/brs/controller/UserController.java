package com.brs.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.brs.entity.User;
import com.brs.exceptions.UserNotFoundException;
import com.brs.service.IUserService;


@RestController
public class UserController {
	@Autowired
	private IUserService userservice;
	@PostMapping("addUser")
	public ResponseEntity<User> addUser(@Valid@RequestBody User user){
	     return new ResponseEntity<User>(userservice.addUser(user),HttpStatus.OK);
	}	
	
	@PutMapping("updateUser")
	public ResponseEntity<User> updateuser(@Valid@RequestBody User user) throws UserNotFoundException {
		return new ResponseEntity<User>(userservice.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteUser/{Userid}")
	public ResponseEntity<User> deleteUser(@PathVariable("Userid") int busId) throws UserNotFoundException{
		return new ResponseEntity<User>(userservice.deleteUser(busId),HttpStatus.OK);
		
	}
	
	@GetMapping("view/{Userid}")
	public ResponseEntity<User> getUserById(@PathVariable("Userid") int userLoginId) throws UserNotFoundException{
		return new ResponseEntity<User>(userservice.viewUser(userLoginId) , HttpStatus.OK);
	}
	
	@GetMapping("alluser")
	public ResponseEntity <List<User>>getAllUser(){
		return new ResponseEntity<List<User>>(userservice.viewAllUser(), HttpStatus.OK);
	}
}