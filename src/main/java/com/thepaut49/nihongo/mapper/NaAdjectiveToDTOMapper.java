package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.NaAdjectiveDTO;
import com.thepaut49.nihongo.model.NaAdjective;

public class NaAdjectiveToDTOMapper {
	
	public static NaAdjectiveDTO map(NaAdjective naAdjective) {
		NaAdjectiveDTO naAdjectiveDTO = new NaAdjectiveDTO();
		naAdjectiveDTO.setId(naAdjective.getId());
		naAdjectiveDTO.setKanjis(naAdjective.getKanjis());
		naAdjectiveDTO.setVersion(naAdjective.getVersion());
		naAdjectiveDTO.setNumberOfUse(naAdjective.getNumberOfUse());
		naAdjectiveDTO.setPronunciation(naAdjective.getPronunciation());
		naAdjectiveDTO.setMeaning(new HashSet<String>());
		String[] meanings = naAdjective.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			naAdjectiveDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}
		return naAdjectiveDTO;
	}
	
	public static NaAdjective map(NaAdjectiveDTO naAdjectiveDTO) {
		NaAdjective naAdjective = new NaAdjective();
		naAdjective.setId(naAdjectiveDTO.getId());
		naAdjective.setKanjis(naAdjectiveDTO.getKanjis());
		naAdjective.setVersion(naAdjectiveDTO.getVersion());
		naAdjective.setNumberOfUse(naAdjectiveDTO.getNumberOfUse());
		naAdjective.setPronunciation(naAdjectiveDTO.getPronunciation());
		String meaningTemp = "";
		for(String meaning : naAdjectiveDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		naAdjective.setMeaning(meaningTemp);	
		return naAdjective;
	}

}
