package com.afm.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.afm.model.User;

import hibernateutil.HibernateUtil;

public class UserService {

	private SessionFactory sf = HibernateUtil.getSessionFactory();
	private User user = new User();
	private Session session;
	private List<User> uList = new ArrayList<User>();
	
	public User saveUser(String name, String lastName, int age) {
		user.setName(name);
		user.setLastName(lastName);
		user.setAge(age);

		session = sf.openSession();
		session.beginTransaction();

		session.save(user);

		session.getTransaction().commit();
		session.close();

		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserH() {
		
		session = sf.openSession();
		Query query = session.createQuery("from User");
		uList =  (List<User>) query.list();

		return uList;
	}

	@SuppressWarnings("unchecked")
	public List<User> getUserCri() {
		
		session = sf.openSession();
		session.beginTransaction();

		Criteria cri = session.createCriteria(User.class);
		uList = cri.list();

		session.getTransaction().commit();
		session.close();

		return uList;
	}

	public void userUpdate(int id, String name, String lastName, int age) {
		session = sf.openSession();
		session.beginTransaction();

		Query query = session.createQuery("update User set name=?,lastName=?,age=? " + "where id=?");
		query.setParameter(0, name);
		query.setParameter(1, lastName);
		query.setParameter(2, age);
		query.setParameter(3, id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	public void userDeleteH(int id) {
		session = sf.openSession();
		session.beginTransaction();

		Query query = session.createQuery("delete User where id=?");
		query.setParameter(0, id);
		query.executeUpdate();

		session.getTransaction().commit();
		session.close();
	}

	public void userDeleteCri(int id) {

		session = sf.openSession();
		session.beginTransaction();

		Criteria cri = session.createCriteria(User.class)
				.add(Restrictions.eq("id", id))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		user = (User) cri.uniqueResult();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
	}

}
