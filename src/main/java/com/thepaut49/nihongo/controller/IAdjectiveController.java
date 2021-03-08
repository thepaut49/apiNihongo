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

import com.thepaut49.nihongo.dto.IAdjectiveCriteriaDTO;
import com.thepaut49.nihongo.dto.IAdjectiveDTO;
import com.thepaut49.nihongo.dto.ObjectDTO;
import com.thepaut49.nihongo.mapper.IAdjectiveToDTOMapper;
import com.thepaut49.nihongo.mapper.ObjectDTOMapper;
import com.thepaut49.nihongo.model.IAdjective;
import com.thepaut49.nihongo.service.IAdjectiveService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/iAdjectives")
public class IAdjectiveController {

	@Autowired
	private IAdjectiveService iAdjectiveService;

	@PostMapping("/create")
	public IAdjectiveDTO createIAdjective( @RequestBody IAdjectiveDTO iAdjectiveDTO) {
		IAdjective newIAdjective = IAdjectiveToDTOMapper.map(iAdjectiveDTO);
		return IAdjectiveToDTOMapper.map(iAdjectiveService.createIAdjective(newIAdjective));
	}

	@PutMapping("/{id}")
	public IAdjectiveDTO updateIAdjective( @RequestBody IAdjectiveDTO iAdjectiveDTO, @PathVariable Integer id) {
		IAdjective updatedIAdjective = IAdjectiveToDTOMapper.map(iAdjectiveDTO);  
		updatedIAdjective.setId(id);
		return IAdjectiveToDTOMapper.map(iAdjectiveService.updateIAdjective(updatedIAdjective));
	}
	
	@PatchMapping("/{id}")
	public IAdjectiveDTO updateIAdjectiveNumberOfUse( @PathVariable Integer id) {
		return IAdjectiveToDTOMapper.map(iAdjectiveService.updateIAdjectiveNumberOfUse(id));
	}


	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		iAdjectiveService.delete(id);
		return "IAdjective deleted !";
	}

	@GetMapping(value = "/{id}")
	public IAdjectiveDTO findById( @PathVariable Integer id) {
		return IAdjectiveToDTOMapper.map(iAdjectiveService.findById(id));
	}
	
	@GetMapping(value = "/findByKanjis/{kanjis}")
	public IAdjectiveDTO findByNeutralForm( @PathVariable String kanjis) {
		return IAdjectiveToDTOMapper.map(iAdjectiveService.findByKanjis(kanjis));
	}

	@GetMapping("/all")
	public List<IAdjectiveDTO> getAllIAdjectives() {
		List<IAdjective> iAdjectives = iAdjectiveService.findAll();
		return iAdjectives
				.stream()
				.map(iAdjective -> IAdjectiveToDTOMapper.map(iAdjective))
				.collect(Collectors.toList());
	}

	@GetMapping("/findWithCriteria")
	@ResponseBody
	public List<IAdjectiveDTO> getAllIAdjectivesAccortingToCriteria( @RequestParam(required = false) String kanjis,@RequestParam(required = false) String pronunciation, @RequestParam(required = false) String meaning ) { 
		IAdjectiveCriteriaDTO iAdjectiveCriteriaDTO = new IAdjectiveCriteriaDTO();
		iAdjectiveCriteriaDTO.setKanjis(kanjis);
		iAdjectiveCriteriaDTO.setPronunciation(pronunciation);
		iAdjectiveCriteriaDTO.setMeaning(meaning);
		
		List<IAdjective> iAdjectives = iAdjectiveService.findWithCriteria(iAdjectiveCriteriaDTO);
		return iAdjectives
				.stream()
				.map(lIAdjective -> IAdjectiveToDTOMapper.map(lIAdjective))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/findMostUsedIAdjectives/{quantity}")
	public List<ObjectDTO> findMostUsedIAdjectives(@PathVariable Integer quantity) { 
		List<IAdjective> iAdjectives = iAdjectiveService.findMostUsedIAdjectives(quantity);
		return iAdjectives
				.stream()
				.map(iAdjective -> ObjectDTOMapper.map(iAdjective))
				.collect(Collectors.toList());
	}


}
