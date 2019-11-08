package com.tt.training.jpa;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

public interface CustomerDAO extends CrudRepository<Customer, Long>{
	List<Customer> findByName(String name);
	List<Customer> findByNameAndSurname(String name,String surname);
	// List<Customer> findByNameinList(List<String> name);
	
	// Optional<List<Customer>> findByNameSortByName(String name);

	@Query("select c from Customer c where c.name = :isim")
	List<Customer> getCustomeName(@Param("isim") String name);
	
	@Query(value =  "select * from Musteri where isim = :isim",nativeQuery = true)
	List<Customer> getCustomeNameNative(@Param("isim") String name);
	
	@Async
	Future<List<Customer>> findBySurname(String surname);
	
}
