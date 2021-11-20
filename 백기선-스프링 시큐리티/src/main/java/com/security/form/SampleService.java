package com.security.form;

import com.security.common.SecurityLogger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SampleService {

    @Secured("ROLE_USER")
    public void dashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        System.out.println("===================================");
        System.out.println(userDetails.getUsername());

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        Object credentials = authentication.getCredentials();

        boolean authenticated = authentication.isAuthenticated();
    }

    @Async
    public void asyncService() {
        try {
            SecurityLogger.log("Async service");
            System.out.println("Async service is called");
            Thread.sleep(3_000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
