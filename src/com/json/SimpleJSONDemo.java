package com.json;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SimpleJSONDemo {

	public static void main(String[] args) {
		
		JSONObject jo = new JSONObject();
		jo.put("firstName","Abhishek");
		jo.put("lastName","Dwivedi");
		jo.put("age",19);
		
		Map map = new LinkedHashMap(4);
		map.put("streetAddress","East boring canal road");
		map.put("city","patna");
		map.put("state","bihar");
		map.put("postalCode",800001);
		
		jo.put("address",map);
		
		JSONArray ja = new JSONArray();
		
		map = new LinkedHashMap(2);
		map.put("type", "home");
		map.put("number","3556346356");
		ja.add(map);
		
		map = new LinkedHashMap(2);
		map.put("type", "fax");
		map.put("number", "2323435435");
		
		ja.add(map);
		
		jo.put("phonenumbers", ja);
		
		try {
			PrintWriter pw = new PrintWriter("/Users/abdwivedi/Desktop/JSONExample.json");
			pw.write(jo.toJSONString());
			pw.flush();
			pw.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
	}

}
