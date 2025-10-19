package com.cdutetc.eps.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface TeacherDetailsService {
    public UserDetails loadUserByUsername(String employeeId)throws UsernameNotFoundException;
}
