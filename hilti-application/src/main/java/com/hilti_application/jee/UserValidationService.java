package com.hilti_application.jee;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	public boolean isUserValid(String user, String password) {
		if(user.equals("Humphrey") && password.equals("153631")) return true;
		return false;
	}
}
