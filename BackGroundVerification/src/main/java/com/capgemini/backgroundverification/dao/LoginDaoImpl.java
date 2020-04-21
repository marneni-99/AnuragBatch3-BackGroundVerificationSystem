package com.capgemini.backgroundverification.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.backgroundverification.entity.Logindata;
@Repository
public class LoginDaoImpl implements LoginDao {

	@PersistenceContext	
	 EntityManager em;
	
	@Override
	public Logindata addUser(Logindata u) {
		// TODO Auto-generated method stub
		Logindata e=em.merge(u);
		return e;
	}
	
	
	@Override
	public List<Logindata> getAllUsers() {
		Query q=em.createQuery("select m from Logindata m");
		List<Logindata> userlist=q.getResultList();
		return userlist;
	}
	
	@Override
	public Logindata updateUser(Logindata u) {
		Logindata ud=em.find(Logindata.class,u.getUserId());
		if(ud!=null)
		{

			ud.setUserName(u.getUserName());
			ud.setUserType(u.getUserType());
			ud.setUserPassword(u.getUserPassword());
			ud.setUserPhoneno(u.getUserPhoneno());
			ud.setUserEmail(u.getUserEmail());
		}
		return ud;
			
	}
	@Override	
	public Logindata deleteUser(int userId) {
		Logindata ud=em.find(Logindata.class,userId);
		if(ud!=null)
			{em.remove(ud);
			}
        return ud;
	}
	
	@Override
	public Boolean loginUser(Logindata u) {
	Query q=em.createQuery("select m from Logindata m where m.userName=?1 and m.userPassword=?2");
	String a=u.getUserName();
	String b=u.getUserPassword();
	q.setParameter(1, a);
	q.setParameter(2,b);
	try
	{
		Logindata m=(Logindata) q.getSingleResult();
		return true;
	}catch(javax.persistence.NoResultException e)
    {
        e.printStackTrace();
    }
	return false;
	}
}

