package org.service.client1.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.service.client1.bean.Person;
import org.service.client1.dao.PersonRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	@Resource
	private PersonRepository personRepository;

	// 添加
	public void save(Person person) {
		this.personRepository.save(person);
	}
	
	// 删除
	public void delete(Integer id) {
		this.personRepository.deleteById(id);
	}

	// 查询
	public List<Person> findAll() {
		return (List<Person>) this.personRepository.findAll();
	}
	
	public Person findById(int id) {
		return personRepository.getOne(id);
	}
	
	public List<Person> findAll(Person person){
		Example<Person> example = Example.of(person);
		return personRepository.findAll(example);
	}
	
	public List<Person> findByName(String name){
		return personRepository.findByName(name);
	}
	
	public int UpdateNameById(String name, int id){
		return personRepository.update(name, id);
	}
	
	public List<Person> findByCountryName(String name){
		return personRepository.findByCountry_Name(name);
	}
	
	public List<Person> findByCountryNameAndSexAndName(String countryName, int sex, String personName){
		return personRepository.findByCountry_NameAndSexAndName(countryName, sex, personName);
	}
	
	
	
}
