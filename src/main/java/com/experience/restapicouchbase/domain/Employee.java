package com.experience.restapicouchbase.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.query.N1qlJoin;
import org.springframework.data.couchbase.repository.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@Collection("employees")
@Getter @Setter @AllArgsConstructor
public class Employee {

    private @Id String id;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private String gender;

    private Date hireDate;

    /*
     * Index needed :
     * CREATE INDEX adv_employeeId_class ON `default`:`my-great-team`.`organization`.`titles`(`employeeId`) 
     * WHERE `_class` = 'com.experience.restapicouchbase.domain.Title'
     * 
     * Generated request
     * SELECT META(rks).id AS __id, META(rks).cas AS __cas, (rks).*  
        FROM `my-great-team`.`organization`.`employees` lks 
        JOIN `my-great-team`.`organization`.`titles` rks ON meta(lks).id=rks.employeeId 
        AND lks.`_class` = "com.experience.restapicouchbase.domain.Employee" 
        AND rks.`_class` = "com.experience.restapicouchbase.domain.Title" 
        WHERE META(lks).id="employee::1"
     * 
     */
    @N1qlJoin(on="meta(lks).id=rks.employeeId")
    private List<Title> titles;
}
