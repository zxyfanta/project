package com.cdutetc.eps.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cdutetc.eps.entity.Teacher;
import com.cdutetc.eps.utils.JwtTokenUtil;
import com.cdutetc.eps.service.impl.TeacherDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtRequsetFilter extends OncePerRequestFilter {

    private final TeacherDetailsServiceImpl teacherDetailsServiceImpl;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException,IOException{
        final String authorizationHeader=request.getHeader("Authorization");
        String employeeId=null;
        String jwt=null;
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
            jwt=authorizationHeader.substring(7);
            // 获取用户名
            employeeId=jwtTokenUtil.extractUsername(jwt);
        }
        if(employeeId!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = this.teacherDetailsServiceImpl.loadUserByUsername(employeeId);
            if(jwtTokenUtil.validateToken(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(request, response);

    }
    
    
}
