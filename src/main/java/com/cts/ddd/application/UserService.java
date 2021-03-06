package com.cts.ddd.application;

import com.cts.ddd.domain.user.User;

public interface UserService {

    User  findUserId(String userId);
	
	User addUser(User user);
	
	void deleteUser(String userId);
	
	Iterable<User> getAllUser();
	
	
}
