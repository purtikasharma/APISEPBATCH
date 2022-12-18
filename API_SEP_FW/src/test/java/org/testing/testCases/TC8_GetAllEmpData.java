package org.testing.testCases;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.HandleProperties;

public class TC8_GetAllEmpData {
	
	public void testcase8() throws IOException
	{
		Properties probject = HandleProperties.loadPropertiesFile("../API_SEP_FW/URI.properties");
		HTTPMethods http = new HTTPMethods(probject);
		http.getAllRequest("QA_Get_All");
	}

}
