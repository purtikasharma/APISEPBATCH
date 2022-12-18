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

import io.restassured.response.Response;

public class TC6_PostEmpData {
	static String responseage;
	public void testcase6() throws IOException {
		Properties probject = HandleProperties.loadPropertiesFile("../API_SEP_FW/URI.properties");
		String inputBodydata =HandleJsonFile.readJson("../API_SEP_FW/src/test/java/org/testing/resources/Json.json");
		System.out.println("Please age value");
		Scanner sc = new Scanner(System.in);
		String age = sc.next();
		
		String updatedBodyData= JsonReplacement.jsonDataVariable(inputBodydata, "age", age);
		HTTPMethods http = new HTTPMethods(probject);
		Response resObject =http.postrequest("QA_JSON_URI", updatedBodyData);
		responseage =JsonParingUsingJsonPath.jsonParse(resObject, "age");
		System.out.println(responseage);
}
}