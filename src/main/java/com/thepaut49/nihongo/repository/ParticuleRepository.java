package com.thepaut49.nihongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thepaut49.nihongo.model.Particule;

public interface ParticuleRepository extends JpaRepository<Particule, Integer> {

	boolean existsByKanjis(String kanjis);

	Particule findByKanjis(String kanjis);

}
