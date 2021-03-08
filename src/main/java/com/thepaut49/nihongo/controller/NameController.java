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

import com.thepaut49.nihongo.dto.NameCriteriaDTO;
import com.thepaut49.nihongo.dto.NameDTO;
import com.thepaut49.nihongo.dto.ObjectDTO;
import com.thepaut49.nihongo.mapper.NameToDTOMapper;
import com.thepaut49.nihongo.mapper.ObjectDTOMapper;
import com.thepaut49.nihongo.model.Name;
import com.thepaut49.nihongo.service.NameService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/names")
public class NameController {

	@Autowired
	private NameService nameService;

	@PostMapping("/create")
	public NameDTO createName( @RequestBody NameDTO nameDTO) {
		Name newName = NameToDTOMapper.map(nameDTO);
		return NameToDTOMapper.map(nameService.createName(newName));
	}

	@PutMapping("/{id}")
	public NameDTO updateName( @RequestBody NameDTO nameDTO, @PathVariable Integer id) {
		Name updatedName = NameToDTOMapper.map(nameDTO);  
		updatedName.setId(id);
		return NameToDTOMapper.map(nameService.updateName(updatedName));
	}
	
	@PatchMapping("/{id}")
	public NameDTO updateNameNumberOfUse( @PathVariable Integer id) {
		return NameToDTOMapper.map(nameService.updateNameNumberOfUse(id));
	}


	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		nameService.delete(id);
		return "Name deleted !";
	}

	@GetMapping(value = "/{id}")
	public NameDTO findById( @PathVariable Integer id) {
		return NameToDTOMapper.map(nameService.findById(id));
	}
	
	@GetMapping(value = "/findByKanjis/{kanjis}")
	public NameDTO findByKanjis( @PathVariable String kanjis) {
		return NameToDTOMapper.map(nameService.findByKanjis(kanjis));
	}

	@GetMapping("/all")
	public List<NameDTO> getAllNames() {
		List<Name> names = nameService.findAll();
		return names
				.stream()
				.map(name -> NameToDTOMapper.map(name))
				.collect(Collectors.toList());
	}

	@GetMapping("/findWithCriteria")
	@ResponseBody
	public List<NameDTO> getAllNamesAccortingToCriteria( @RequestParam(required = false) String kanjis,@RequestParam(required = false) String pronunciation, @RequestParam(required = false) String meaning ) { 
		NameCriteriaDTO nameCriteriaDTO = new NameCriteriaDTO();
		nameCriteriaDTO.setKanjis(kanjis);
		nameCriteriaDTO.setPronunciation(pronunciation);
		nameCriteriaDTO.setMeaning(meaning);
		
		List<Name> names = nameService.findWithCriteria(nameCriteriaDTO);
		return names
				.stream()
				.map(lName -> NameToDTOMapper.map(lName))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/findMostUsedNames/{quantity}")
	public List<ObjectDTO> findMostUsedNames(@PathVariable Integer quantity) { 
		List<Name> names = nameService.findMostUsedNames(quantity);
		return names
				.stream()
				.map(name -> ObjectDTOMapper.map(name))
				.collect(Collectors.toList());
	}


}
