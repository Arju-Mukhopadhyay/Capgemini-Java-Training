package com.capgemini.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.training.dao.LoginRepository;
import com.capgemini.training.entity.UserEntity;

@Service
public class LoginServices {
	
	@Autowired
	LoginRepository loginRepository;
	
	public UserEntity registerUser(UserEntity userEntity) {
		return loginRepository.save(userEntity);
	}
	
	public boolean validateUser(String user, String password) {
		UserEntity user1 = loginRepository.findByUserAndPassword(user,password);
		if(user1!=null) {
			return true;
		}
		return false;
	}
	//Forgot Password Logic
	public boolean updatePassword(String user, String password) {

	    UserEntity userEntity = loginRepository.findByUser(user);

	    if(userEntity != null) {
	        userEntity.setPassword(password);
	        loginRepository.save(userEntity);
	        return true;
	    }

	    return false;
	}
}