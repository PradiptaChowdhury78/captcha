/**
 * 
 */
package com.ibm.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.demo.entity.UserLogin;
import com.ibm.demo.spring.dao.UserDAO;
import com.ibm.demo.spring.dao.UserDAOImpl;



@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private UserDAOImpl userDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		modelMap.put("account", new UserLogin());

		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String save(@ModelAttribute("account") UserLogin account, HttpSession session, HttpServletRequest request,
			ModelMap modelMap) {
		String captcha = session.getAttribute("captcha_security").toString();
		String verifyCaptcha = request.getParameter("captcha");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if (captcha.equals(verifyCaptcha)) {

			System.out.println(" *****name******** " + username);
			UserLogin userLogin = new UserLogin();
			userLogin.setEmail(email);
	
			userLogin.setName(name);
			userLogin.setPassword(username);
			userLogin.setUsername(password);
			System.out.println(" ************* " + userLogin.getUsername());
		userDAO.addUser(userLogin);
			
			modelMap.put("account", account);
			return "success";
		} else {
			modelMap.put("error", "Captcha Invalid");
			return "index";
		}
	}

//	@RequestMapping(value = "register", method = RequestMethod.POST, produces = MediaType.ALL_VALUE )
//	public String register(@RequestBody UserLogin userLogin, HttpSession session,
//			HttpServletRequest request, ModelMap modelMap) {
//		
//		System.out.println(" ************* start" );
//		String captcha = session.getAttribute("captcha_security").toString();
//		String verifyCaptcha = request.getParameter("captcha");
//		String username = request.getParameter("usename");
//		String password = request.getParameter("password");
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//
//		//UserLogin userLogin = new UserLogin();
//		userLogin.setEmail(email);
//
//		userLogin.setName(name);
//		userLogin.setPassword(password);
//		userLogin.setUsername(username);
//		System.out.println(" ************* " + userLogin.getUsername());
//		userDAO.addUser(userLogin);
//
//		if (captcha.equals(verifyCaptcha)) {
//			modelMap.put("account", userLogin);
//			return "index";
//		} else {
//			modelMap.put("error", "Captcha Invalid");
//			return "register";
//		}
//	}

}
