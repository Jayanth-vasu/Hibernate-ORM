package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.SupplierDAO;
import model.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.refresh();
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier= (Supplier) context.getBean("supplier");
		supplier.setId("SUP189");
		supplier.setAddress("No.111,Spencer plaza,Industrial estate,Noida-77");
		supplier.setName("JV Retail");
		supplierDAO.saveorupdate(supplier);
	}

}
