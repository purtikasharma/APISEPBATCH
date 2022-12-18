package org.testing.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

public class HandleJsonFile {
	
	//read the Json File
	// input parameter - json file path
	//output ---- the json data in string format
	public static String readJson(String jsonFilePath) throws FileNotFoundException
	{
		File f = new File(jsonFilePath);// connection establish 
		FileReader fr = new FileReader(f);// read character by character
		JSONTokener js = new JSONTokener(fr); // used for reading the json file----- to club the data
		JSONObject j = new JSONObject(js);
		return j.toString();
		
	}

}
