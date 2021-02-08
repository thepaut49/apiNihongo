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
public class Verb implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true, length = 25)
	private String neutralForm;
	
	@Column(nullable = false, length = 50)
	private String pronunciation;
	
	@Column(nullable = false, length = 255)
	private String meaning;
	
	@Column(nullable = false, length = 25)
	private String groupe;
	
	private Integer numberOfUse;
	
	@Version
	private int version;
	
	/*** getter / setter ***/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNeutralForm() {
		return neutralForm;
	}

	public void setNeutralForm(String neutralForm) {
		this.neutralForm = neutralForm;
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

	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
	
	public Integer getNumberOfUse() {
		return numberOfUse;
	}

	public void setNumberOfUse(Integer numberOfUse) {
		this.numberOfUse = numberOfUse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
		
	/*** override methods ***/
	
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int stringHashCode = this.neutralForm.hashCode();
        return new HashCodeBuilder(stringHashCode%2==0?stringHashCode+1:stringHashCode, PRIME).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Verb otherVerb = (Verb) obj;
		if (this.neutralForm.equals(otherVerb.getNeutralForm())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return " Verb : { Id : " + this.id +" , Neutral form : " + this.neutralForm + ", Pronunciation : " + this.pronunciation + " , Meaning : " + this.meaning +
				" , Group : " + this.groupe  + " , Number of use : " + this.numberOfUse  + " , version : " + this.version + " }" ;
	}
	
}
