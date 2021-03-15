package com.thepaut49.nihongo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Particule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 5)
	private String kanjis;
	
	@Column(nullable = false)
	private String summary;

	@Column
	private String particuleFunction;
	
	@Column
	private String howToUse;
	
	@Lob
	@Column(nullable = false)
	private String examples;
	
	@Version
	private int version;
	
	/*** getter-setter ***/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getKanjis() {
		return kanjis;
	}

	public void setKanjis(String kanjis) {
		this.kanjis = kanjis;
	}
	
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getParticuleFunction() {
		return particuleFunction;
	}

	public void setParticuleFunction(String function) {
		this.particuleFunction = function;
	}

	public String getHowToUse() {
		return howToUse;
	}

	public void setHowToUse(String howToUse) {
		this.howToUse = howToUse;
	}
	
	public String getExamples() {
		return examples;
	}

	public void setExamples(String examples) {
		this.examples = examples;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	/*** methods ***/
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int stringHashCode = this.kanjis.hashCode();
        return new HashCodeBuilder(stringHashCode%2==0?stringHashCode+1:stringHashCode, PRIME).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Particule otherParticule = (Particule) obj;
		if (this.kanjis.equals(otherParticule.getKanjis())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return " Particule : { Id : " + this.id + " , Kanjis : " + this.kanjis + " , Summary : " + this.summary +
				" , Function : " + this.particuleFunction + " , How to use : " + this.howToUse  + " , Version : " + this.version + " }" ;
	}

}
