package com.thepaut49.nihongo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thepaut49.nihongo.model.Verb;

public interface VerbRepository extends JpaRepository<Verb, Integer> {

	boolean existsByNeutralForm(String neutralForm);

	Verb findByNeutralForm(String neutralForm);

	@Query("SELECT v FROM Verb v WHERE (:neutralForm is null or v.neutralForm LIKE  LOWER(concat('%', concat(:neutralForm, '%')))) "
			+ " and (:pronunciation is null or v.pronunciation LIKE  LOWER(concat('%', concat(:pronunciation, '%'))))"
			+ " and (:meaning is null or v.meaning LIKE  LOWER(concat('%', concat(:meaning, '%'))))"
			+ " and (:groupe is null or v.groupe LIKE  LOWER(concat('%', concat(:groupe, '%'))))")
	List<Verb> findWithCriteria(String neutralForm, String pronunciation, String meaning, String groupe);

	@Query(nativeQuery = true, value = "SELECT * FROM Verb v ORDER BY v.number_of_use DESC LIMIT :quantity ")
	List<Verb> findMostUsedVerbs(Integer quantity);

}
