package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.IAdjectiveDTO;
import com.thepaut49.nihongo.model.IAdjective;

public class IAdjectiveToDTOMapper {
	
	public static IAdjectiveDTO map(IAdjective iAdjective) {
		IAdjectiveDTO iAdjectiveDTO = new IAdjectiveDTO();
		iAdjectiveDTO.setId(iAdjective.getId());
		iAdjectiveDTO.setKanjis(iAdjective.getKanjis());
		iAdjectiveDTO.setVersion(iAdjective.getVersion());
		iAdjectiveDTO.setNumberOfUse(iAdjective.getNumberOfUse());
		iAdjectiveDTO.setPronunciation(iAdjective.getPronunciation());
		iAdjectiveDTO.setMeaning(new HashSet<String>());
		String[] meanings = iAdjective.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			iAdjectiveDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}
		return iAdjectiveDTO;
	}
	
	public static IAdjective map(IAdjectiveDTO iAdjectiveDTO) {
		IAdjective iAdjective = new IAdjective();
		iAdjective.setId(iAdjectiveDTO.getId());
		iAdjective.setKanjis(iAdjectiveDTO.getKanjis());
		iAdjective.setVersion(iAdjectiveDTO.getVersion());
		iAdjective.setNumberOfUse(iAdjectiveDTO.getNumberOfUse());
		iAdjective.setPronunciation(iAdjectiveDTO.getPronunciation());
		String meaningTemp = "";
		for(String meaning : iAdjectiveDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		iAdjective.setMeaning(meaningTemp);	
		return iAdjective;
	}

}
