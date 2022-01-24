package com.booking.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.booking.service.impl.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	UserService userService;
	
	@Autowired
	private DataSource dataSource;
	
	//Mã háo password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Cấu hình security các rquest theo url, login, logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
		 .csrf().disable()
		 .authorizeRequests()
         .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
         .anyRequest().authenticated()   
         .and()
         .httpBasic()
         .and().formLogin().loginPage("/login").permitAll()
         .defaultSuccessUrl("/trang-chu")
         .and()  
         .logout()  
         .logoutUrl("/j_spring_security_logout")  
         .logoutSuccessUrl("/")  
         ;

	// Cấu hình Remember Me.
	http.authorizeRequests().and() //
			.rememberMe().tokenRepository(this.persistentTokenRepository()) //
			.tokenValiditySeconds(1 * 24 * 60 * 60);

	}
	
	//Hỗ trợ remember me
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
//	//Cung cấp thông tin user lấy từ database (UserDetail) for spring security
//	@Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }

}
