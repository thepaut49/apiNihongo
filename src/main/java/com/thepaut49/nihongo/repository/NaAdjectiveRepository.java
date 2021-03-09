package com.thepaut49.nihongo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thepaut49.nihongo.model.NaAdjective;

public interface NaAdjectiveRepository extends JpaRepository<NaAdjective, Integer> {

	boolean existsByKanjis(String kanjis);

	NaAdjective findByKanjis(String kanjis);

	@Query("SELECT v FROM NaAdjective v WHERE (:kanjis is null or v.kanjis LIKE  LOWER(concat('%', concat(:kanjis, '%')))) "
			+ " and (:pronunciation is null or v.pronunciation LIKE  LOWER(concat('%', concat(:pronunciation, '%'))))"
			+ " and (:meaning is null or v.meaning LIKE  LOWER(concat('%', concat(:meaning, '%'))))")
	List<NaAdjective> findWithCriteria(String kanjis, String pronunciation, String meaning);

	@Query(nativeQuery = true, value = "SELECT * FROM na_adjective v ORDER BY v.number_of_use DESC LIMIT :quantity ")
	List<NaAdjective> findMostUsedNaAdjectives(Integer quantity);

}
