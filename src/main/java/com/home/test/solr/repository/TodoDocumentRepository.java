package com.home.test.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.home.test.solr.model.TodoDocument;

@Repository
public interface TodoDocumentRepository extends SolrCrudRepository<TodoDocument, String> {

	public List<TodoDocument> findByTitleContainsOrDescriptionContains(String title, String description);

	@Query("title:*?0* OR description:*?0*")
	public List<TodoDocument> findByQueryAnnotation(String searchTerm);
}
