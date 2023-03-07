package com.mms.rami.serviceimpl;

import java.net.UnknownHostException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Service;

import com.mms.rami.domain.AD;
import com.mms.rami.domain.User;
import com.mms.rami.service.ADLdapService;
import com.mms.rami.service.ActiveDirectory;


@Service
public class ADLdapServiceImpl implements ADLdapService{

	
	@Override
	public AD domaine() throws UnknownHostException{
		
		
		  
		  AD domaine = new AD();
		  
		   String fqdn = java.net.InetAddress.getLocalHost().getCanonicalHostName();
           if (fqdn.split("\\.").length>1) domaine.setDomaineName(fqdn.substring(fqdn.indexOf(".")+1));
                           
        
      
          return domaine;

		  
	
	}

	@Override
	public List<User> users() throws NamingException {
	
		return ActiveDirectory.getUsers(ActiveDirectory.ldapContext);
	}


	
	
	
}
