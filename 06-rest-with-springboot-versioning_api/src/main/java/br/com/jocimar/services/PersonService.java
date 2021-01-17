package br.com.jocimar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jocimar.converter.DozerConverter;
import br.com.jocimar.converter.custom.PersonConverter;
import br.com.jocimar.data.model.Person;
import br.com.jocimar.data.vo.PersonVO;
import br.com.jocimar.data.vo.v2.PersonVOV2;
import br.com.jocimar.exceptions.ResourceNotFoundException;
import br.com.jocimar.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonConverter converter;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);		
		Person savedPerson = repository.save(entity);		
		var vo = DozerConverter.parseObject(savedPerson, PersonVO.class);		
		
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		var entity = converter.converterVOToEntity(person);		
		Person savedPerson = repository.save(entity);		
		var vo = converter.converterEntityToVO(savedPerson);		
		
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var savedPerson = repository.save(entity);
		
		return DozerConverter.parseObject(savedPerson, PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		repository.delete(entity);
	}
	
	public List<PersonVO> findAll() {		
		var personList = repository.findAll();		
		return DozerConverter.parseListObjects(personList, PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this ID."));
		
		return DozerConverter.parseObject(entity, PersonVO.class); 
	}
}
