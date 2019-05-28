package com.kgate.service;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;
import com.kgate.entity.UserInfo;
import com.kgate.exception.ResourceNotFoundExceptionTest;

public interface UserService {

	UserInfo saveUserInfo(UserInfo userInfo);

	UserInfo getUserInfoDetails(Long mobile) throws ResourceNotFoundExceptionTest;

	User saveUser(User user);

	UserGame addUserGame(UserGame userGame) throws Exception;

	User getUserDetails(Long mobile) throws ResourceNotFoundExceptionTest;
}
