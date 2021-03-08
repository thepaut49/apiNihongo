package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.Particule;
import com.thepaut49.nihongo.repository.ParticuleRepository;

@Service
public class ParticuleService {
	
	@Autowired
	private ParticuleRepository particuleRepository;
	
	public Particule createParticule(Particule newParticule) {
		if (!particuleRepository.existsByKanjis(newParticule.getKanjis())) {
			return particuleRepository.save(newParticule);
		}
		else {
			throw new ResourceAlreadyExistException("Particule " + newParticule.getKanjis() + " already exist !");
		}
	}
	
	public Particule updateParticule(Particule particule) {
		if (particule != null) {
			return particuleRepository.save(particule);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<Particule> particule = particuleRepository.findById(id);
		if (!particule.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Particule with id : " + id );
		}
		particuleRepository.deleteById(id);
	}

	public Particule findById(Integer id) {
		Optional<Particule> particule = particuleRepository.findById(id);
		if (!particule.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Particule with id : " + id );
		}
		return particule.get();
	}
	
	public List<Particule> findAll() {
		return particuleRepository.findAll();
	}
	

	public Particule findByKanjis(String kanjis) {
		return particuleRepository.findByKanjis( kanjis);
	}

}
