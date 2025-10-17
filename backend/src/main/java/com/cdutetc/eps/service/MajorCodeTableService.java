package com.cdutetc.eps.service;

import java.util.List;
import java.util.Optional;

import com.cdutetc.eps.entity.MajorCodeTable;

public interface MajorCodeTableService {
    // 查所有
    List<MajorCodeTable> getAllMajorCodes();
    // 根据id查询
    Optional<MajorCodeTable> getMajorCodeById(Long id);
    // 添加
    MajorCodeTable saveMajorCode(MajorCodeTable majorCodeTable);
    // 根据id 删除
    void deleteMajorCode(Long id);
    // 根据专业名称查询
    Optional<MajorCodeTable> getByMajorCodeName(String majorName);
}
