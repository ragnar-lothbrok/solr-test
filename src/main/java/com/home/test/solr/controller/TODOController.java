package com.home.test.solr.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.test.solr.api.ITodoIndexService;
import com.home.test.solr.model.Todo;
import com.home.test.solr.model.TodoDocument;


@RestController
public class TODOController {

	protected static final String OBJECT_NAME_TODO = "todo";

	@Autowired
	private ITodoIndexService todoIndexService;

	@RequestMapping(value = "/api/todo", method = RequestMethod.POST)
	@ResponseBody
	public void add(@RequestBody Todo dto) {
		todoIndexService.addToIndex(
				TodoDocument.getBuilder(UUID.randomUUID().toString(), dto.getTitle(), dto.getDescription()).build());
	}

	@RequestMapping(value = "/api/todo/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteById(@PathVariable("id") String id) {
		todoIndexService.deleteFromIndex(id);
	}

	@RequestMapping(value = "/api/todo/search/{searchTerm}", method = RequestMethod.GET)
	@ResponseBody
	public List<TodoDocument> search(@PathVariable("searchTerm") String searchTerm) {

		return todoIndexService.findByQueryAnnotation(searchTerm);
	}

}
