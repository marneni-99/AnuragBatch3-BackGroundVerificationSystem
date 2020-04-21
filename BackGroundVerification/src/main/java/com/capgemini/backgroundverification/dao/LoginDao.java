package com.capgemini.backgroundverification.dao;
import java.util.List;

import com.capgemini.backgroundverification.entity.Logindata;

public interface LoginDao {

	Logindata addUser(Logindata u);


	List<Logindata> getAllUsers();

	Logindata deleteUser(int userId);

	Logindata updateUser(Logindata u);

	Boolean loginUser(Logindata u);
}