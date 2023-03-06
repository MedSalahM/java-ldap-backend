package com.mms.rami.controller;

import java.net.UnknownHostException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mms.rami.domain.AD;
import com.mms.rami.domain.RequestLogin;
import com.mms.rami.domain.ResponseLogin;
import com.mms.rami.domain.User;
import com.mms.rami.service.ADLdapService;
import com.mms.rami.service.ActiveDirectory;
import com.mms.rami.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class AppController {
	
	
	private final ADLdapService adLdapService;
	private final AuthService authService;
	
	
	@GetMapping("domaine")
	public ResponseEntity<AD> connect() throws UnknownHostException {
		
		 System.out.println("inside controller");

		
		 var domaine =adLdapService.domaine();
		
		
		
		return ResponseEntity.ok(domaine);
		
		
	}
	
	@PostMapping("connect")
	public ResponseEntity<ResponseLogin> connect(@RequestBody RequestLogin login) throws NamingException{
		
		
		return ResponseEntity.ok(authService.getToken(login.getUsername(), login.getPassword()));

		
		
	}
	
	
	
	
	@GetMapping("users")
	public User [] users (@RequestParam String username , @RequestParam String password) throws NamingException {
		
		

		//var ldap = ActiveDirectory.getConnection(username, password);
		
		return null;
		
		
	}
	

	
	
	
	
	
	
	

}
