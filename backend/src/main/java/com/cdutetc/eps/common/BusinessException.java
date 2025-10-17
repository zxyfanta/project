package com.cdutetc.eps.common;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
    private final int code;
    public BusinessException(int code,String message){
        super(message);
        this.code=code;
    }

    public static BusinessException notFound(String entiry){
        return new BusinessException(404, entiry+"不存在");
    }
    public static BusinessException forbidden(){
        return new BusinessException(403, "无权限");
    }
    
}
