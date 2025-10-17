package com.cdutetc.eps.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EPSTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int serialNumber;

    private String experimentNumber;

    private String experimentName;

    private String experimentContent;

    private int experimentalCategory;
    
    private int experimentalNature;

    private String experimentDiscipline ;

    private int experimentalRequirements; 

    private int experimenterCategory; 

    private int experimenterCount;
    private int groupMemberCount;
    private int experimentCreditHours;
    private int isOffered;
    private int nonOfferReason;
    private int labNo;
    private int labName;
    private int courseName;
    private int courseSemester;
    private int totalCourseHours;
    private int theoreticalHours;
    private int practicalHours;
    private int courseType;




}
