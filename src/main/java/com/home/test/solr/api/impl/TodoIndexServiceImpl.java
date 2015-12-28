package com.home.test.solr.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.test.solr.api.ITodoIndexService;
import com.home.test.solr.model.TodoDocument;
import com.home.test.solr.repository.TodoDocumentRepository;

@Service
public class TodoIndexServiceImpl implements ITodoIndexService {

	@Autowired
	TodoDocumentRepository todoDocumentRepository;

	@Transactional
	@Override
	public void addToIndex(TodoDocument todoEntry) {
		todoEntry = todoDocumentRepository.save(todoEntry);
	}

	@Override
	public void deleteFromIndex(String id) {
		todoDocumentRepository.delete(id);
	}

	@Override
	public List<TodoDocument> findByTitleContainsOrDescriptionContains(String title, String description) {
		return todoDocumentRepository.findByTitleContainsOrDescriptionContains(title, description);
	}

	@Override
	public List<TodoDocument> findByNamedQuery(String searchTerm) {
		return todoDocumentRepository.findByQueryAnnotation(searchTerm);
	}

	@Override
	public List<TodoDocument> findByQueryAnnotation(String searchTerm) {
		return todoDocumentRepository.findByQueryAnnotation(searchTerm);
	}

}
