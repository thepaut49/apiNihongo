package com.thepaut49.nihongo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thepaut49.nihongo.model.Kanji;

public interface KanjiRepository extends JpaRepository<Kanji, Integer> {

	boolean existsByKanji(char kanji);

	Kanji findByKanji(char kanji);

	List<Kanji> findByPronunciationIgnoreCaseLike(String pronunciation);

	List<Kanji> findByStrokeNumber(Integer strokeNumber);

	List<Kanji> findByMeaningIgnoreCaseLike(String meaning);

	@Query("SELECT k FROM Kanji k WHERE (:kanji is null or k.kanji = :kanji) "
			+ " and (:pronunciation is null or k.pronunciation LIKE  LOWER(concat('%', concat(:pronunciation, '%'))))"
			+ " and (:meaning is null or k.meaning LIKE  LOWER(concat('%', concat(:meaning, '%'))))"
			+ " and (:radicals is null or k.radicals LIKE  LOWER(concat('%', concat(:radicals, '%'))))"
			+ " and (:strokeNumber is null or k.strokeNumber = :strokeNumber)"
			+ " and (:minStrokeNumber is null or k.strokeNumber >= :minStrokeNumber)"
			+ " and (:maxStrokeNumber is null or k.strokeNumber <= :maxStrokeNumber)")
	List<Kanji> findWithCriteria(Character kanji, String pronunciation, String meaning, String radicals, Integer strokeNumber, Integer minStrokeNumber, Integer maxStrokeNumber);
	
	
	List<Kanji> findByKanjiIn(List<Character> characters);

	@Query(nativeQuery = true, value = "SELECT * FROM Kanji k ORDER BY k.number_of_use DESC LIMIT :quantity ")
	List<Kanji> findMostUsedKanji(Integer quantity);

}
