package com.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

import org.apache.lucene.analysis.util.CharArraySet;
import org.apache.lucene.analysis.util.WordlistLoader;
import org.apache.lucene.util.IOUtils;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.LBHttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.DefaultQueryParser;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.FilterQuery;

@Configuration
public class SolrConfiguration {

	@Value("${spring.data.solr.host}")
	private String solrUrl;

	@Value("${stop.words.file.path}")
	private String stopWordsFilePath;

	@Bean
	public SolrServer solrServer() throws MalformedURLException {
		SolrServer server = new LBHttpSolrServer(solrUrl.split(","));
		return server;
	}

	@Bean
	public SolrTemplate solrTemplate() throws MalformedURLException {
		SolrTemplate solrTemplate = new SolrTemplate(solrServer());
		solrTemplate.registerQueryParser(FilterQuery.class, new DefaultQueryParser());
		return solrTemplate;
	}

	@SuppressWarnings("unused")
	private CharArraySet getStopWordsSet() throws IOException {
		Reader reader = null;
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(stopWordsFilePath),
					StandardCharsets.UTF_8);
			return WordlistLoader.getWordSet(inputStreamReader, new CharArraySet(16, true));
		} finally {
			IOUtils.close(reader);
		}
	}

}
