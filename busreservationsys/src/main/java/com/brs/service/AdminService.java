package com.brs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Admin;
import com.brs.exceptions.AdminNotFoundException;
import com.brs.repository.IAdminRepository;


@Service
@Transactional
public class AdminService implements IAdminService{
	@Autowired
	IAdminRepository adminrepo;

	@Override
	public Admin addAdmin(Admin admin) {
		return adminrepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Admin updateAdmin=null;
		try {
				updateAdmin=adminrepo.findById((int) admin.getAdminId()).orElseThrow(AdminNotFoundException::new );
			
		}catch(AdminNotFoundException e){
			
			e.printStackTrace();
		}
		updateAdmin.setAdminId(admin.getAdminId());
		updateAdmin.setAdminUsername(admin.getAdminUsername());
		updateAdmin.setAdminPassword(admin.getAdminPassword());
		return adminrepo.save(updateAdmin);
	}
	@Override
	public Admin deleteAdmin(int adminId){
		Admin admin=null;
		try {
			admin=adminrepo.findById(adminId).orElseThrow(AdminNotFoundException::new);
			adminrepo.delete(admin);
		} catch (AdminNotFoundException e) {
			e.printStackTrace();
		}
		return admin;
	}
	@Override
	public Admin viewAdmin(int adminId) throws AdminNotFoundException{
		Admin a=null;
		try {
			a=adminrepo.findById(adminId).orElseThrow(AdminNotFoundException::new);
		}catch(AdminNotFoundException e){
			e.printStackTrace();
		}
		return a;
	} 
}