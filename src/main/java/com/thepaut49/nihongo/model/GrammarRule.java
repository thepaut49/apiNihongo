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
		return " GrammarRule : { Id : " + this.id +" , Title : " + this.title + " , Html description : " + this.htmlDescription + " , Version : " + this.version + " }" ;
	}

}
