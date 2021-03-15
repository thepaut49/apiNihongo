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
public class GrammarRule implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String htmlDescription;
	
	@Column(nullable = false)
	private String firstKeyWord;
	
	@Column
	private String secondKeyWord;
	
	@Column
	private String thirdKeyWord;
	
	@Column
	private String fourthKeyWord;
	
	@Version
	private int version;
	
	/*** getter-setter ***/
	
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
	
	/*** methods ***/
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int stringHashCode = this.title.hashCode();
        return new HashCodeBuilder(stringHashCode%2==0?stringHashCode+1:stringHashCode, PRIME).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		GrammarRule otherGrammarRule = (GrammarRule) obj;
		if (this.title.equals(otherGrammarRule.getTitle())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		return " GrammarRule : { Id : " + this.id +" , Title : " + this.title + " , Html description : " + this.htmlDescription + 
				" , First Key word : " + this.firstKeyWord + " , Second Key word : " + this.secondKeyWord + " , Third Key word : " + this.thirdKeyWord +
				" , Fourth Key word : " + this.fourthKeyWord +" , Version : " + this.version + " }" ;
	}

}
