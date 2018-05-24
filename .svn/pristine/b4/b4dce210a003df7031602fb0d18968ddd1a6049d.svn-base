package dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import util.HibernateTemplate;
import util.HibernateUtil;

import dao.GenericDao;

public abstract class GenericDaoImpl<E extends Serializable,PK extends Serializable> implements GenericDao<E, PK> {
	
	protected HibernateTemplate hibernateTemplate;
	protected Class<E> entityClass;
	
	public GenericDaoImpl() {
		hibernateTemplate=new HibernateTemplate();
		entityClass=(Class<E>) ((ParameterizedType)(this.getClass()
										                .getGenericSuperclass()))
										           .getActualTypeArguments()[0];
	}

	public void insert(E e) {
		hibernateTemplate.save(e);
	}

	public void deleteById(PK id) {
		hibernateTemplate.delete(hibernateTemplate.get(entityClass, id));
	}

	public void delete(E e) {
		hibernateTemplate.delete(e);
	}

	public void update(E e) {
		hibernateTemplate.update(e);
	}

	public E selectById(PK id) {
		return (E) hibernateTemplate.get(entityClass, id);
	}

	public List<E> selectAll() {
		return hibernateTemplate.loadAll(entityClass);
	}

	
	
}
