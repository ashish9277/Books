package com.web.app.portal.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.portal.POJO.Books;

public class BookDAOImpl implements BookDAO {


	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public boolean addEntry(Books book) {
		// TODO Auto-generated method stub
		try{
			Session ses= sessionfactory.openSession();
			ses.save(book);
			ses.flush();
			ses.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
