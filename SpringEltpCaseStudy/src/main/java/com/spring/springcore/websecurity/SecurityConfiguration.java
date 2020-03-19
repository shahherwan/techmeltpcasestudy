package com.spring.springcore.websecurity;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsService userDetailsService;

//	@Autowired
//	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		auth.jdbcAuthentication().dataSource(dataSource)
//        .usersByUsernameQuery("select email, password, enabled"
//        					+ " from users where email=?")
//        .authoritiesByUsernameQuery("select username, authority "
//        							+ "from authorities where username=?")
//        .passwordEncoder(new BCryptPasswordEncoder());
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	/**
	 * Configures the access rights for the application.
	 *
	 * @param http the HttpSecurity context of the application
	 * @throws Exception some exception.
	 */

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
				// URLs without a need for authentication
				.antMatchers("/h2-console/**", "/login", "/register").permitAll()
				// Any requests needs to be authenticated.
				.anyRequest().authenticated()
			.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
//	      			.usernameParameter("email").passwordParameter("password")
				.and()
					.logout()
					.logoutUrl("/logout")
					.permitAll()
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")

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
				.and().csrf();
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable();

	}
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//	    return bCryptPasswordEncoder;
//	}


	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//	@Bean
//	public JdbcUserDetailsManager jdbcUserDetailsManager() {
//		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//		jdbcUserDetailsManager.setDataSource(dataSource);
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled" + " from users where username=?");
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority " + "from authorities where username=?");
//
//		return jdbcUserDetailsManager;
//	}
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}