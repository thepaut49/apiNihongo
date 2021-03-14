package com.thepaut49.nihongo.mapper;

import com.thepaut49.nihongo.dto.ParticuleDTO;
import com.thepaut49.nihongo.model.Particule;

public class ParticuleToDTOMapper {
	
	public static ParticuleDTO map(Particule particule) {
		ParticuleDTO particuleDTO = new ParticuleDTO();
		particuleDTO.setId(particule.getId());
		particuleDTO.setKanjis(particule.getKanjis());
		particuleDTO.setSummary(particule.getSummary());
		particuleDTO.setFunction(particule.getParticuleFunction());
		particuleDTO.setHowToUse(particule.getHowToUse());
		particuleDTO.setExamples(particule.getExamples());
		particuleDTO.setVersion(particule.getVersion());
		return particuleDTO;
	}
	
	public static Particule map(ParticuleDTO particuleDTO) {
		Particule particule = new Particule();
		particule.setId(particuleDTO.getId());
		particule.setKanjis(particuleDTO.getKanjis());
		particule.setSummary(particuleDTO.getSummary());
		particule.setParticuleFunction(particuleDTO.getFunction());
		particule.setHowToUse(particuleDTO.getHowToUse());
		particule.setExamples(particuleDTO.getExamples());
		particule.setVersion(particuleDTO.getVersion());
		return particule;
	}

}
