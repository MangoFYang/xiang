package com.yangfan.xiang.test.jackson;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StreamTest {
	
	@Test
	public void testStream() throws Exception {
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser parser = jsonFactory.createParser(
				StreamTest.class.getResourceAsStream("foo.json"));
		parser.close();
	}
	
	@Test
	public void testListType() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		List<Bar> readValue = mapper.readValue(
				StreamTest.class.getResourceAsStream("barArray.json"), new TypeReference<List<Bar>>() {});
		System.out.println(readValue);
	}

}
