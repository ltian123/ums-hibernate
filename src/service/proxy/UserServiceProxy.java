package service.proxy;

import service.UserService;
import service.impl.UserServiceImpl;
import transaction.TransactionManager;
import entity.User;
import exception.DataAccessException;
import exception.DuplicateUsernameException;
import exception.ServiceException;
import exception.UserNotFoundException;
import exception.UserStatusException;
import factory.ObjectFactory;

public class UserServiceProxy implements UserService {

	private UserService userService;
	
	public UserServiceProxy() {
		userService=(UserService) ObjectFactory.getObject("userServiceTarget");
	}
	
	public void regist(User user) throws DuplicateUsernameException {
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			userService.regist(user);
			
			transactionManager.commit();
		} catch (DuplicateUsernameException e) {
			transactionManager.rollback();
			throw e;
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
	}

	public User login(String username, String password)
			throws UserNotFoundException, UserStatusException {
		User user=null;
		TransactionManager transactionManager=(TransactionManager) ObjectFactory.getObject("transaction");
		try {
			transactionManager.beginTransaction();
			
			user=userService.login(username, password);
			
			transactionManager.commit();
		} catch (UserNotFoundException e) {
			transactionManager.rollback();
			throw e;
		} catch (UserStatusException e) {
			transactionManager.rollback();
			throw e;
		} catch (DataAccessException e) {
			transactionManager.rollback();
			throw new ServiceException(e);
		}
		return user;
	}

}
