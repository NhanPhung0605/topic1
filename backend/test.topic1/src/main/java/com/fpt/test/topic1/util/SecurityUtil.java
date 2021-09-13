package com.fpt.test.topic1.util;

import com.fpt.test.topic1.service.impl.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author : Admin
 * @created : 10-Aug-21
 **/
public class SecurityUtil {

    private SecurityUtil() {

    }

    public static UserDetailsImpl getCurrentUser() {
        UserDetailsImpl user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl) {
            user = (UserDetailsImpl) authentication.getPrincipal();
        }
        return user;
    }
}
