package com.example.Language.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="langtable")
public class LangModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long langid;
	
	@NotNull(message="name should not be empty")
	@Column
	@Size(min=2, max=20, message="name should have min of 2 and max of 20")
	private String name;
	
	@NotNull(message="creator should not be empty")
	@Column
	@Size(min=2, max=20, message="creator should have min of 2 and max of 20")
	private String	creator;
	
	@NotNull(message="version should not be empty")
	@Column
	@Size(min=2, max=20, message="version should have min of 2 and max of 20")
	private String	version;
	
	public LangModel() {}

	public LangModel(
			@NotNull(message = "name should not be empty") @Size(min = 2, max = 20, message = "name should have min of 2 and max of 20") String name,
			@NotNull(message = "creator should not be empty") @Size(min = 2, max = 20, message = "creator should have min of 2 and max of 20") String creator,
			@NotNull(message = "version should not be empty") @Size(min = 2, max = 20, message = "version should have min of 2 and max of 20") String version) {
		super();
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

	public long getLangid() {
		return langid;
	}

	public void setLangid(long langid) {
		this.langid = langid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
}
