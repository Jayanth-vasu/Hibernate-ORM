package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.ProductDAO;
import model.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.refresh();
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		Product product= (Product) context.getBean("product");
		product.setId("");
		product.setDescription("");
		product.setName("");
		product.setPrice(0);
		
		productDAO.saveorupdate(product);
}
}