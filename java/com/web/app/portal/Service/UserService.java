package com.web.app.portal.Service;

import com.web.app.portal.POJO.Users;

public interface UserService {

	public boolean addUser(Users user);
	public Users authenticate(String uname,String pwd);
}
