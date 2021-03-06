package com.cts.ddd.infrastructure.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.ddd.domain.user.User;
import com.cts.ddd.infrastructure.UserRepository;
import com.cts.ddd.security.jwt.security.UserPrinciple;



public class JpaUserRepositoryImpl implements UserRepository{

	@Autowired
	private  JpaUserRepository jpaUserRepository;
   
	@Override
	public User findUserId(String userId) {
		Optional<User> userDetails = jpaUserRepository.findById(userId);
		return userDetails.isPresent() ? userDetails.get() : null;
	}

	@Override
	public User addUser(User user) {
		return jpaUserRepository.save(user);
	}

	@Override
	public void deleteUser(String userId) {
		jpaUserRepository.deleteById(userId);
	}

	@Override
	public Iterable<User> getAllUser() {
		return jpaUserRepository.findAll();
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("------------------------------>");
		Optional<User> userDetails = jpaUserRepository.findById(username);
		User user=null;
		
		
		 if(!userDetails.isPresent() ) {
			new UsernameNotFoundException("User Not Found with -> username or email : " + username);
		 }else {
			 user = userDetails.orElseThrow(
						() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));
		 }
		 
		System.out.println("------------------------------>"+user);
		System.out.println("------------------------------>"+UserPrinciple.build(user));
		return UserPrinciple.build(user);
	}

}
