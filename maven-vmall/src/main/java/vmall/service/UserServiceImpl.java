package vmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vmall.dao.UserDao;
import vmall.po.User;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User login(String username) {
		return userDao.login(username);
	}
	
	@Override
	public int regist(User user) {
		int n=userDao.regist(user);
		System.out.println(n);
		return n;
	}

}
