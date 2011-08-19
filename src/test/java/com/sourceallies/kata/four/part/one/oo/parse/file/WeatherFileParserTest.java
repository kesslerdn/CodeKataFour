package com.sourceallies.kata.four.part.one.oo.parse.file;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import com.sourceallies.kata.four.part.one.oo.Weather;
import com.sourceallies.kata.four.part.one.oo.file.util.ClasspathFileUtil;
import com.sourceallies.kata.four.part.one.oo.parse.line.WeatherLineParser;

@RunWith(MockitoJUnitRunner.class)
public class WeatherFileParserTest {
	
	@InjectMocks private WeatherFileParser parser = new WeatherFileParser();
	@Mock private ClasspathFileUtil classpathFileUtil;
	@Mock private WeatherLineParser weatherLineParser;
	
	private List<String> lines;
	private String testFilename = "testFilename";
	
	private int firstDay = 1;
	private int secondDay = 2;	
	
	private int firstMinTemp = 10;
	private int secondMinTemp = 20;	
	
	private int firstMaxTemp = 100;
	private int secondMaxTemp = 200;	
	
	@Before
	public void setUp(){
		lines = new ArrayList<String>();
		lines.add("HEADER A");
		lines.add("HEADER B");
		lines.add("");
		lines.add("HEADER C");
		lines.add("HEADER D");
		lines.add("");
		lines.add("HEADER E");
		lines.add("");
		lines.add("A");
		lines.add("B");
		lines.add("FOOTER A");
		lines.add("FOOTER B");
		
		when(classpathFileUtil.extractLines(testFilename)).thenReturn(lines);
		

		when (weatherLineParser.parseDay("A")).thenReturn(firstDay);
		when (weatherLineParser.parseDay("B")).thenReturn(secondDay);
		
		when (weatherLineParser.parseMinTemp("A")).thenReturn(firstMinTemp);
		when (weatherLineParser.parseMinTemp("B")).thenReturn(secondMinTemp);
		
		when (weatherLineParser.parseMaxTemp("A")).thenReturn(firstMaxTemp);
		when (weatherLineParser.parseMaxTemp("B")).thenReturn(secondMaxTemp);
		
	}
	
	@Test
	public void testParse(){
		List<Weather> weatherList = parser.parse(testFilename);
		
		assertEquals(2, weatherList.size());
		
		assertEquals(firstDay, weatherList.get(0).getDay());
		assertEquals(secondDay, weatherList.get(1).getDay());
		
		assertEquals(firstMinTemp, weatherList.get(0).getMinTemp());
		assertEquals(secondMinTemp, weatherList.get(1).getMinTemp());
		
		assertEquals(firstMaxTemp, weatherList.get(0).getMaxTemp());
		assertEquals(secondMaxTemp, weatherList.get(1).getMaxTemp());
	}

}
