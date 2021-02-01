package com.thepaut49.nihongo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thepaut49.nihongo.model.Kanji;

public interface KanjiRepository extends JpaRepository<Kanji, Integer> {
	
	boolean existsByKanji(char kanji);

	Kanji findByKanji(char kanji);
	
	//@Query("SELECT * FROM Kanji k WHERE lower(k.pronunciation) like lower(%:pronunciation%) ORDER BY k.strokeNumber")
	//List<Kanji> findByPrononciation(@Param("pronunciation")String pronunciation);
	
	List<Kanji> findByStrokeNumber(Integer strokeNumber);
	
	//@Query("SELECT * FROM Kanji k WHERE lower(k.meaning) like lower(%:meaning%) ORDER BY k.strokeNumber")
	//List<Kanji> findByMeaning(@Param("meaning")String meaning);

}
