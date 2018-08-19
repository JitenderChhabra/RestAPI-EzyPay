package com.ezypay.common;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;


public class Common {	
	public static Object getResponsePath(String inString, String body)
			throws Exception {

		boolean isJSON = true;
		Object obj;

		if (isJSON) {
			JsonPath resourcePath;
			try {				
				resourcePath = new JsonPath(body);
				obj = resourcePath.get(inString);
				if (obj.toString().equals("[]") || obj.toString().equals("")) {
					throw new Exception("No Response for String: " + inString);
				}
			} catch (Exception e) {
				throw new Exception("No Response for String: " + inString);
			}
			return obj;
		} else {			
			XmlPath resourcePath = new XmlPath(body);
			Object obj1 = resourcePath.get(inString);
			if (obj1.toString().equals("[]") || obj1.toString().equals("")) {
				throw new Exception("No Response for String: " + inString);
			}
			return obj1;
		}

	}
	

}
