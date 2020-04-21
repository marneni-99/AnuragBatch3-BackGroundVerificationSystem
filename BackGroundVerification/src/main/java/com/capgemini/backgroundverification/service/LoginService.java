package com.capgemini.backgroundverification.service;

import java.util.List;

import com.capgemini.backgroundverification.entity.Logindata;

public interface LoginService {

	Logindata addUser(Logindata u);


	List<Logindata> getAllUsers();

	Logindata deleteUser(int userId);

	Logindata updateUser(Logindata u);
	
	Boolean loginUser(Logindata u);

}