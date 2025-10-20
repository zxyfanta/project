package com.cdutetc.eps.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cdutetc.eps.repository.TeacherRepository;
import com.cdutetc.eps.service.TeacherDetailsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherDetailsServiceImpl implements TeacherDetailsService {
    private final TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException{
        return teacherRepository.findByEmployeeId(employeeId).orElseThrow(() -> new UsernameNotFoundException(employeeId));
    }
    
}
