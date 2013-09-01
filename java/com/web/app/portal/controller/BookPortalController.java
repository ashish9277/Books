package com.web.app.portal.controller;

import java.util.Locale;
import java.util.SortedMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.app.portal.POJO.Books;
import com.web.app.portal.POJO.Users;
import com.web.app.portal.Service.BookService;
import com.web.app.portal.Service.UserService;
import com.web.app.utils.FileUpload;

@Controller
public class BookPortalController {

	Logger logger =LoggerFactory.getLogger(BookPortalController.class);
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/uploadBook", method = RequestMethod.POST)
	public String uploadBook(Locale locale, Model model, HttpServletRequest hsr) {
		logger.info("Add book.", locale);
		String name=hsr.getParameter("name");
		String paasword=hsr.getParameter("password");
		model.addAttribute("name",hsr.getParameter("name"));
		
		Users ur=userService.authenticate(name, paasword);
		
		if(ur==null)
		{
			return "error";
		}
		else
		{
		HttpSession ses=hsr.getSession();
		ses.setAttribute("user", ur);
		
		}
		
		
		return "upload-book";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(Locale locale, Model model, HttpServletRequest hsr) {
		logger.info("Add book.", locale);
		try{
		HttpSession ses=hsr.getSession();
		Users usr=(Users) ses.getAttribute("user");
		logger.info("yyyyyyyyyyyyyyyiiiiiiiiiiiiiiii         "+usr.getU_id(), locale);	
		
		SortedMap<String, String> map=FileUpload.getFile(hsr);
		logger.info("-------------------------------------"+map.get("filePath"),locale);
		
		Books book=new Books();
		book.setB_name(map.get("bname"));
		book.setB_author(map.get("bauthor"));
		book.setB_description(map.get("description"));
		book.setB_edition(map.get("bedition"));
		book.setB_owner(usr.getU_id());
		book.setPreviewLoc(map.get("filePath"));
		logger.info(map.get("filePath"));
		bookService.addEntry(book);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//
		//http://balusc.blogspot.in/2009/12/uploading-files-in-servlet-30.html
		return "home";
	}

}
