package com.capgemini.backgroundverification.service;

import java.util.List;

import com.capgemini.backgroundverification.entity.FileModel;
import com.capgemini.backgroundverification.entity.Logindata;
import com.capgemini.backgroundverification.entity.Verification;

public interface EmployeeService {

	Logindata addUser(Logindata u);


	List<Logindata> getAllUsers();

	Logindata deleteUser(int userId);

	Logindata updateUser(Logindata u);
	
	Boolean loginUser(Logindata u);


	Verification addVer(Verification u);
}