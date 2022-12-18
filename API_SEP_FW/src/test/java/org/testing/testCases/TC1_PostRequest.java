package org.testing.testCases;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.HandleJsonFile;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.JsonParingUsingJsonPath;
import org.testing.utilities.JsonReplacement;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class TC1_PostRequest {
	static String residvalue;
	@Test
	public void testcase1() throws IOException {
		Properties probject = HandleProperties.loadPropertiesFile("../API_SEP_FW/URI.properties");
		String inputBodydata =HandleJsonFile.readJson("../API_SEP_FW/src/test/java/org/testing/resources/Request.json");
		System.out.println("Random ID");
		Random r = new Random();
		Integer idvalue = r.nextInt();			
		String updatedBodyData= JsonReplacement.jsonDataVariable(inputBodydata, "id", idvalue.toString());
		HTTPMethods http = new HTTPMethods(probject);
		Response resObject =http.postrequest("QA_URI", updatedBodyData);
		residvalue =JsonParingUsingJsonPath.jsonParse(resObject, "id");
		System.out.println("Id vaulue is" +residvalue);
		
	}
}
