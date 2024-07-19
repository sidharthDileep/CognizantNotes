package com.myApp.superApp.config;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	
	@Value("${jwt.expiration}")
	private int jwtExpirationInMs;
	
	public String generateToken(com.myApp.superApp.entity.User user) {
		Date now = new Date();
		Date expiry = new Date(now.getTime() + jwtExpirationInMs);
		
//		String roles = user.getRoles().stream()
//				.map(role -> role.getName().name()).collect(Collectors.joining(","));
		
		return Jwts.builder()
				.setSubject(user.getUsername())
				.setIssuedAt(new Date())
				.setExpiration(expiry)
				.signWith(SignatureAlgorithm.HS256, jwtSecret)
				.compact();
	}
	
	public String getUserIdFromJwt(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();
		
		return claims.getSubject();
	}
	
	public String getRolesFromJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody();
		
		return (String) claims.get("roles");
	}
	
	public boolean validateToken(String authToken){
		try {
			Jwts.parser().setSigningKey(jwtSecret).parsePlaintextJws(authToken);
			return true;
		} catch(Exception ex) {
			// new Exception(ex.getMessage());
		}
		return false;
	}

}
