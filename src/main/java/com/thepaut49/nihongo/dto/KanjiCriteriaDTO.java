package com.thepaut49.nihongo.dto;

public class KanjiCriteriaDTO {
	
	private Integer id;

	private Character kanji;

	private String pronunciation;

	private String meaning;

	private Integer strokeNumber;
	
	private Integer minStrokeNumber;
	
	private Integer maxStrokeNumber;

	private String radicals;

	/*** getter / setter ***/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getKanji() {
		return kanji;
	}

	public void setKanji(Character kanji) {
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

	public Integer getMinStrokeNumber() {
		return minStrokeNumber;
	}

	public void setMinStrokeNumber(Integer minStrokeNumber) {
		this.minStrokeNumber = minStrokeNumber;
	}

	public Integer getMaxStrokeNumber() {
		return maxStrokeNumber;
	}

	public void setMaxStrokeNumber(Integer maxStrokeNumber) {
		this.maxStrokeNumber = maxStrokeNumber;
	}

	public String getRadicals() {
		return radicals;
	}

	public void setRadicals(String radicals) {
		this.radicals = radicals;
	}	

}
