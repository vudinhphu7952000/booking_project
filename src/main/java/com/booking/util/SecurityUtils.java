package com.booking.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {
	public static User getPrincipal() {
		User myUser = (User) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myUser;
    }
}
