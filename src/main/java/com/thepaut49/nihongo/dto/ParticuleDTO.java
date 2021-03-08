package com.thepaut49.nihongo.dto;

public class ParticuleDTO {

	private Integer id;
	
	private String kanjis;
	
	private String htmlDescription;
		
	private int version;
	
	/*** getter / setter ***/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKanjis() {
		return kanjis;
	}

	public void setKanjis(String neutralForm) {
		this.kanjis = neutralForm;
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
}
