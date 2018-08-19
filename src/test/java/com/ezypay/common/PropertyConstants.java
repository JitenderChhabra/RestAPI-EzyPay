package com.ezypay.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertyConstants {
		
	//   #################     AppSettings       #################
	public final static String APPSETTINGS_VALID_USERNAME = getProprty("db.ValidUserName");
	public final static String APPSETTINGS_VALID_PASSWORD = getProprty("db.ValidPassword");
	public final static String APPSETTINGS_INVALID_USERNAME = getProprty("db.InvalidUserName");
	public final static String APPSETTINGS_INVALID_PASSWORD = getProprty("db.InvalidPassword");
	public final static String APPSETTINGS_SPECIAL_CHARACTER_USERNAME = getProprty("db.SpecialCharacterInUserName");
	public final static String APPSETTINGS_SPECIAL_CHARACTER_PASSWORD = getProprty("db.SpecialCharacterInPassword");
	public final static String APPSETTINGS_LONG_USERNAME = getProprty("db.LongUserName");
	public final static String APPSETTINGS_LONG_PASSWORD = getProprty("db.LongPassword");

	static Properties prop = null;
	
	public static String getProprty(String key) {

			// load a properties file
			if(prop == null)
			{
				System.out.println("Initializing");
				prop = new Properties();
				try {
					prop.load(new FileInputStream("appSettings.properties"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return prop.getProperty(key);
	}
		
}