package com.cognizant.spring_learn.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.model.AuthenticationResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {
  
  @GetMapping("/authenticate")
  public AuthenticationResponse authenticate(HttpServletRequest request){
    String authHeader=request.getHeader("Authorization");
    String encodedCredentials=authHeader.substring(6);
    byte[] decodedBytes=Base64.getDecoder().decode(encodedCredentials);
    String credentials=new String(decodedBytes);
    String username=credentials.split(":")[0];
    String password=credentials.split(":")[1];

    System.out.println(username);
    System.out.println(password);

    String token="sample-jwt-token";

    return new AuthenticationResponse(token);
  }
}
