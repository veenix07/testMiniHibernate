package com.vee.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class BaseDAOImpl<E, PK extends Serializable> implements IDAO<E,PK> {

	private static SessionFactory factory;
	protected Class<E> type;
	
	public BaseDAOImpl(Class<E> type) {
		this.type = type;
	}

	public static SessionFactory getSessionFactory(){
		if(factory == null){
			try{
		         factory = new Configuration().configure().buildSessionFactory();
		      }catch (Throwable ex) { 
		         System.err.println("Failed to create sessionFactory object." + ex);
		         throw new ExceptionInInitializerError(ex); 
		      }
		}
		return factory;
	}

	protected abstract void printData(E e);
	
	@Override
	public List<E> list() {
		return castList(type, getSessionFactory().openSession().createQuery("FROM "+type.getName() ).getResultList());
	}
	
	@Override
	public void create(E e) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
	}
	
	@Override
	public void update(E e) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.merge(e);
		tx.commit();
	}
	
	@Override
	public void delete(E e) {
		Session session = getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
	}
	
	@Override
	public E find(PK id) {
		return getSessionFactory().openSession().get(type, id);
	}

	protected List<E> castList(Class<? extends E> clazz, Collection<?> c){
		List<E> lists = new ArrayList<E>();
		for(Object o : c)
			lists.add(clazz.cast(o));
		return lists;
	}
	
}
