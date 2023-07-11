package com.Pyga.Vtigergenericutlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 *  used to read data from external files like text , proprties
 * @author MadhuSudhanaRao Dande
 *
 */
public class FileUtlity {
	
	/**
	 * used to get the filepaths from the  /config/filepath.properties  FILE
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getFilePathFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./config/filepath.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
	
	/**
	 * used to get the key : value from the any properties based on file Path parsmeter 
	 * @param filePath
	 * @param key
	 * @return value
	 * @throws Throwable
	 */
	public String getDataFromProperties(String filePath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(filePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
