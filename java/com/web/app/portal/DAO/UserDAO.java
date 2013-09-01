package com.web.app.portal.DAO;

import com.web.app.portal.POJO.Users;

public interface UserDAO {

	public boolean addUser(Users user);
	public int getId(String name);
	public Users authenticate(String username,String Password);
}
