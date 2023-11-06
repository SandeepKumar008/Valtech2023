package com.valtech.training.spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UtilsBean {

	private List<String> names;
	private Properties settings;
	private Map<Point, Line> points;
	
	
	

	public Map<Point, Line> getPoints() {
		return points;
	}

	public void setPoints(Map<Point, Line> points) {
		this.points = points;
	}

	public Properties getSettings() {
		return settings;
	}

	public void setSettings(Properties settings) {
		this.settings = settings;
	}

	public java.util.List<String> getNames() {
		return names;
	}

	public void setNames(java.util.List<String> names) {
		this.names = names;
	}
	
	
}
