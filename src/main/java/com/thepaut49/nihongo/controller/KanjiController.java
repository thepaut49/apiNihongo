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

import com.thepaut49.nihongo.dto.KanjiCriteriaDTO;
import com.thepaut49.nihongo.dto.KanjiDTO;
import com.thepaut49.nihongo.dto.ObjectDTO;
import com.thepaut49.nihongo.mapper.KanjiToDTOMapper;
import com.thepaut49.nihongo.mapper.ObjectDTOMapper;
import com.thepaut49.nihongo.model.Kanji;
import com.thepaut49.nihongo.service.KanjiService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/kanjis")
public class KanjiController {

	@Autowired
	private KanjiService kanjiService;

	@PostMapping("/create")
	public KanjiDTO createKanji( @RequestBody KanjiDTO kanjiDTO) {
		Kanji newKanji = KanjiToDTOMapper.map(kanjiDTO);
		return KanjiToDTOMapper.map(kanjiService.createKanji(newKanji));
	}

	@PutMapping("/{id}")
	public KanjiDTO updateKanji( @RequestBody KanjiDTO kanjiDTO, @PathVariable Integer id) {
		Kanji updatedKanji = KanjiToDTOMapper.map(kanjiDTO);  
		updatedKanji.setId(id);
		return KanjiToDTOMapper.map(kanjiService.updateKanji(updatedKanji));
	}
	
	@PatchMapping("/{id}")
	public KanjiDTO updateKanjiNumberOfUse( @PathVariable Integer id) {
		return KanjiToDTOMapper.map(kanjiService.updateKanjiNumberOfUse(id));
	}


	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable Integer id) {
		kanjiService.delete(id);
		return "Kanji deleted !";
	}

	@GetMapping(value = "/{id}")
	public KanjiDTO search( @PathVariable Integer id) {
		return KanjiToDTOMapper.map(kanjiService.search(id));
	}
	
	@GetMapping(value = "/findByKanji/{kanji}")
	public KanjiDTO findWithKanji( @PathVariable String kanji) {
		return KanjiToDTOMapper.map(kanjiService.findByKanji(kanji));
	}

	@GetMapping("/all")
	public List<KanjiDTO> getAllKanjis() {
		List<Kanji> kanjis = kanjiService.findAll();
		return kanjis
				.stream()
				.map(kanji -> KanjiToDTOMapper.map(kanji))
				.collect(Collectors.toList());
	}

	@GetMapping("/findWithCriteria")
	@ResponseBody
	public List<KanjiDTO> getAllKanjisAccortingToCriteria( @RequestParam(required = false) Character kanji,@RequestParam(required = false) String pronunciation, @RequestParam(required = false) String meaning,
			@RequestParam(required = false) Integer strokeNumber,@RequestParam(required = false) Integer minStrokeNumber, @RequestParam(required = false) Integer maxStrokeNumber, @RequestParam(required = false) String radicals ) { 
		KanjiCriteriaDTO kanjiCriteriaDTO = new KanjiCriteriaDTO();
		kanjiCriteriaDTO.setKanji(kanji);
		kanjiCriteriaDTO.setPronunciation(pronunciation);
		kanjiCriteriaDTO.setMeaning(meaning);
		kanjiCriteriaDTO.setStrokeNumber(strokeNumber);
		kanjiCriteriaDTO.setMinStrokeNumber(minStrokeNumber);
		kanjiCriteriaDTO.setMaxStrokeNumber(maxStrokeNumber);
		kanjiCriteriaDTO.setRadicals(radicals);
		
		List<Kanji> kanjis = kanjiService.findWithCriteria(kanjiCriteriaDTO);
		return kanjis
				.stream()
				.map(lKanji -> KanjiToDTOMapper.map(lKanji))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/findKanjiInSentence")
	public List<KanjiDTO> findKanjiInSentence(@RequestBody String sentence) { 
		List<Kanji> kanjis = kanjiService.listOfKanjiContainedinSentence(sentence);
		return kanjis
				.stream()
				.map(kanji -> KanjiToDTOMapper.map(kanji))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/findMostUsedKanji/{quantity}")
	public List<ObjectDTO> findMostUsedKanji(@PathVariable Integer quantity) { 
		List<Kanji> kanjis = kanjiService.findMostUsedKanji(quantity);
		return kanjis
				.stream()
				.map(kanji -> ObjectDTOMapper.map(kanji))
				.collect(Collectors.toList());
	}


}
