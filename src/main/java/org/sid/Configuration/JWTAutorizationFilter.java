package org.sid.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.oauth2.resource.JwtAccessTokenConverterConfigurer;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Chain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAutorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse responce, FilterChain filterChain)
			throws ServletException, IOException {
		
		responce.addHeader("Access-Control-Allow-Origin", "*");
		responce.addHeader("Access-Control-Allow-Headers", 
				"Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, authorization");
		
		responce.addHeader("Access-Control-Expose-Headers","Access-Control-Allow-Origin,Access-Control-Allow-Crendentials,authorization");
		String jwt = request.getHeader(SecurityConstants.HEADER_STRING);
		System.out.println(jwt);
		
		if(request.getMethod().equals("OPTIONS")){
			responce.setStatus(HttpServletResponse.SC_OK);
		}
		else {
			if (jwt == null || !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)) {
				filterChain.doFilter(request, responce);
				return;
			}
			
			Claims claims = Jwts.parser()
								.setSigningKey(SecurityConstants.SECRET)
								.parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
								.getBody();
			String username = claims.getSubject();
			
			ArrayList<Map<String, String>> roles =(ArrayList<Map<String,String>>)
					claims.get("roles");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(r->{
				authorities.add(new SimpleGrantedAuthority(r.get("authority")));
			});
			
			UsernamePasswordAuthenticationToken authenticatedUser = 
					new UsernamePasswordAuthenticationToken(username, null, authorities);
			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
			filterChain.doFilter(request, responce);
			
		}
		
	}

}
