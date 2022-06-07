package com.experience.restapicouchbase.infratructure;

import org.springframework.data.repository.CrudRepository;

import com.experience.restapicouchbase.domain.Title;

interface TitleRepository extends CrudRepository<Title, String>{}
