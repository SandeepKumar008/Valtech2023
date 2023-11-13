package com.valtech.training.firstspringboot.service;
 
import com.valtech.training.firstspringboot.entities.User;

import com.valtech.training.firstspringboot.model.ChangePasswordModel;

import com.valtech.training.firstspringboot.model.RegisterUserModel;
 
public interface AuthService {
 
	User createUser(RegisterUserModel regUserModel);
 
	boolean changePassword(ChangePasswordModel passwordModel);
 
	void upgradeUserToAdmin(long id);
 
	void enableUser(long id);
 
	void disableUser(long id);
 
}