package com.capgemini.backgroundverification.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.backgroundverification.entity.Logindata;
import com.capgemini.backgroundverification.dao.LoginDaoImpl;

@Service
@Transactional
public class LoginServiceImpl implements LoginService 
{
@Autowired
LoginDaoImpl dao;

@Override
public Logindata addUser(Logindata u) {
	return dao.addUser(u);
}

@Override
public List<Logindata> getAllUsers() 
{
return dao.getAllUsers();
}


@Override
public Logindata deleteUser(int userId) 
{
	return dao.deleteUser(userId);
}

@Override
public Logindata updateUser(Logindata u) {
	return dao.updateUser(u);	
}

@Override
public Boolean loginUser(Logindata u)
{
	return dao.loginUser(u);
}
}