package com.cxz.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 用来处理Properties文件的
 * 
 * @author 22527
 *
 */
public class PropertiesFileHandle {

	private String fileName;
	private Properties prop;

	public PropertiesFileHandle(String fileName) {
		super();
		this.fileName = fileName;
		if (!fileName.isEmpty()) {
			loadFile();
		}
	}

	public PropertiesFileHandle() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		if (fileName != null && fileName != this.fileName) {
			this.fileName = fileName;
			loadFile();
		}
	}

	public Properties getProp() {
		return prop;
	}

	// 加载.properties文件
	private void loadFile() {
		if (prop == null && fileName != null) {
			prop = new Properties();
			InputStream ins = null;
			try {
				// 获得类路径
				String path = this.getClass().getResource("/").getPath() +this.fileName;
				ins = new BufferedInputStream(new FileInputStream(path));
				prop.load(ins);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ins != null) {
					try {
						ins.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public String getValue(String key) {
		return prop.getProperty(key, "");
	}
	
	public int getIntValue(String key) {
		try {
			return Integer.parseInt(getValue(key));
		} catch (NumberFormatException e) {
			return Integer.MAX_VALUE;
		}
	}
	
	public boolean getBoolValue(String key) {
		return Boolean.parseBoolean(getValue(key).toLowerCase());
	}
	
	public double getDoubleValue(String key) {
		return Double.parseDouble(key);
	}

	// 获得多个key-value值
	public Map<String, String> getValues(String... keys) {
		Map<String, String> map = new HashMap<>();
		for (String key : keys) {
			map.put(key, getValue(key));
		}
		return map;
	}
}
