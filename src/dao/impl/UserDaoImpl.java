package dao.impl;

import java.util.List;

import dao.UserDao;
import entity.User;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {

	public User selectByUsername(String username) {
		String hql=new StringBuffer()
			.append("from User u ")
			.append("where u.username=? ")
			.toString();
		List<User> users=hibernateTemplate.find(hql, new Object[]{username});
		return users.size()==0?null:users.get(0);
	}

	public User selectByUsernameAndPassword(String username, String password) {
		String hql=new StringBuffer()
			.append("from User u ")
			.append("where u.username=:username ")
			.append("and u.password=:password ")
			.toString();
		List<User> users=hibernateTemplate.findByNamedParam(hql, new String[]{"username","password"}, new Object[]{username,password});
		return users.size()==0?null:users.get(0);
	}

}
