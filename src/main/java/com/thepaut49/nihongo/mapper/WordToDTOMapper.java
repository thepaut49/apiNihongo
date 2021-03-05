package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.WordDTO;
import com.thepaut49.nihongo.model.Word;

public class WordToDTOMapper {
	
	public static WordDTO map(Word word) {
		WordDTO wordDTO = new WordDTO();
		wordDTO.setId(word.getId());
		wordDTO.setKanjis(word.getKanjis());
		wordDTO.setVersion(word.getVersion());
		wordDTO.setNumberOfUse(word.getNumberOfUse());
		wordDTO.setPronunciation(new HashSet<String>());
		String[] pronunciations = word.getPronunciation().split(";");
		for(int index = 0; index < pronunciations.length; index++) {
			wordDTO.getPronunciation().add(pronunciations[index].replace(";", ""));	
		}
		wordDTO.setMeaning(new HashSet<String>());
		String[] meanings = word.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			wordDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}
		return wordDTO;
	}
	
	public static Word map(WordDTO wordDTO) {
		Word word = new Word();
		word.setId(wordDTO.getId());
		word.setKanjis(wordDTO.getKanjis());
		word.setVersion(wordDTO.getVersion());
		word.setNumberOfUse(wordDTO.getNumberOfUse());
		String pronunciationTemp = "";
		for(String pronunciation : wordDTO.getPronunciation()) {
			pronunciationTemp += pronunciation + ";";	
		}
		word.setPronunciation(pronunciationTemp);
		String meaningTemp = "";
		for(String meaning : wordDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		word.setMeaning(meaningTemp);	
		return word;
	}

}
