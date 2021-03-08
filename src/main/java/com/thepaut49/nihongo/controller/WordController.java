package com.thepaut49.nihongo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thepaut49.nihongo.dto.ObjectDTO;
import com.thepaut49.nihongo.dto.WordCriteriaDTO;
import com.thepaut49.nihongo.dto.WordDTO;
import com.thepaut49.nihongo.mapper.ObjectDTOMapper;
import com.thepaut49.nihongo.mapper.WordToDTOMapper;
import com.thepaut49.nihongo.model.Word;
import com.thepaut49.nihongo.service.WordService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/words")
public class WordController {

	@Autowired
	private WordService wordService;

	@PostMapping("/create")
	public WordDTO createWord( @RequestBody WordDTO wordDTO) {
		Word newWord = WordToDTOMapper.map(wordDTO);
		return WordToDTOMapper.map(wordService.createWord(newWord));
	}

	@PutMapping("/{id}")
	public WordDTO updateWord( @RequestBody WordDTO wordDTO, @PathVariable Integer id) {
		Word updatedWord = WordToDTOMapper.map(wordDTO);  
		updatedWord.setId(id);
		return WordToDTOMapper.map(wordService.updateWord(updatedWord));
	}
	
	@PatchMapping("/{id}")
	public WordDTO updateWordNumberOfUse( @PathVariable Integer id) {
		return WordToDTOMapper.map(wordService.updateWordNumberOfUse(id));
	}


	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		wordService.delete(id);
		return "Word deleted !";
	}

	@GetMapping(value = "/{id}")
	public WordDTO findById( @PathVariable Integer id) {
		return WordToDTOMapper.map(wordService.findById(id));
	}
	
	@GetMapping(value = "/findByKanjis/{kanjis}")
	public WordDTO findByKanjis( @PathVariable String kanjis) {
		return WordToDTOMapper.map(wordService.findByKanjis(kanjis));
	}

	@GetMapping("/all")
	public List<WordDTO> getAllWords() {
		List<Word> words = wordService.findAll();
		return words
				.stream()
				.map(word -> WordToDTOMapper.map(word))
				.collect(Collectors.toList());
	}

	@GetMapping("/findWithCriteria")
	@ResponseBody
	public List<WordDTO> getAllWordsAccortingToCriteria( @RequestParam(required = false) String kanjis,@RequestParam(required = false) String pronunciation, @RequestParam(required = false) String meaning ) { 
		WordCriteriaDTO wordCriteriaDTO = new WordCriteriaDTO();
		wordCriteriaDTO.setKanjis(kanjis);
		wordCriteriaDTO.setPronunciation(pronunciation);
		wordCriteriaDTO.setMeaning(meaning);
		
		List<Word> words = wordService.findWithCriteria(wordCriteriaDTO);
		return words
				.stream()
				.map(lWord -> WordToDTOMapper.map(lWord))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping("/findMostUsedWords/{quantity}")
	public List<ObjectDTO> findMostUsedWords(@PathVariable Integer quantity) { 
		List<Word> words = wordService.findMostUsedWords(quantity);
		return words
				.stream()
				.map(word -> ObjectDTOMapper.map(word))
				.collect(Collectors.toList());
	}


}
