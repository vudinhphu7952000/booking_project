package com.booking.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

//Lấy thông tin user hiện hành trong spring security
public class SecurityUtils {
	public static User getPrincipal() {
		User myUser = (User) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myUser;
    }
}
