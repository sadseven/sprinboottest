package org.service.client1.dao;

import java.util.List;

import org.service.client1.bean.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person,Integer>{
	
	List<Person> findByName(String name);
	
	//更新

	@Modifying
	@Transactional
	@Query(value="UPDATE Person per SET per.name= ?1 WHERE per.id= ?2")
	int update(String name, int id);
	
}
