package org.testing.testCases;

import java.io.IOException;
import java.util.Properties;

import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.HandleProperties;

public class TC7_GetParticularEmpData {
	
	public void testcase7() throws IOException
	{
		Properties probject = HandleProperties.loadPropertiesFile("../API_SEP_FW/URI.properties");
		HTTPMethods http = new HTTPMethods(probject);
		http.getParticluarRecord("QA_JSON_URI", TC6_PostEmpData.responseage);
	}

}
