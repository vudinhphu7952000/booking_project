package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.repository.UserRepository;

@Service
@Transactional
@Configurable
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageSource messages;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.booking.entity.User user = userRepository.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("user not found !");
		}
		List<GrantedAuthority> role = new ArrayList<>();
		role.add(new SimpleGrantedAuthority(user.getRole()));
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, role);
	}

}
