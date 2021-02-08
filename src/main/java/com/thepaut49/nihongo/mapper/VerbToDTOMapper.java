package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.VerbDTO;
import com.thepaut49.nihongo.model.Verb;

public class VerbToDTOMapper {
	
	public static VerbDTO map(Verb verb) {
		VerbDTO verbDTO = new VerbDTO();
		verbDTO.setId(verb.getId());
		verbDTO.setNeutralForm(verb.getNeutralForm());
		verbDTO.setGroupe(verb.getGroupe());
		verbDTO.setVersion(verb.getVersion());
		verbDTO.setNumberOfUse(verb.getNumberOfUse());
		verbDTO.setPronunciation(verb.getPronunciation());
		verbDTO.setMeaning(new HashSet<String>());
		String[] meanings = verb.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			verbDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}
		return verbDTO;
	}
	
	public static Verb map(VerbDTO verbDTO) {
		Verb verb = new Verb();
		verb.setId(verbDTO.getId());
		verb.setNeutralForm(verbDTO.getNeutralForm());
		verb.setGroupe(verbDTO.getGroupe());
		verb.setVersion(verbDTO.getVersion());
		verb.setNumberOfUse(verbDTO.getNumberOfUse());
		verb.setPronunciation(verbDTO.getPronunciation());
		String meaningTemp = "";
		for(String meaning : verbDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		verb.setMeaning(meaningTemp);	
		return verb;
	}

}
