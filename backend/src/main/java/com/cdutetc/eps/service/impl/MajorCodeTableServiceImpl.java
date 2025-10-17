package com.cdutetc.eps.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cdutetc.eps.entity.MajorCodeTable;
import com.cdutetc.eps.repository.MajorCodeTableRepository;
import com.cdutetc.eps.service.MajorCodeTableService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MajorCodeTableServiceImpl implements MajorCodeTableService{
    private final MajorCodeTableRepository majorCodeTableRepository;

    @Override
    public List<MajorCodeTable> getAllMajorCodes(){
        return majorCodeTableRepository.findAll();
    }

    @Override
    public Optional<MajorCodeTable> getMajorCodeById(Long id){
        return majorCodeTableRepository.findById(id);
    }

    @Override
    public MajorCodeTable saveMajorCode(MajorCodeTable majorCodeTable){
        return majorCodeTableRepository.save(majorCodeTable);
    }
    @Override
    public void deleteMajorCode(Long id){
        majorCodeTableRepository.deleteById(id);
    }
    @Override
    public Optional<MajorCodeTable> getByMajorCodeName(String majorName){
        // TODO 在 MajorCodeTableRepoitory中实现按姓名查询。
        return majorCodeTableRepository.findByMajorName(majorName);
    }


    
}
