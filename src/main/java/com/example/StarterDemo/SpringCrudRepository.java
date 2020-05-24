package com.example.StarterDemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
import org.springframework.data.repository.query.Param;

public interface SpringCrudRepository extends CrudRepository<Employee, Integer> { 
	@Query("select count(*) from Employee")
	int getCount();
}