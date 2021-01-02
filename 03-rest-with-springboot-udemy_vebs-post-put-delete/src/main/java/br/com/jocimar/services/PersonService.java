package br.com.jocimar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.jocimar.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}
	
	public List<Person> findAll() {
		ArrayList<Person> list = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			list.add(mockPerson(i));
		}
		
		return list;
	}
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Jocimar");
		person.setLastName("Huss");
		person.setAddress("Mandaguari-PR");
		person.setGender("Male");
		
		return person;
	}
	
	private Person mockPerson(Integer i) {
		Person person = new Person();
		
		person.setId(i.longValue());
		person.setFirstName(String.format("Jocimar %d",i));
		person.setLastName(String.format("Huss %d", i));
		person.setAddress(String.format("Mandaguari-PR %d", i));
		person.setGender(String.format("Male %d", i));
		
		return person;
	}

}
