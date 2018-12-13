package com.rumberomelo.alarm;

public class Alarm {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String language;
	
	public Alarm() {}

	public Alarm(Integer i, String string, String string2, String string3) {
		id = i;
		name = string3;
		
		description = string2;
		
		language = string;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


}
