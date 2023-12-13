package com.examportal.iservice;

import com.examportal.entity.Admin;


public interface AdminServices {
	 Admin login(String adminMail,String adminpassword);
}
