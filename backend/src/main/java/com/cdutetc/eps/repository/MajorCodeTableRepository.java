package com.cdutetc.eps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.cdutetc.eps.entity.MajorCodeTable;
@Repository
public interface MajorCodeTableRepository extends JpaRepository<MajorCodeTable,Long>{

    Optional<MajorCodeTable> findByMajorName(String majorName); 
} 
