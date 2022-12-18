package org.testing.testCases;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.HandleJsonFile;
import org.testing.utilities.HandleProperties;
import org.testing.utilities.JsonReplacement;
import org.testng.annotations.Test;

public class TC4_PutRequest {
	@Test
	public void testcase4() throws IOException {

	Properties probject = HandleProperties.loadPropertiesFile("../API_SEP_FW/URI.properties");
	HTTPMethods http = new HTTPMethods(probject);
	String inputBodydata =HandleJsonFile.readJson("../API_SEP_FW/src/test/java/org/testing/resources/UpdateJson.json");
	String updatedBodyData= JsonReplacement.jsonDataVariable(inputBodydata, "id", TC1_PostRequest.residvalue);
	http.updaterequest("QA_URI", TC1_PostRequest.residvalue, updatedBodyData);
}
}