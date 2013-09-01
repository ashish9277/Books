package com.web.app.portal.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.portal.DAO.UserDAO;
import com.web.app.portal.POJO.Users;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return userDAO.addUser(user);
	}
	@Override
	public Users authenticate(String uname, String pwd) {
		// TODO Auto-generated method stub
		return userDAO.authenticate(uname, pwd);
	}

}
