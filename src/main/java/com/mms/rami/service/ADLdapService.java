package com.mms.rami.service;

import java.net.UnknownHostException;
import java.util.List;

import javax.naming.NamingException;

import com.mms.rami.domain.AD;
import com.mms.rami.domain.User;

public interface ADLdapService {
	

	AD domaine() throws UnknownHostException;
	 
	List<User> users() throws NamingException;
	
	
	
}
