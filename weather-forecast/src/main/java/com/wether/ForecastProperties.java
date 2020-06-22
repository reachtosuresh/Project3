package com.wether;

import java.util.Collections;
import java.util.List;

public class ForecastProperties {
	
	private String forecast;
	private List<ForecastPeriods> periods = Collections.EMPTY_LIST;
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public List<ForecastPeriods> getPeriods() {
		return periods;
	}
	public void setPeriods(List<ForecastPeriods> periods) {
		this.periods = periods;
	}
	
	

}
