package com.experience.restapicouchbase.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.repository.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Collection("titles")
@Getter @Setter @AllArgsConstructor
public class Title {
    
    private @Id String id;

    private String employeeId;

    private String title;

    private Date fromDate;

    private Date toDate;

}
