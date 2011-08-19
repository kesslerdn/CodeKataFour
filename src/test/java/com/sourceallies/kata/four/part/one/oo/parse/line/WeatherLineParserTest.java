package com.sourceallies.kata.four.part.one.oo.parse.line;

import static org.junit.Assert.*;

import org.junit.Test;


public class WeatherLineParserTest {
	
	private String line = "   1  88*   59*   74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
	
	@Test
	public void testParseDay(){
		int day = new WeatherLineParser().parseDay(line);
		assertEquals(1, day);
	}
	
	@Test
	public void testParseMaxTemp(){
		int maxTemp = new WeatherLineParser().parseMaxTemp(line);
		assertEquals(88, maxTemp);
	}
	
	@Test
	public void testParseMinTemp(){
		int minTemp = new WeatherLineParser().parseMinTemp(line);
		assertEquals(59, minTemp);
	}
	
}
