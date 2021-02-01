package com.thepaut49.nihongo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Verb implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String kanjis;
	
	@Column(nullable = false)
	private String pronunciation;
	
	@Column(nullable = false)
	private String meaning;
	
	@Column(nullable = false)
	private String presentPos;
	
	@Column(nullable = false)
	private String presentPosNeutral;
	
	@Column(nullable = false)
	private String presentNeg;
	
	@Column(nullable = false)
	private String presentNegNeutral;
	
	@Column(nullable = false)
	private String pastPos;
	
	@Column(nullable = false)
	private String pastPosNeutral;
	
	@Column(nullable = false)
	private String pastNeg;
	
	@Column(nullable = false)
	private String pastNegNeutral;
	
	@Column(nullable = false)
	private String group;
	
	

}
