package com.example.StarterDemo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import antlr.collections.List;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	@Query("SELECT u FROM Manager u WHERE u.firstname = :firstname and u.password = :password")
	Manager findByName(@Param("firstname") String firstname, @Param("password") String password);
}
