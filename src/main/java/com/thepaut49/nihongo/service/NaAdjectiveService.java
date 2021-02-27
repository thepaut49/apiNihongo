package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.dto.NaAdjectiveCriteriaDTO;
import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.NaAdjective;
import com.thepaut49.nihongo.repository.NaAdjectiveRepository;

@Service
public class NaAdjectiveService {
	
	@Autowired
	private NaAdjectiveRepository naAdjectiveRepository;
	
	public NaAdjective createNaAdjective(NaAdjective newNaAdjective) {
		if (!naAdjectiveRepository.existsByKanjis(newNaAdjective.getKanjis())) {
			newNaAdjective.setNumberOfUse(1);
			return naAdjectiveRepository.save(newNaAdjective);
		}
		else {
			throw new ResourceAlreadyExistException("NaAdjective " + newNaAdjective.getKanjis() + " already exist !");
		}
	}
	
	public NaAdjective updateNaAdjective(NaAdjective naAdjective) {
		if (naAdjective != null) {
			return naAdjectiveRepository.save(naAdjective);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<NaAdjective> naAdjective = naAdjectiveRepository.findById(id);
		if (!naAdjective.isPresent()) {
			throw new ResourceNotFoundException("Could not found the NaAdjective with id : " + id );
		}
		naAdjectiveRepository.deleteById(id);
	}

	public NaAdjective findById(Integer id) {
		Optional<NaAdjective> naAdjective = naAdjectiveRepository.findById(id);
		if (!naAdjective.isPresent()) {
			throw new ResourceNotFoundException("Could not found the NaAdjective with id : " + id );
		}
		return naAdjective.get();
	}
	
	public List<NaAdjective> findAll() {
		return naAdjectiveRepository.findAll();
	}
	
	public List<NaAdjective> findWithCriteria(NaAdjectiveCriteriaDTO criteria) {
		String kanjis = criteria.getKanjis();
		String meaning = criteria.getMeaning();
		String pronunciation = criteria.getPronunciation();
		return naAdjectiveRepository.findWithCriteria(kanjis, pronunciation, meaning);
	}
	
	public NaAdjective updateNaAdjectiveNumberOfUse(Integer id) {
		NaAdjective naAdjective = naAdjectiveRepository.findById(id).get();
		naAdjective.setNumberOfUse(naAdjective.getNumberOfUse() + 1);
		return naAdjectiveRepository.save(naAdjective);
	}

	public List<NaAdjective> findMostUsedNaAdjectives(Integer quantity) {
		return naAdjectiveRepository.findMostUsedNaAdjectives(quantity);
	}

	public NaAdjective findByKanjis(String kanjis) {
		return naAdjectiveRepository.findByKanjis( kanjis);
	}

}
