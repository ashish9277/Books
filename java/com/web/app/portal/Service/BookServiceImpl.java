package com.web.app.portal.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.app.portal.DAO.BookDAO;
import com.web.app.portal.POJO.Books;

public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	@Override
	public boolean addEntry(Books book) {
		// TODO Auto-generated method stub
		return bookDAO.addEntry(book);
	}

}
