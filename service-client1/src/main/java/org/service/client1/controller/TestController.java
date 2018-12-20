package org.service.client1.controller;

import java.util.List;

import javax.annotation.Resource;

import org.service.client1.bean.Person;
import org.service.client1.dao.PersonRepository;
import org.service.client1.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Resource
	private TestService testService;

	@RequestMapping("/get")
	public String get(int id) {
		Person person = testService.findById(id);
		return person.toString();
	}

	@RequestMapping("/getByName")
	public String get(@RequestParam(required = false) String name) {
		List<Person> findAll = testService.findByName(name);
		String str = "";
		for (Person person : findAll) {
			str += person.toString();
		}
		return str;
	}

	@RequestMapping("/update")
	public String update(Person person) {
		testService.save(person);
		return person.toString();
	}
	
	@RequestMapping("/updateNameById")
	public int update(String name, int id) {
		int updateNameById = testService.UpdateNameById(name, id);
		return updateNameById;
	}

	@RequestMapping("/create")
	public String create(Person person) {
		testService.save(person);
		return person.toString();
	}

	@RequestMapping("/delete")
	public int delete(int id) {
		testService.delete(id);
		return id;
	}
}
