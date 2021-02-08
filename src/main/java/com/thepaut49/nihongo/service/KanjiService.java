package com.thepaut49.nihongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.thepaut49.nihongo.dto.KanjiCriteriaDTO;
import com.thepaut49.nihongo.exception.ResourceAlreadyExistException;
import com.thepaut49.nihongo.model.Kanji;
import com.thepaut49.nihongo.repository.KanjiRepository;
import com.thepaut49.nihongo.utils.StringUtils;

@Service
public class KanjiService {
	
	@Autowired
	private KanjiRepository kanjiRepository;
	
	public Kanji createKanji(Kanji newKanji) {
		if (!kanjiRepository.existsByKanji(newKanji.getKanji())) {
			newKanji.setNumberOfUse(1);
			return kanjiRepository.save(newKanji);
		}
		else {
			throw new ResourceAlreadyExistException("Kanji " + newKanji.getKanji() + " already exist !");
		}
	}
	
	public Kanji updateKanji(Kanji kanji) {
		if (kanji != null) {
			return kanjiRepository.save(kanji);
		}
		else {
			return null;
		}
	}

	public void delete(Integer id) {
		Optional<Kanji> kanji = kanjiRepository.findById(id);
		if (!kanji.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Kanji with id : " + id );
		}
		kanjiRepository.deleteById(id);
	}

	public Kanji search(Integer id) {
		Optional<Kanji> kanji = kanjiRepository.findById(id);
		if (!kanji.isPresent()) {
			throw new ResourceNotFoundException("Could not found the Kanji with id : " + id );
		}
		return kanji.get();
	}
	
	public List<Kanji> findAll() {
		return kanjiRepository.findAll();
	}
	
	public List<Kanji> findWithCriteria(KanjiCriteriaDTO criteria) {
		Character kanji = criteria.getKanji();
		String meaning = criteria.getMeaning();
		String pronunciation = criteria.getPronunciation();
		String radicals = criteria.getRadicals();
		Integer strokeNumber = criteria.getStrokeNumber();
		Integer minStrokeNumber = criteria.getMinStrokeNumber();
		Integer maxStrokeNumber = criteria.getMaxStrokeNumber();	
		return kanjiRepository.findWithCriteria(kanji, pronunciation, meaning, radicals, strokeNumber, minStrokeNumber, maxStrokeNumber);
	}
	
	public List<Kanji> listOfKanjiContainedinSentence(String sentence) {
		return kanjiRepository.findByKanjiIn(StringUtils.convertStringToCharList(sentence));
	}

	public Kanji updateKanjiNumberOfUse(Integer id) {
		Kanji kanji = kanjiRepository.findById(id).get();
		kanji.setNumberOfUse(kanji.getNumberOfUse() + 1);
		return kanjiRepository.save(kanji);
	}

	public List<Kanji> findMostUsedKanji(Integer quantity) {
		return kanjiRepository.findMostUsedKanji(quantity);
	}

	public Kanji findByKanji(String kanji) {
		return kanjiRepository.findByKanji( kanji.charAt(0));
	}

}
