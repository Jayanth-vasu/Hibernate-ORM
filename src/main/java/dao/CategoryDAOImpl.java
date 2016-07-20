package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Category;

@Repository("categoryDAO")
public  class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory =sessionFactory;
	
	}
	@Transactional
	public void saveorupdate(Category category){
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}
@Transactional
public void delete(String id){
	Category cattodel=new Category();
    cattodel.setId(id);
    sessionFactory.getCurrentSession().delete(cattodel);
}


@Transactional
public Category get(String id){
	String hql ="from Category where id ="+"'"+id+"'";
	Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings("unchecked")
	List<Category> listcategory=(List<Category>)query.getResultList();
	if(listcategory!=null && listcategory.isEmpty()){
		return listcategory.get(0);
	}
	return null;
	}
@Transactional
public List<Category> list(){
	
	@SuppressWarnings("unchecked")
	List<Category> listcategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return listcategory;
	}


	
}






