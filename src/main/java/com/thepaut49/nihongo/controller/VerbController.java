package com.thepaut49.nihongo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thepaut49.nihongo.dto.ObjectDTO;
import com.thepaut49.nihongo.dto.VerbCriteriaDTO;
import com.thepaut49.nihongo.dto.VerbDTO;
import com.thepaut49.nihongo.mapper.ObjectDTOMapper;
import com.thepaut49.nihongo.mapper.VerbToDTOMapper;
import com.thepaut49.nihongo.model.Verb;
import com.thepaut49.nihongo.service.VerbService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/verbs")
public class VerbController {

	@Autowired
	private VerbService verbService;

	@PostMapping("/create")
	public VerbDTO createVerb( @RequestBody VerbDTO verbDTO) {
		Verb newVerb = VerbToDTOMapper.map(verbDTO);
		return VerbToDTOMapper.map(verbService.createVerb(newVerb));
	}

	@PutMapping("/{id}")
	public VerbDTO updateVerb( @RequestBody VerbDTO verbDTO, @PathVariable Integer id) {
		Verb updatedVerb = VerbToDTOMapper.map(verbDTO);  
		updatedVerb.setId(id);
		return VerbToDTOMapper.map(verbService.updateVerb(updatedVerb));
	}
	
	@PatchMapping("/{id}")
	public VerbDTO updateVerbNumberOfUse( @PathVariable Integer id) {
		return VerbToDTOMapper.map(verbService.updateVerbNumberOfUse(id));
	}


	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		verbService.delete(id);
		return "Verb deleted !";
	}

	@GetMapping(value = "/{id}")
	public VerbDTO findById( @PathVariable Integer id) {
		return VerbToDTOMapper.map(verbService.findById(id));
	}
	
	@GetMapping(value = "/findByNeutralForm/{neutralForm}")
	public VerbDTO findByNeutralForm( @PathVariable String neutralForm) {
		return VerbToDTOMapper.map(verbService.findByNeutralForm(neutralForm));
	}

	@GetMapping("/all")
	public List<VerbDTO> getAllVerbs() {
		List<Verb> verbs = verbService.findAll();
		return verbs
				.stream()
				.map(verb -> VerbToDTOMapper.map(verb))
				.collect(Collectors.toList());
	}

	@GetMapping("/findWithCriteria")
	@ResponseBody
	public List<VerbDTO> getAllVerbsAccortingToCriteria( @RequestParam(required = false) String neutralForm,@RequestParam(required = false) String pronunciation, @RequestParam(required = false) String meaning,
			@RequestParam(required = false) String groupe ) { 
		VerbCriteriaDTO verbCriteriaDTO = new VerbCriteriaDTO();
		verbCriteriaDTO.setNeutralForm(neutralForm);
		verbCriteriaDTO.setPronunciation(pronunciation);
		verbCriteriaDTO.setMeaning(meaning);
		verbCriteriaDTO.setGroupe(groupe);
		
		List<Verb> verbs = verbService.findWithCriteria(verbCriteriaDTO);
		return verbs
				.stream()
				.map(lVerb -> VerbToDTOMapper.map(lVerb))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/findMostUsedVerbs/{quantity}")
	public List<ObjectDTO> findMostUsedVerbs(@PathVariable Integer quantity) { 
		List<Verb> verbs = verbService.findMostUsedVerbs(quantity);
		return verbs
				.stream()
				.map(verb -> ObjectDTOMapper.map(verb))
				.collect(Collectors.toList());
	}


}
