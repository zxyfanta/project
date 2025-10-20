package com.cdutetc.eps.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.JWTValidator;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;

// 打不打注解？
// @Service @Controller @Repository @Entity 表示实体，java bean，用来标识，需要得到spring的管理。
// @Component 表明该类是一个组件，请吧它纳入到spring的管理中
@Component
public class JwtTokenUtil {
    // 主要目的是给出用户的身份认证token，
    // 如果每一个开发者，都是用同意的程序，是否会得到一致的token，token生成过程中，需要添加自己的加密字符串，而且要保护好这个字符串。

    // 从配置文件中读取信息，并注入到当前对象的方法？
    // @Value 配合模板语法
    // "${secret}"=-> "${jwt.secret}"(正确的写法)

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    // 对外公开一个方法，用于产生用户所需要的token
    public String generateToken(UserDetails userDetails){
        Map<String,Object> preload=new HashMap<>();
        preload.put("sub",userDetails.getUsername());
        preload.put("iat",new Date());
        preload.put("exp",new Date(System.currentTimeMillis()+expiration*1000));
        JWTSigner signer=JWTSignerUtil.hs256(secret.getBytes());
        return JWTUtil.createToken(preload, signer);
    }

    // 从token中获取EmploeyId
    public String extractUsername(String token){
        return JWTUtil.parseToken(token).getPayload("sub").toString();
    }

    //token 是否失效
    public boolean validateToken(String token,UserDetails userDetails){
        try{
            JWTSigner signer=JWTSignerUtil.hs256(secret.getBytes());
            if(!JWTUtil.verify(token, signer)){
                return false;
            }
            JWTValidator.of(token).validateDate();
            String username=extractUsername(token);
            return username.equals(userDetails.getUsername());
        }catch(Exception e){
            return false;
        }
    }
}
