package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.dto.NameCriteriaDTO;
import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.Name;
import com.thepaut49.nihongo.repository.NameRepository;

@Service
public class NameService {
	
	@Autowired
	private NameRepository nameRepository;
	
	public Name createName(Name newName) {
		if (!nameRepository.existsByKanjis(newName.getKanjis())) {
			newName.setNumberOfUse(1);
			return nameRepository.save(newName);
		}
		else {
			throw new ResourceAlreadyExistException("Name " + newName.getKanjis() + " already exist !");
		}
	}
	
	public Name updateName(Name name) {
		if (name != null) {
			return nameRepository.save(name);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<Name> name = nameRepository.findById(id);
		if (!name.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Name with id : " + id );
		}
		nameRepository.deleteById(id);
	}

	public Name findById(Integer id) {
		Optional<Name> name = nameRepository.findById(id);
		if (!name.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Name with id : " + id );
		}
		return name.get();
	}
	
	public List<Name> findAll() {
		return nameRepository.findAll();
	}
	
	public List<Name> findWithCriteria(NameCriteriaDTO criteria) {
		String kanjis = criteria.getKanjis();
		String meaning = criteria.getMeaning();
		String pronunciation = criteria.getPronunciation();
		return nameRepository.findWithCriteria(kanjis, pronunciation, meaning);
	}
	
	public Name updateNameNumberOfUse(Integer id) {
		Name name = nameRepository.findById(id).get();
		name.setNumberOfUse(name.getNumberOfUse() + 1);
		return nameRepository.save(name);
	}

	public List<Name> findMostUsedNames(Integer quantity) {
		return nameRepository.findMostUsedNames(quantity);
	}

	public Name findByKanjis(String kanjis) {
		return nameRepository.findByKanjis( kanjis);
	}

}
