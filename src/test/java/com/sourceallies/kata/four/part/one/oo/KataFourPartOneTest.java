package com.sourceallies.kata.four.part.one.oo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sourceallies.kata.four.part.one.oo.parse.file.WeatherFileParser;

public class KataFourPartOneTest {

	@Test
	public void testKata(){
		List<Weather> weatherList = new WeatherFileParser().parse("weather.dat");
		int smallestSpreadDay = 0;
		int smallestSpreadValue = 0;
		boolean firstTime = true;
		for(Weather weather : weatherList){
			int spread = weather.getMaxTemp() - weather.getMinTemp();
			if(firstTime){
				smallestSpreadDay = weather.getDay();
				smallestSpreadValue = spread;
				firstTime = false;
			}
			
			if(spread < smallestSpreadValue){
				smallestSpreadDay = weather.getDay();
				smallestSpreadValue = spread;
			}
		}
		
		assertEquals(14, smallestSpreadDay);
	}
}
