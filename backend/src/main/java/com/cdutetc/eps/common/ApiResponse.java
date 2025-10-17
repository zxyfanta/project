package com.cdutetc.eps.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String msg;
    private T data;
    // api访问正确，无数据
    public static <T> ApiResponse<T> success(){
        return new ApiResponse<>(200,"操作成功",null);
    }
    // api访问正确，有数据
    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(200,"操作成功",data);
    }
    // api访问失败，自定义信息
    public static <T> ApiResponse<T> error(String msg){
        return new ApiResponse<>(500,msg,null);
    }
    // api访问失败，自定义信息和错误码
    public static <T> ApiResponse<T> error(String msg,int code){
        return new ApiResponse<>(code,msg,null);
    }
    
}
