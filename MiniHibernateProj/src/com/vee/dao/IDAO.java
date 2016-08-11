package com.vee.dao;

import java.io.Serializable;
import java.util.List;

public interface IDAO<E,PK extends Serializable> {

	public List<E> list();
	public void create(E e);
	public void delete(E e);
	public void update(E e);
	public E find(PK id);
	
}
