package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.GrammarRule;
import com.thepaut49.nihongo.repository.GrammarRuleRepository;

@Service
public class GrammarRuleService {
	
	@Autowired
	private GrammarRuleRepository grammarRuleRepository;
	
	public GrammarRule createGrammarRule(GrammarRule newGrammarRule) {
		if (!grammarRuleRepository.existsByTitle(newGrammarRule.getTitle())) {
			return grammarRuleRepository.save(newGrammarRule);
		}
		else {
			throw new ResourceAlreadyExistException("GrammarRule " + newGrammarRule.getTitle() + " already exist !");
		}
	}
	
	public GrammarRule updateGrammarRule(GrammarRule grammarRule) {
		if (grammarRule != null) {
			return grammarRuleRepository.save(grammarRule);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<GrammarRule> grammarRule = grammarRuleRepository.findById(id);
		if (!grammarRule.isPresent()) {
			throw new ResourceNotFoundException("Could not found the GrammarRule with id : " + id );
		}
		grammarRuleRepository.deleteById(id);
	}

	public GrammarRule findById(Integer id) {
		Optional<GrammarRule> grammarRule = grammarRuleRepository.findById(id);
		if (!grammarRule.isPresent()) {
			throw new ResourceNotFoundException("Could not found the GrammarRule with id : " + id );
		}
		return grammarRule.get();
	}
	
	public List<GrammarRule> findAll() {
		return grammarRuleRepository.findAll();
	}
	
	public GrammarRule findByTitle(String title) {
		return grammarRuleRepository.findByTitle( title);
	}
}
