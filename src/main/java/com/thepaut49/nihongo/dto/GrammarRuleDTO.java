package com.thepaut49.nihongo.dto;


public class GrammarRuleDTO {

	private Integer id;

	private String title;

	private String htmlDescription;

	private String firstKeyWord;

	private String secondKeyWord;

	private String thirdKeyWord;

	private String fourthKeyWord;

	private int version;

	/*** getter / setter ***/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public String getFirstKeyWord() {
		return firstKeyWord;
	}

	public void setFirstKeyWord(String firstKeyWord) {
		this.firstKeyWord = firstKeyWord;
	}

	public String getSecondKeyWord() {
		return secondKeyWord;
	}

	public void setSecondKeyWord(String secondKeyWord) {
		this.secondKeyWord = secondKeyWord;
	}

	public String getThirdKeyWord() {
		return thirdKeyWord;
	}

	public void setThirdKeyWord(String thirdKeyWord) {
		this.thirdKeyWord = thirdKeyWord;
	}

	public String getFourthKeyWord() {
		return fourthKeyWord;
	}

	public void setFourthKeyWord(String fourthKeyWord) {
		this.fourthKeyWord = fourthKeyWord;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
