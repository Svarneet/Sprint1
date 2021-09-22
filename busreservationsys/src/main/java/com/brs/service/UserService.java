package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.exceptions.UserNotFoundException;
import com.brs.entity.User;
import com.brs.repository.IUserRepository;
@Service
@Transactional

public  class UserService implements IUserService{
@Autowired
	private IUserRepository userrepo;
	@Override
	public User addUser(User user) {
		User adbus=userrepo.save(user);
		return adbus;
	}
	@Override
	public User updateUser(User user) {
		User updateUser=null;
		try {
				updateUser=userrepo.findById(user.getUserLoginId()).orElseThrow(UserNotFoundException::new);
			
		}catch(UserNotFoundException e){
			e.printStackTrace();
		}
		updateUser.setUserLoginId(user.getUserLoginId());
		updateUser.setUserName(user.getUserName());
		updateUser.setPassword(user.getPassword());
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setContact(user.getContact());
		updateUser.setEmail(user.getEmail());
		
		User b=userrepo.save(updateUser);
		return b;
	}
	@Override
	public User deleteUser(int userId)  {
		User user=null;
		try {
			user=userrepo.findById( userId).orElseThrow(UserNotFoundException::new);
			userrepo.delete(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User viewUser(int userId) throws UserNotFoundException{
		User b=null;
		try {
			b=userrepo.findById(userId).orElseThrow(UserNotFoundException::new);
		}catch(UserNotFoundException e){
			e.printStackTrace();
		}
		return b;
	}
	
	@Override
	public List<User> viewAllUser() {
		
		return userrepo.findAll();
	}
	
	
}
