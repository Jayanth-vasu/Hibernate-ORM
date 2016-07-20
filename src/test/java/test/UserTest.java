package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.UserDAO;
import model.User;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user= (User) context.getBean("user");
		user.setId("");
		user.setAddress("");
		user.setName("");
		user.setMailid("");
		user.setMobile(0);
		user.setPassword("");
		
		userDAO.saveorupdate(user);
	}
}
