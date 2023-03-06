package com.mms.rami.domain;

import javax.naming.directory.Attributes;

public class User {
	
	
	
	 private String distinguishedName;
     private String userPrincipal;
     private String commonName;
     
     public User(Attributes attr) throws javax.naming.NamingException {
         userPrincipal = (String) attr.get("userPrincipalName").get();
         commonName = (String) attr.get("cn").get();
         distinguishedName = (String) attr.get("distinguishedName").get();

     }
     
     

}
