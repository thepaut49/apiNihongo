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

import com.thepaut49.nihongo.dto.ParticuleDTO;
import com.thepaut49.nihongo.mapper.ParticuleToDTOMapper;
import com.thepaut49.nihongo.model.Particule;
import com.thepaut49.nihongo.service.ParticuleService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/particules")
public class ParticuleController {

	@Autowired
	private ParticuleService particuleService;

	@PostMapping("/create")
	public ParticuleDTO createParticule( @RequestBody ParticuleDTO particuleDTO) {
		Particule newParticule = ParticuleToDTOMapper.map(particuleDTO);
		return ParticuleToDTOMapper.map(particuleService.createParticule(newParticule));
	}

	@PutMapping("/{id}")
	public ParticuleDTO updateParticule( @RequestBody ParticuleDTO particuleDTO, @PathVariable Integer id) {
		Particule updatedParticule = ParticuleToDTOMapper.map(particuleDTO);  
		updatedParticule.setId(id);
		return ParticuleToDTOMapper.map(particuleService.updateParticule(updatedParticule));
	}
	
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		particuleService.delete(id);
		return "Particule deleted !";
	}

	@GetMapping(value = "/{id}")
	public ParticuleDTO findById( @PathVariable Integer id) {
		return ParticuleToDTOMapper.map(particuleService.findById(id));
	}
	
	@GetMapping(value = "/findByKanjis/{kanjis}")
	public ParticuleDTO findByKanjis( @PathVariable String kanjis) {
		return ParticuleToDTOMapper.map(particuleService.findByKanjis(kanjis));
	}

	@GetMapping("/all")
	public List<ParticuleDTO> getAllParticules() {
		List<Particule> particules = particuleService.findAll();
		return particules
				.stream()
				.map(particule -> ParticuleToDTOMapper.map(particule))
				.collect(Collectors.toList());
	}
}
