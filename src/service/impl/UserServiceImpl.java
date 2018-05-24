package service.impl;

import java.util.Date;
import java.util.List;

import service.UserService;
import transaction.TransactionManager;
import util.MD5Util;
import constant.Constant;
import dao.UserDao;
import entity.User;
import exception.DuplicateUsernameException;
import exception.UserNotFoundException;
import exception.UserStatusException;
import factory.ObjectFactory;

public class UserServiceImpl implements UserService {

	
	public void regist(User user) throws DuplicateUsernameException {
		UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
		User u=userDao.selectByUsername(user.getUsername());
		if(u!=null){
			throw new DuplicateUsernameException("用户名已存在");
		}
		user.setStatus(Constant.USER_STATUS_ENABLE);
		user.setPassword(MD5Util.md5(user.getPassword()));
		user.setCreateDate(new Date());
		userDao.insert(user);
	}

	public User login(String username, String password)
			throws UserNotFoundException, UserStatusException {
		UserDao userDao=(UserDao) ObjectFactory.getObject("userDao");
		User user=userDao.selectByUsernameAndPassword(username, MD5Util.md5(password));
		if(user==null){
			throw new UserNotFoundException("用户名或密码错误");
		}
		if(Constant.USER_STATUS_DISABLE.equals(user.getStatus())){
			throw new UserStatusException("用户已被禁用");
		}
		return user;
	}

}
