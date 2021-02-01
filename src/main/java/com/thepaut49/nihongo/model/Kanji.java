package com.thepaut49.nihongo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Kanji implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private char kanji;
	
	@Column(nullable = false)
	private String pronunciation;
	
	@Column(nullable = false)
	private String meaning;
	
	@Column(nullable = false)
	private Integer strokeNumber;
	
	private String radicals;
	
	@Version
	private int version;
	
	/*** getter /setter ***/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public char getKanji() {
		return kanji;
	}

	public void setKanji(char kanji) {
		this.kanji = kanji;
	}

	public String getPronunciation() {
		return pronunciation;
	}

	public void setPronunciation(String pronunciation) {
		this.pronunciation = pronunciation;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Integer getStrokeNumber() {
		return strokeNumber;
	}

	public void setStrokeNumber(Integer strokeNumber) {
		this.strokeNumber = strokeNumber;
	}

	public String getRadicals() {
		return radicals;
	}

	public void setRadicals(String radicals) {
		this.radicals = radicals;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	/*** overrided methods ***/

	@Override
	public int hashCode() {
		final int PRIME = 31;
        int hashcode = Character.valueOf(this.kanji).hashCode();
        return new HashCodeBuilder(hashcode%2==0?hashcode+1:hashcode, PRIME).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Kanji otherKanji = (Kanji) obj;
		if (this.kanji == otherKanji.getKanji()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "{ Id : " + this.id +" , Kanji : " + this.kanji + ", Pronunciation : " + this.pronunciation + " , Meaning : " + this.meaning +
				" , Strokes number : " + this.strokeNumber + ", Radicals : " + this.radicals + " }" ;
	}
	
	
	
}
