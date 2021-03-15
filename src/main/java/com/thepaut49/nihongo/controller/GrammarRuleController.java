package com.thepaut49.nihongo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thepaut49.nihongo.dto.GrammarRuleDTO;
import com.thepaut49.nihongo.mapper.GrammarRuleToDTOMapper;
import com.thepaut49.nihongo.model.GrammarRule;
import com.thepaut49.nihongo.service.GrammarRuleService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/grammarRules")
public class GrammarRuleController {

	@Autowired
	private GrammarRuleService grammarRuleService;

	@PostMapping("/create")
	public GrammarRuleDTO createGrammarRule( @RequestBody GrammarRuleDTO grammarRuleDTO) {
		GrammarRule newGrammarRule = GrammarRuleToDTOMapper.map(grammarRuleDTO);
		return GrammarRuleToDTOMapper.map(grammarRuleService.createGrammarRule(newGrammarRule));
	}

	@PutMapping("/{id}")
	public GrammarRuleDTO updateGrammarRule( @RequestBody GrammarRuleDTO grammarRuleDTO, @PathVariable Integer id) {
		GrammarRule updatedGrammarRule = GrammarRuleToDTOMapper.map(grammarRuleDTO);  
		updatedGrammarRule.setId(id);
		return GrammarRuleToDTOMapper.map(grammarRuleService.updateGrammarRule(updatedGrammarRule));
	}
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		grammarRuleService.delete(id);
		return "GrammarRule deleted !";
	}

	@GetMapping(value = "/{id}")
	public GrammarRuleDTO findById( @PathVariable Integer id) {
		return GrammarRuleToDTOMapper.map(grammarRuleService.findById(id));
	}
	
	@GetMapping(value = "/findByTitle/{title}")
	public GrammarRuleDTO findByTitle( @PathVariable String title) {
		return GrammarRuleToDTOMapper.map(grammarRuleService.findByTitle(title));
	}

	@GetMapping("/all")
	public List<GrammarRuleDTO> getAllGrammarRules() {
		List<GrammarRule> grammarRules = grammarRuleService.findAll();
		return grammarRules
				.stream()
				.map(grammarRule -> GrammarRuleToDTOMapper.map(grammarRule))
				.collect(Collectors.toList());
	}
	
}
