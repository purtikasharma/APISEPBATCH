package org.testing.utilities;

import java.util.regex.Pattern;
//inputs--body data (that is containing variable also) variablename, variablevalue
//purpose -- it will replace the variablename with variable value in the body data
//output -- after replacement the method will return the latest string that is containing variable value

public class JsonReplacement {
	public static String jsonDataVariable(String completeBody, String variablename, String variablevalue)
{
		completeBody = completeBody.replaceAll(Pattern.quote("{{"+variablename+ "}}"), variablevalue);
		return completeBody;
}
	

}
