package com.wether;

public class ForecastPeriods {
	
	private int number;
	private String name;
	private String startTime;
	private String endTime;
	private boolean isDaytime;
	private String temperature;
	private String temperatureUnit;
	private String temperatureTrend;
	private String windSpeed;
	private String windDirection;
	private String icon;
	private String shortForecast;
	private String detailedForecast;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isDaytime() {
		return isDaytime;
	}
	public void setDaytime(boolean isDaytime) {
		this.isDaytime = isDaytime;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getTemperatureUnit() {
		return temperatureUnit;
	}
	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
	public String getTemperatureTrend() {
		return temperatureTrend;
	}
	public void setTemperatureTrend(String temperatureTrend) {
		this.temperatureTrend = temperatureTrend;
	}
	public String getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getShortForecast() {
		return shortForecast;
	}
	public void setShortForecast(String shortForecast) {
		this.shortForecast = shortForecast;
	}
	public String getDetailedForecast() {
		return detailedForecast;
	}
	public void setDetailedForecast(String detailedForecast) {
		this.detailedForecast = detailedForecast;
	}
	@Override
	public String toString() {
		return "ForecastPeriods [number=" + number + ", name=" + name + ", startTime=" + startTime + ", endTime="
				+ endTime + ", isDaytime=" + isDaytime + ", temperature=" + temperature + ", temperatureUnit="
				+ temperatureUnit + ", temperatureTrend=" + temperatureTrend + ", windSpeed=" + windSpeed
				+ ", windDirection=" + windDirection + ", icon=" + icon + ", shortForecast=" + shortForecast
				+ ", detailedForecast=" + detailedForecast + "]";
	}
	
	

}
