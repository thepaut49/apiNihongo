package com.thepaut49.nihongo.dto;

public class VerbCriteriaDTO {
	
	private String neutralForm;
	
	private String pronunciation;
	
	private String meaning;
	
	private String groupe;
	
	/*** getter / setter ***/

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
}
