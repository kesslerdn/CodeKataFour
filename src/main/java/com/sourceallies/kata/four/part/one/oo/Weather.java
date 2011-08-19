package com.sourceallies.kata.four.part.one.oo;

public class Weather {

	private int day;
	private int minTemp;
	private int maxTemp;

	public Weather(int day, int minTemp, int maxTemp) {
		this.day = day;
		this.minTemp = minTemp;
		this.maxTemp = maxTemp;
	}

	public int getDay() {
		return day;
	}

	public int getMinTemp() {
		return minTemp;
	}

	public int getMaxTemp() {
		return maxTemp;
	}
}
