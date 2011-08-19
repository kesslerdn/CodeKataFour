package com.sourceallies.kata.four.part.one.oo.file.util;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;



public class ClasspathFileUtilTest {

	@Test
	@SuppressWarnings("unchecked")
	public void testExtractLines() throws IOException{
		
		List<String> lines = new ClasspathFileUtil().extractLines("weather.dat");
		
		URL resource = this.getClass().getClassLoader().getResource("weather.dat");
		File file = FileUtils.toFile(resource);
		List<String> expectedLines = FileUtils.readLines(file);
		
		assertEquals(expectedLines, lines);
	}
}
