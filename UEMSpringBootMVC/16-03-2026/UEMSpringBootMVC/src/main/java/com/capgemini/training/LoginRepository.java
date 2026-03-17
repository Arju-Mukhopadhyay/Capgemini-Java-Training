package com.capgemini.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity, Integer>{
	//Select * FROM user_info WHERE user=? AND password=?
	//Login
    UserEntity findByUserAndPassword(String user, String password);

    //UPDATE user_info SET password = ? WHERE user = ?
    //Forgot password
    UserEntity findByUser(String user);
}