package com.examportal.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.entity.Admin;
import com.examportal.iservice.AdminServices;
import com.examportal.repository.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminServices {

	AdminRepository adminRepository;
	public AdminServiceImplementation() {
	}
 
 
	@Autowired
	public AdminServiceImplementation(AdminRepository adminRepository) {
		this.adminRepository=adminRepository;
	}

	public Admin login(String adminMail,String adminPassword){
		Admin existingAdmin=adminRepository.findByAdminMail(adminMail);
		System.out.println(existingAdmin.getAdminMail() +" " + existingAdmin.getAdminPassword());
		if(existingAdmin.getAdminMail().equals(adminMail) && !(existingAdmin.getAdminMail().equals(null))) {
			if(existingAdmin.getAdminPassword().equals(adminPassword)) {
				System.out.println("login successful");
				return existingAdmin;
			}
			else {
				System.out.println("check password");
			}
		}
		else {
			System.out.println("you are  unauthorized admin");
		}
		return null;
 
	}


	public org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin admin(String adminMail,
			String adminPassword) {
		// TODO Auto-generated method stub
		return null;
	}


	
}