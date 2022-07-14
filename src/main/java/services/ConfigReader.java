package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private final String propertyDir = System.getProperty("user.dir") + "/src/test/resources/";
	private String propertyFilePath;

	public ConfigReader(String propertyFilePath) {
		BufferedReader reader;
		this.propertyFilePath = this.propertyDir + propertyFilePath;
		try {
			reader = new BufferedReader(new FileReader(this.propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + this.propertyFilePath);
		}
	}
	
	public ConfigReader() {
		BufferedReader reader;
		this.propertyFilePath = this.propertyDir + "config.properties";
		try {
			reader = new BufferedReader(new FileReader(this.propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at config.properties");
		}
	}

	public String getPropertyValue(String key) {
		String val = properties.getProperty(key);
		if (val != null) {
			return val;
		} else {
			throw new RuntimeException(key + " not specified in the properties file.");
		}
	}

}
