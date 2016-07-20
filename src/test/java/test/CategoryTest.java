package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.CategoryDAO;
import model.Category;


public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.refresh();
	CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	Category category= (Category) context.getBean("category");
	category.setId("CG189");
	category.setDescription("Television");
	category.setName("LG");
	categoryDAO.saveorupdate(category);
}
}
