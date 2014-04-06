package com.yangfan.xiang.test.jackson;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;

public class StreamTest {
	
	@Test
	public void testStream() throws Exception {
		
		JsonFactory jsonFactory = new JsonFactory();
		JsonParser parser = jsonFactory.createParser(StreamTest.class.getResourceAsStream("foo.json"));
		parser.close();
		
	}

}
