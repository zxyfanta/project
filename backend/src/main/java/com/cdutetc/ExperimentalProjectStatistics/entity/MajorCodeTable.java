package com.cdutetc.ExperimentalProjectStatistics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MajorCodeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String affiliatedCollege;

    private String majorCode;

    private String majorName;

    private int educationalSystem;
    
    private String educationalLevel;
    
}
