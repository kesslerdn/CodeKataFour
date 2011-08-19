package com.sourceallies.kata.four.part.one.oo.parse.file;

import java.util.ArrayList;
import java.util.List;

import com.sourceallies.kata.four.part.one.oo.Weather;
import com.sourceallies.kata.four.part.one.oo.file.util.ClasspathFileUtil;
import com.sourceallies.kata.four.part.one.oo.parse.line.WeatherLineParser;

public class WeatherFileParser {
	
	private ClasspathFileUtil classpathFileUtil = new ClasspathFileUtil();
	private WeatherLineParser weatherLineParser = new WeatherLineParser();

	public List<Weather> parse(String filename) {
		List<Weather> weatherList = new ArrayList<Weather>();
		List<String> lines = classpathFileUtil.extractLines(filename);
		for(int i = 0; i < 8; i++){
			lines.remove(0);
		}
		
		for(int i = 0; i < 2; i++){
			lines.remove(lines.size() - 1);
		}
		for(String line : lines){
			int day = weatherLineParser.parseDay(line);
			int minTemp = weatherLineParser.parseMinTemp(line);
			int maxTemp = weatherLineParser.parseMaxTemp(line);
			weatherList.add(new Weather(day, minTemp, maxTemp));
		}
		return weatherList;
	}

}
