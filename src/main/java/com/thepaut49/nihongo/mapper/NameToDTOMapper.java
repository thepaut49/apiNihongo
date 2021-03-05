package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.NameDTO;
import com.thepaut49.nihongo.model.Name;

public class NameToDTOMapper {
	
	public static NameDTO map(Name name) {
		NameDTO nameDTO = new NameDTO();
		nameDTO.setId(name.getId());
		nameDTO.setKanjis(name.getKanjis());
		nameDTO.setVersion(name.getVersion());
		nameDTO.setNumberOfUse(name.getNumberOfUse());
		nameDTO.setPronunciation(new HashSet<String>());
		String[] pronunciations = name.getPronunciation().split(";");
		for(int index = 0; index < pronunciations.length; index++) {
			nameDTO.getPronunciation().add(pronunciations[index].replace(";", ""));	
		}
		nameDTO.setMeaning(new HashSet<String>());
		String[] meanings = name.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			nameDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}
		return nameDTO;
	}
	
	public static Name map(NameDTO nameDTO) {
		Name name = new Name();
		name.setId(nameDTO.getId());
		name.setKanjis(nameDTO.getKanjis());
		name.setVersion(nameDTO.getVersion());
		name.setNumberOfUse(nameDTO.getNumberOfUse());
		String pronunciationTemp = "";
		for(String pronunciation : nameDTO.getPronunciation()) {
			pronunciationTemp += pronunciation + ";";	
		}
		name.setPronunciation(pronunciationTemp);
		String meaningTemp = "";
		for(String meaning : nameDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		name.setMeaning(meaningTemp);	
		return name;
	}

}
