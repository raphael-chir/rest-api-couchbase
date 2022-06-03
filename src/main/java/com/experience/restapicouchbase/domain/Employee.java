package com.experience.restapicouchbase.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.repository.Collection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Collection("employees")
@Getter @Setter @NoArgsConstructor
public class Employee {

    private @Id String id;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private String gender;

    private Date hireDate;
}
