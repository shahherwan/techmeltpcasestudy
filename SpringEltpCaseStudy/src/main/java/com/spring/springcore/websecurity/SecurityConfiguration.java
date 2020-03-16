package com.spring.springcore.websecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled"
        					+ " from users where username=?")
        .authoritiesByUsernameQuery("select username, authority "
        							+ "from authorities where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
	      		.anyRequest().authenticated()
	      .and()
	      		.formLogin()
	      			.loginPage("/login").permitAll()
//	      			.usernameParameter("email").passwordParameter("password")

				 
//		 httpSecurity.authorizeRequests()
//		 	.antMatchers("/employees").permitAll()
//		 	.antMatchers("/login/*").permitAll()
//		 	.antMatchers("/h2-console/*").permitAll()
//		 	.antMatchers("/").permitAll()
//		 .and()
//         	.authorizeRequests().antMatchers("/h2-console/**").permitAll()
//         .and()
//         	.formLogin().loginPage("/login").defaultSuccessUrl("/employees")
//		 .and()
//		    .logout().logoutSuccessUrl("/login?logout") 
//	     .and()
//		    .exceptionHandling().accessDeniedPage("/403")
		
//		 httpSecurity.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//		    .and()
//			    .httpBasic()
		    .and()
		    	.csrf();
		 httpSecurity.csrf().disable();
		 httpSecurity.headers().frameOptions().disable();

		
	}
}