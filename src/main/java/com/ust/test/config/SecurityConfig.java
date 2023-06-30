package com.ust.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//here we writting the security things
	//2things we need to write 2)authorisation
	//1)authentication
	
	
	
	
	//1st we need to extend the WebSecurityConfigurerAdapter
	//annotation
	//ctrl +space we will get this
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("bond")
		.password("james").roles("USER").and()
		.withUser("pink").password("rose").roles("ADMIN");//
		//anymore und we can do using .and vechhu pokkumm
	}
	@Override
		protected void configure(HttpSecurity http) throws Exception {
			// TODO Auto-generated method stub
http.authorizeRequests()
.antMatchers("/admin").hasRole("ADMIN")
.antMatchers("/user").hasAnyRole("USER","ADMIN") //both user
//and admin can enter thats y we are giving anyroles
//
.antMatchers("/forall").permitAll().and().formLogin(); //all can enter here

	//to get the formLogin page we will get it
	}
	
	
	
	//we will get an error when we run so we are give bean injections
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	//http://localhost:8080/user
	//then need to logout
	//http://localhost:8080/admin
	//then need to logout
	//then repeat this again and again
}
