package com.home.test.solr.api;

import java.util.List;

import com.home.test.solr.model.TodoDocument;

public interface ITodoIndexService {

	public void addToIndex(TodoDocument todoEntry);

	public void deleteFromIndex(String id);

	public List<TodoDocument> findByTitleContainsOrDescriptionContains(String title, String description);

	public List<TodoDocument> findByNamedQuery(String searchTerm);

	public List<TodoDocument> findByQueryAnnotation(String searchTerm);
}
