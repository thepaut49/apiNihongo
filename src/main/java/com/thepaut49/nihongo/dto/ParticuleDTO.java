package com.thepaut49.nihongo.dto;

public class ParticuleDTO {
	
	private Integer id;
	private String kanjis;
	private String summary;
	private String function;
	private String howToUse;
	private String examples;
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

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
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

}
