package edu.unsw.comp9321;

public class ResultBean {

	private int id;
	private String contributor;
	private String coverage;
	private String creator;
	private String date;
	private String description;
	private String format;
	private String identifier;
	private String language;
	private String publisher;
	private String relation;
	private String rights;
	private String source;
	private String subject;
	private String title;
	private String type;
	
	public ResultBean(int aId, String aContributor, String aCoverage, String aCreator, String aDate, String aDescription, String aFormat, String aIdentifier, String aLanguage, String aPublisher, String aRelation, String aRights, String aSource, String aSubject, String aTitle, String aType){
		
		this.id = aId;
		this.contributor = aContributor;
		this.coverage = aCoverage;
		this.creator = aCreator;
		this.date = aDate;
		this.description = aDescription;
		this.format = aFormat;
		this.identifier = aIdentifier;
		this.language = aLanguage;
		this.publisher = aPublisher;
		this.relation = aRelation;
		this.rights = aRights;
		this.source = aSource;
		this.subject = aSubject;
		this.title = aTitle;
		this.type = aType;

	}

	public ResultBean() {
		this.contributor = "";
		this.coverage = "";
		this.creator = "";
		this.date = "";
		this.description = "";
		this.format = "";
		this.identifier = "";
		this.language = "";
		this.publisher = "";
		this.relation = "";
		this.rights = "";
		this.source = "";
		this.subject = "";
		this.title = "";
		this.type = "";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

	
	
	
}
