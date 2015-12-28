package com.home.test.solr.model;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;

public class TodoDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIELD_DESCRIPTION = "description";
	public static final String FIELD_ID = "id";
	public static final String FIELD_TITLE = "title";

	@Id
	@Field
	private String id;

	@Field
	private String description;

	@Field
	private String title;

	public TodoDocument() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static Builder getBuilder(String id, String title, String description) {
		return new Builder(id, title, description);
	}

	// Getters are omitted

	public static class Builder {
		private TodoDocument build;

		public Builder(String id, String title, String description) {
			build = new TodoDocument();
			build.id = id.toString();
			build.title = title;
			build.description = description;
		}

		public Builder description(String description) {
			build.description = description;
			return this;
		}

		public TodoDocument build() {
			return build;
		}
	}

	@Override
	public String toString() {
		return "TodoDocument [id=" + id + ", description=" + description + ", title=" + title + "]";
	}

}
