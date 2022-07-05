package com.hkb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hkb.service.CustomUserDetailService;

@Configuration
public class SecurityConfig{
	
	@Autowired
	GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
//
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//			.antMatchers("/", "/shop/**", "/register", "/login").permitAll()
//			.antMatchers("/admin/**").hasRole("ADMIN")
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login")
//			.permitAll()
//			.failureUrl("/login?error= true")
//			.defaultSuccessUrl("/")
//			.usernameParameter("email")
//			.passwordParameter("password")
//			.and()
//			.oauth2Login()
//			.loginPage("/login")
//			.successHandler(googleOAuth2SuccessHandler)
//			.and()
//			.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/login")
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID")
//			.and()
//			.exceptionHandling()
//			.and()
//			.csrf()
//			.disable();
//		
//		http.headers().frameOptions().disable();
//	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/", "/shop/**", "/register", "/login").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.failureUrl("/login?error= true")
			.defaultSuccessUrl("/")
			.usernameParameter("email")
			.passwordParameter("password")
			.permitAll();
		
		http.oauth2Login()
			.loginPage("/login")
			.permitAll()
			.failureUrl("/login?error= true")
			.defaultSuccessUrl("/")
			.permitAll();
		
		http.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login")
			.deleteCookies("JSESSIONID")
			.and()
			.exceptionHandling()
			.and()
			.csrf()
			.disable();
		
		http.headers().frameOptions().disable();
//			.and()
//			.oauth2Login()
//			.loginPage("/login")
//			.successHandler(googleOAuth2SuccessHandler)
//			.and()
//			.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/login")
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID")
//			.and()
//			.exceptionHandling()
//			.and()
//			.csrf()
//			.disable();
//		
//		http.headers().frameOptions().disable();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetailService);
	}
	
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/images/**","/productimages/**","/css/**","/js/**");
//	}
	
}
