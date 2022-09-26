package br.com.jocimar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jocimar.adapter.DozerAdapter;
import br.com.jocimar.data.model.Person;
import br.com.jocimar.data.vo.v1.PersonVO;
import br.com.jocimar.exceptions.ResourceNotFoundException;
import br.com.jocimar.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerAdapter.parseObject(person, Person.class);		
		Person savedPerson = repository.save(entity);		
		var vo = DozerAdapter.parseObject(savedPerson, PersonVO.class);		
		
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var savedPerson = repository.save(entity);
		
		return DozerAdapter.parseObject(savedPerson, PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		repository.delete(entity);
	}
	
	public List<PersonVO> findAll() {		
		var personList = repository.findAll();		
		return DozerAdapter.parseListObjects(personList, PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		return DozerAdapter.parseObject(entity, PersonVO.class); 
	}
}
