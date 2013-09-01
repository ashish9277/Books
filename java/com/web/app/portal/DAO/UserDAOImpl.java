package com.web.app.portal.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.portal.POJO.Users;

public class UserDAOImpl implements UserDAO {


	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		
		try{
			Session session = sessionfactory.openSession();
			session.save(user);
			session.flush();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public int getId(String name) {
		// TODO Auto-generated method stub
		try{
			Session session=sessionfactory.openSession();
			Query qu=session.createQuery("select * from Users where u_name=?");
			qu=qu.setString(1, name);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Users authenticate(String username, String Password) {
		// TODO Auto-generated method stub
		try{
			Session ses=sessionfactory.openSession();
			String hql="select u from Users u where u.u_name = :u_name AND u.u_password = :u_password";
			Query query=ses.createQuery(hql);
			query.setParameter("u_name", username);
			query.setParameter("u_password", Password);
			List<Users> list=query.list();
			if(list !=null)
			{
				return list.get(0);
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
