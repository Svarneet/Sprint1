package com.brs.controller;

import java.util.logging.Logger;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Admin;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.service.IAdminService;

@RestController
@RequestMapping(path="/admin")
public class AdminController {
	Logger log=Logger.getLogger("AdminController");
	@Autowired
	private IAdminService adminservice;
	@PostMapping("addAdmin")
	public ResponseEntity<Admin> addAdmin(@Valid@RequestBody Admin admin){
		 log.info("Admin added");
	     return new ResponseEntity<Admin>(adminservice.addAdmin(admin) ,HttpStatus.OK);
	}	
	
	@PutMapping("updateAdmin")
	public ResponseEntity<Admin> updatebus(@Valid@RequestBody Admin admin) {
		log.info("bus updated");
		return new ResponseEntity<Admin>(adminservice.updateAdmin(admin), HttpStatus.OK);
	}
	
	@DeleteMapping("deleteadmin/{adminid}")
	public ResponseEntity<Admin> deleteAdmin(@PathVariable("buid") int adminId) throws AdminNotFoundException{
		log.info("bus deleted");
		return new ResponseEntity<Admin>(adminservice.deleteAdmin(adminId),HttpStatus.OK);
		
	}
	
	@GetMapping("view/{adminid}")
	public ResponseEntity<Admin> getAdminById(@PathVariable("Adminid") int adminId) throws AdminNotFoundException{
		log.info("bus for givem Id");
		return new ResponseEntity<Admin>(adminservice.viewAdmin(adminId), HttpStatus.OK);
	}

}
