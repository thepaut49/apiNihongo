package com.thepaut49.nihongo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thepaut49.nihongo.dto.KanjiDTO;
import com.thepaut49.nihongo.mapper.KanjiToDTOMapper;
import com.thepaut49.nihongo.model.Kanji;
import com.thepaut49.nihongo.service.KanjiService;

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


	  @DeleteMapping(value = "/{id}")
	  public String delete(@PathVariable Integer id) {
	    kanjiService.delete(id);
	    return "Kanji deleted !";
	  }

	  @GetMapping(value = "/{id}")
	  public KanjiDTO search( @PathVariable Integer id) {
	    return KanjiToDTOMapper.map(kanjiService.search(id));
	  }

	  @GetMapping("/all")
	  public List<KanjiDTO> getAllKanjis() {
		  List<Kanji> kanjis = kanjiService.findAll();
		  return kanjis
				  .stream()
				  .map(kanji -> KanjiToDTOMapper.map(kanji))
				  .collect(Collectors.toList());
	  }

}
