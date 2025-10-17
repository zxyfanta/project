package com.cdutetc.eps.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cdutetc.eps.repository.MajorCodeTableRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController 
@RequestMapping("/api/major-codes")
@RequiredArgsConstructor
public class MajorCodeTableController {
    // 当前这个controller并不具备实际操作数据的能力，因此需要借助？MajorCodeTableRepository接口
    // repository是一个接口，在这里我们需要将其当作一个类来进行使用。
    // private final 必须满足这两个条件
    private final MajorCodeTableRepository majorCodeTableRepository;

    // public MajorCodeTableController(MajorCodeTableRepository majorCodeTableRepository){
    //     this.majorCodeTableRepository=majorCodeTableRepository;
    // }

    //curd 
    // 查询
    // 获取全部专业代码
    



    
}
