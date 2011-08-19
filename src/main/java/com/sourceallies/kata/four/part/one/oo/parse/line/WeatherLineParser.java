package com.sourceallies.kata.four.part.one.oo.parse.line;

public class WeatherLineParser {

	public int parseDay(String line) {
		String value = extractSubstring(line, 0, 4);
		return Integer.parseInt(value);
	}

	public int parseMaxTemp(String line) {
		String value = extractSubstring(line, 4, 8);
		return Integer.parseInt(value);
	}

	public int parseMinTemp(String line) {
		String value = extractSubstring(line, 8, 14);
		return Integer.parseInt(value);
	}

	private String extractSubstring(String line, int start, int end) {
		String value = line.substring(start, end);
		value = value.replace("*", "");
		return value.trim();
	}
}
