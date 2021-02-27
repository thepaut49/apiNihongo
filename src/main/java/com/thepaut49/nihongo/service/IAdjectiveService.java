package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.dto.IAdjectiveCriteriaDTO;
import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.IAdjective;
import com.thepaut49.nihongo.repository.IAdjectiveRepository;

@Service
public class IAdjectiveService {
	
	@Autowired
	private IAdjectiveRepository iAdjectiveRepository;
	
	public IAdjective createIAdjective(IAdjective newIAdjective) {
		if (!iAdjectiveRepository.existsByKanjis(newIAdjective.getKanjis())) {
			newIAdjective.setNumberOfUse(1);
			return iAdjectiveRepository.save(newIAdjective);
		}
		else {
			throw new ResourceAlreadyExistException("IAdjective " + newIAdjective.getKanjis() + " already exist !");
		}
	}
	
	public IAdjective updateIAdjective(IAdjective iAdjective) {
		if (iAdjective != null) {
			return iAdjectiveRepository.save(iAdjective);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<IAdjective> iAdjective = iAdjectiveRepository.findById(id);
		if (!iAdjective.isPresent()) {
			throw new ResourceNotFoundException("Could not found the IAdjective with id : " + id );
		}
		iAdjectiveRepository.deleteById(id);
	}

	public IAdjective findById(Integer id) {
		Optional<IAdjective> iAdjective = iAdjectiveRepository.findById(id);
		if (!iAdjective.isPresent()) {
			throw new ResourceNotFoundException("Could not found the IAdjective with id : " + id );
		}
		return iAdjective.get();
	}
	
	public List<IAdjective> findAll() {
		return iAdjectiveRepository.findAll();
	}
	
	public List<IAdjective> findWithCriteria(IAdjectiveCriteriaDTO criteria) {
		String kanjis = criteria.getKanjis();
		String meaning = criteria.getMeaning();
		String pronunciation = criteria.getPronunciation();
		return iAdjectiveRepository.findWithCriteria(kanjis, pronunciation, meaning);
	}
	
	public IAdjective updateIAdjectiveNumberOfUse(Integer id) {
		IAdjective iAdjective = iAdjectiveRepository.findById(id).get();
		iAdjective.setNumberOfUse(iAdjective.getNumberOfUse() + 1);
		return iAdjectiveRepository.save(iAdjective);
	}

	public List<IAdjective> findMostUsedIAdjectives(Integer quantity) {
		return iAdjectiveRepository.findMostUsedIAdjectives(quantity);
	}

	public IAdjective findByKanjis(String kanjis) {
		return iAdjectiveRepository.findByKanjis( kanjis);
	}

}
