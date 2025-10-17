package com.cdutetc.eps.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cdutetc.eps.common.ApiResponse;
import com.cdutetc.eps.entity.MajorCodeTable;
import com.cdutetc.eps.service.impl.MajorCodeTableServiceImpl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController 
@RequestMapping("/api/major-codes")
@RequiredArgsConstructor
public class MajorCodeTableController {
    // 当前这个controller并不具备实际操作数据的能力，因此需要借助？MajorCodeTableRepository接口
    // repository是一个接口，在这里我们需要将其当作一个类来进行使用。
    // private final 必须满足这两个条件
    private final MajorCodeTableServiceImpl majorCodeTableServiceImpl;


    //curd 
    // 查询
    //通过id进行查询
    //get请求，/api/major-codes/{id}
    //pathVerable
    @GetMapping("/{id}")
    public ApiResponse<MajorCodeTable> getMajorCodeById(@PathVariable Long id){
        return ApiResponse.success(majorCodeTableServiceImpl.getMajorCodeById(id).orElse(null));
    }

    // 获取全部专业代码
    //1 确定访问形式，：在restful风格中 ，无任何参数的get请求，表示获取全部信息
    @GetMapping
    public ApiResponse<List<MajorCodeTable>> getAllMajorCodes(){
        return ApiResponse.success(majorCodeTableServiceImpl.getAllMajorCodes());
    }


    //create 添加 在接收json数据时，应当使用 @RequestBody来标记
    @PostMapping
    public ApiResponse<MajorCodeTable> createMajorCode(@RequestBody MajorCodeTable majorCodeTable){
        return ApiResponse.success(majorCodeTableServiceImpl.saveMajorCode(majorCodeTable));
    }

    // delete DeleteMapping("/{id}")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteMajorCode(@PathVariable Long id){
        if(!majorCodeTableServiceImpl.getMajorCodeById(id).isPresent()){
            // TODO 添加全局异常处理
            throw Exception;
        }
        majorCodeTableServiceImpl.deleteMajorCode(id);
        return ApiResponse.success();
    }



    
}
