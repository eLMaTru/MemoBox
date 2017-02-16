package com.afm.service;

import java.util.List;

import com.afm.model.People;
import com.afm.repository.PeopleRepository;

public class PeopleService {

	PeopleRepository pr = new PeopleRepository();
	People p = new People();

	public People savePeople(String name, String lastName, int age) {
		p.setAge(age);
		p.setLastName(lastName);
		p.setName(name);
		pr.savePeople(p);

		return p;
	}

	public List<People> getPeople() {
		return pr.getPeople();
	}

	public void deletePeople(int id) {
		pr.deletePeople(id);
	}

	public void updateP(int id, String name, String lastName, int age) {
		p.setAge(age);
		p.setLastName(lastName);
		p.setName(name);
		p.setId(id);
		pr.updateP(p);
	}

}
