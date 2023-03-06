package com.mms.rami.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mms.rami.domain.ResponseLogin;
import com.mms.rami.service.ActiveDirectory;
import com.mms.rami.service.AuthService;

@Service

public class AuthServiceImpl implements AuthService{

	
	@Override
	public ResponseLogin getToken(String username, String password) throws NamingException {

		
		ActiveDirectory.getConnection(username, password);
		
		
		  Algorithm algorithm =Algorithm.HMAC256("toyota".getBytes());
		     
			String access_token = JWT.create()
		    		                  .withSubject(username)
		    		                  .withExpiresAt(new Date(System.currentTimeMillis()+720*60*1000))
		    		                  .withIssuer(username)
		    		                  .withArrayClaim("roles", new String[]{"admin"})
		    		                  
		    		                  .sign(algorithm);
			
			
		return ResponseLogin.builder().token(access_token).build();
		
	}
}
