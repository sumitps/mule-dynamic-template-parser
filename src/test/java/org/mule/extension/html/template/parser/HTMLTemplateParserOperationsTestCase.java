package org.mule.extension.html.template.parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mule.functional.junit4.MuleArtifactFunctionalTestCase;


public class HTMLTemplateParserOperationsTestCase extends MuleArtifactFunctionalTestCase {

  /**
   * Specifies the mule config xml with the flows that are going to be executed in the tests, this file lives in the test resources.
   */
  @Override
  protected String getConfigFile() {
    return "test-mule-config.xml";
  }
  	
  	public class Content{
  		String title;
  		public Content(String str) {
			this.title = str;
		}
  	}
  
	@Test
	public void executeParseHtmlTemplateOperation() throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		Content content = new Content(TEST_MESSAGE);
		parameters.put("content",content);
		String payloadValue = ((String) flowRunner("parseHtmlTemplateFlow").withPayload(parameters).run().getMessage()
				.getPayload().getValue().toString());
		assertThat(payloadValue, is("Sample Heading : Test Message"));
	}
}
