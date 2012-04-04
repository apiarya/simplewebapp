package org.open.integration.selenium;

import junit.framework.TestCase;
import com.thoughtworks.selenium.DefaultSelenium;
import org.open.integration.Utils;

public class SeleniumExampleITCase
        extends TestCase
{
    protected DefaultSelenium createSeleniumClient(String url) throws Exception {
        return new DefaultSelenium("localhost", 4444, "*firefox", url);
    }

    public void testSomethingSimple() throws Exception {

        String checkURL = Utils.getBaseURL() + "/";
        DefaultSelenium selenium = createSeleniumClient(checkURL);
        selenium.start();
        selenium.open(checkURL);

        selenium.click("link=footer/bar.jsp");
        selenium.waitForPageToLoad("30000");

        assertTrue("Failed to find JSESSION ID", selenium.isTextPresent("JSESSIONID"));
        //assertEquals("Welcome", selenium.getText("xpath=/html/body/table[@id='rootfragment']/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/table/tbody/tr[1]/td/table/tbody/tr[1]/td/div/table/tbody/tr/td[2]/table/tbody/tr/td[1]/strong"));
        selenium.stop();
    }
}