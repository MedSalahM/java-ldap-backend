package com.mms.rami.service;

import java.util.Map;

import javax.naming.NamingException;

import com.mms.rami.domain.ResponseLogin;

public interface AuthService {

	
	
	ResponseLogin getToken(String username , String password) throws NamingException;
}
