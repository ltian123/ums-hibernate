package transaction.impl;

import org.hibernate.Session;

import exception.DataAccessException;

import transaction.TransactionManager;
import util.HibernateUtil;

public class TransactionManagerImpl implements TransactionManager {

	public void beginTransaction() {
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.beginTransaction();
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void commit() {
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new DataAccessException("数据访问失败",e);
		}
	}

	public void rollback() {
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			session.getTransaction().rollback();
		} catch (Exception e) {
			//记录日志，通知管理员，人为解决
		}		
	}

}
