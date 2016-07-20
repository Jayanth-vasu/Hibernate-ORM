package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;


	@Repository("userDAO")
	public  class UserDAOImpl implements UserDAO{
		@Autowired
		private SessionFactory sessionFactory;
		public UserDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory =sessionFactory;
		
		}
		@Transactional
		public void saveorupdate(User user){
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
		}
	@Transactional
	public void delete(String id){
		User usertodelete=new User();
	    usertodelete.setId(id);
	    sessionFactory.getCurrentSession().delete(usertodelete);
	}


	@Transactional
	public User get(String id){
		String hql ="from User where id ="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> listuser=(List<User>)query.getResultList();
		if(listuser!=null && listuser.isEmpty()){
			return listuser.get(0);
		}
		return null;
		}
	@Transactional
	public List<User> list(){
		
		@SuppressWarnings("unchecked")
		List<User> listuser = (List<User>) sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuser;
		}
}

