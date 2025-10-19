package com.cdutetc.eps.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cdutetc.eps.entity.Teacher;
import com.cdutetc.eps.utils.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtRequsetFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException,IOException{
        final String authorizationHeader=request.getHeader("Authorization");
        String username=null;
        String jwt=null;
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")){
            jwt=authorizationHeader.substring(7);
            // 获取用户名
            username=jwtTokenUtil.extractUserName(jwt);
        }
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            Teacher teacher=this.userDetailsService.loadUserByUsername(username);
            if(jwtTokenUtil.validateToken(jwt, teacher)){
                UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(teacher,null, teacher.)
            }
        }

    }
    
    
}
