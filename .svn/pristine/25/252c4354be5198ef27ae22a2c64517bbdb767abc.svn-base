package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import exception.DataAccessException;

public class HibernateTemplate {
	public void save(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			session.save(entity);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public void delete(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			session.delete(entity);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public void update(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			session.update(entity);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public void saveOrUpdate(Object entity){
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			session.saveOrUpdate(entity);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}
	
	public Object get(Class entityClass,Serializable id){
		Object entity=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			entity=session.get(entityClass, id);
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
		return entity;
	}
	
	
	public List loadAll(Class entityClass){
		List list=new ArrayList();
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			list=session.createCriteria(entityClass)
						.list();
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
		return list;
	}
	
	
	
	public List find(String hql,Object[] params){
		List list=new ArrayList();
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			Query query=session.createQuery(hql);
			
			for (int i = 0; i < params.length; i++) {
				setParam(i,params[i],query);
			}
			
			list=query.list();
			
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
		return list;
	}
	
	
	public List findByNamedParam(String hql,String[] paramNames,Object[] params){
		List list=new ArrayList();
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			
			Query query=session.createQuery(hql);
			
			for (int i = 0; i < params.length; i++) {
				setParam(paramNames[i],params[i],query);
			}
			
			list=query.list();
			
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
		return list;
	}
	
	

	private void setParam(int index, Object param, Query query) {
		if(param instanceof String){
			query.setString(index, (String)param);
		}else if(param instanceof Integer){
			query.setInteger(index, (Integer)param);
		}else if(param instanceof Double){
			query.setDouble(index, (Double)param);
		}else if(param instanceof Date){
			query.setDate(index, (Date)param);
		}else {
			query.setParameter(index, param);
		}
	}
	
	
	
	
	private void setParam(String paramName, Object param, Query query) {
		if(param instanceof String){
			query.setString(paramName, (String)param);
		}else if(param instanceof Integer){
			query.setInteger(paramName, (Integer)param);
		}else if(param instanceof Double){
			query.setDouble(paramName, (Double)param);
		}else if(param instanceof Date){
			query.setDate(paramName, (Date)param);
		}else {
			query.setParameter(paramName, param);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
