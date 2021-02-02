package com.thepaut49.nihongo.mapper;

import java.util.HashSet;

import com.thepaut49.nihongo.dto.KanjiDTO;
import com.thepaut49.nihongo.model.Kanji;

public class KanjiToDTOMapper {
	
	public static KanjiDTO map(Kanji kanji) {
		KanjiDTO kanjiDTO = new KanjiDTO();
		kanjiDTO.setId(kanji.getId());
		kanjiDTO.setKanji(kanji.getKanji());
		kanjiDTO.setRadicals(kanji.getRadicals());
		kanjiDTO.setStrokeNumber(kanji.getStrokeNumber());
		kanjiDTO.setVersion(kanji.getVersion());
		kanjiDTO.setNumberOfUse(kanji.getNumberOfUse());
		
		kanjiDTO.setPronunciation(new HashSet<String>());
		String[] pronunciations = kanji.getPronunciation().split(";");
		for(int index = 0; index < pronunciations.length; index++) {
			kanjiDTO.getPronunciation().add(pronunciations[index].replace(";", ""));	
		}
		
		kanjiDTO.setMeaning(new HashSet<String>());
		String[] meanings = kanji.getMeaning().split(";");
		for(int index = 0; index < meanings.length; index++) {
			kanjiDTO.getMeaning().add(meanings[index].replace(";", ""));	
		}	
		return kanjiDTO;
	}
	
	public static Kanji map(KanjiDTO kanjiDTO) {
		Kanji kanji = new Kanji();
		kanji.setId(kanjiDTO.getId());
		kanji.setKanji(kanjiDTO.getKanji());
		kanji.setRadicals(kanjiDTO.getRadicals());
		kanji.setStrokeNumber(kanjiDTO.getStrokeNumber());
		kanji.setVersion(kanjiDTO.getVersion());
		kanji.setNumberOfUse(kanjiDTO.getNumberOfUse());
		
		String pronunciationTemp = "";
		for(String pronunciation : kanjiDTO.getPronunciation()) {
			pronunciationTemp += pronunciation + ";";	
		}
		kanji.setPronunciation(pronunciationTemp);
		
		String meaningTemp = "";
		for(String meaning : kanjiDTO.getMeaning()) {
			meaningTemp += meaning + ";";	
		}
		kanji.setMeaning(meaningTemp);	
		return kanji;
	}

}
