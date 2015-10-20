package com.hulk.util;

import com.hulk.data.pojo.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by vijayvar on 10/20/15.
 */
public class Utils {

    private Utils() { }

    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static CurrentUser getCurrentUser() {
        return (CurrentUser) getAuthentication().getPrincipal();
    }

    public static Long getCurrentAgentId() {
        return getCurrentUser().getAgent().getId();
    }
}
