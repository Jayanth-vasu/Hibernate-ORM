package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	public List<Product> list();
	public Product get(String id);
	public void saveorupdate(Product product);
	public void delete(String id);
}
