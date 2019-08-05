
package com.json;

import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; 

public class JsonReadExample {

	public static void main(String[] args) throws Exception{
		
		//creating a object of JSONParser using the filereader methood
		Object obj = new JSONParser().parse(new FileReader("/Users/abdwivedi/Desktop/JSONExample.json"));
		
		//meking the above created object the JSONObject
		JSONObject  jo = (JSONObject)obj;
		
		
		//invoking the get method from the json object and passing the key in string
		String firstName = (String)jo.get("firstName");
		String lastName = (String)jo.get("lastName");
		
		System.out.println("FirstName: "+firstName+"\tLastName: "+lastName);
		
		long age = (long)jo.get("age");
		
		System.out.println("Age: "+age);
		
		//creating a map object to get the address in it
		Map address = ((Map)jo.get("address"));
		
		//iterating over the map object using entry set
		Iterator<Map.Entry> itr = address.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry pair = itr.next();
			System.out.println(pair.getKey()+" : "+pair.getValue());
		}
		
		//getting the phone number in a JSONArray object
		JSONArray ja = (JSONArray)jo.get("phonenumbers");
		
		//iterating over the JSONArray object
		Iterator it = ja.iterator();
		while(it.hasNext()) {
			//iterating over the map object 
			itr = ((Map)it.next()).entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry pair = itr.next();
				System.out.println(pair.getKey()+" : "+pair.getValue());
			}
		}
	}

}
