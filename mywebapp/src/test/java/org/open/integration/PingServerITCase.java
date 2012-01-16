package org.open.integration;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class PingServerITCase {

    private static Logger LOG = Logger.getLogger(PingServerITCase.class);
    @BeforeClass
    public static void beforeTestCaseClass() {

    }

    @Test
    public void pingRoot() {
        String checkURL = Utils.getBaseURL() + "/";
        checkURL(checkURL, "Root");
    }

    @Test
    public void pingServlet() {
        String checkURL = Utils.getBaseURL() + "/hi";
        checkURL(checkURL, "check hi servlet");
    }

    @Test
    public void pingFooter() {
        String checkURL = Utils.getBaseURL() + "/footer/bar.jsp";
        checkURL(checkURL, "check footer");
    }

    @Test
    public void validate404() {
        String checkURL = Utils.getBaseURL() + "/junk";
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(checkURL);
            LOG.debug("GET " + checkURL);
            HttpResponse response = httpclient.execute(httpget);
            Assert.assertEquals("404 page missing at" + checkURL, response.getStatusLine().getStatusCode(), 404);
        } catch (Exception exp) {
            Assert.assertFalse("404 page missing at" + checkURL+"message: " + exp.getLocalizedMessage(), true);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
        
    }

    private void checkURL(String url, String artifact) {
        HttpClient httpclient = new DefaultHttpClient();

        try {
            // Prepare a request object
            HttpGet httpget = new HttpGet(url);
            LOG.debug("GET " + url);
            // Execute the request
            HttpResponse response = httpclient.execute(httpget);
            // Examine the response status
            Assert.assertEquals(artifact + " missing at" + url, response.getStatusLine().getStatusCode(), 200);
            /**
            long conlength = response.getEntity().getContentLength();
            Assert.assertTrue("Content Length mismatched for resource. len= " + conlength + ", URL=" + url, 1000 < conlength);
             */
        } catch (Exception exp) {
            //LOG.error("URL failed url:"+url, exp);
            Assert.assertFalse("Failed to get" + artifact + "via URL: "+url+"message: " + exp.getLocalizedMessage(), true);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }
    }
}