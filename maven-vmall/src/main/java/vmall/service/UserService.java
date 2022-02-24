package vmall.service;

import org.springframework.stereotype.Service;

import vmall.po.User;

@Service
public interface UserService {
	public User login(String username);

	public int regist(User user);
}
