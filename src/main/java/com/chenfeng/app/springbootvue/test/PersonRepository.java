package com.chenfeng.app.springbootvue.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "person")
public interface PersonRepository extends CrudRepository<Person,Long>{
}
