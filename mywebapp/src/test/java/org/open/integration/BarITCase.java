package org.open.integration;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BarITCase {

    private static Logger LOG = Logger.getLogger(BarITCase.class);
    @BeforeClass
    public static void beforeTestCaseClass() {

    }

    @Test
    public void validateBar() {
        String checkURL = Utils.getBaseURL() + "/footer/bar.jsp";
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet(checkURL);
            LOG.debug("GET " + checkURL);
            HttpResponse response = httpclient.execute(httpget);
            Assert.assertEquals("cannot reach bar" + checkURL, response.getStatusLine().getStatusCode(), 200);
            /**
             long conlength = response.getEntity().getContentLength();
             Assert.assertTrue("Content Length mismatched for resource. len= " + conlength + ", URL=" + url, 1000 < conlength);
             */
        } catch (Exception exp) {
            //LOG.error("URL failed url:"+url, exp);
            Assert.assertFalse("cannot reach bar" + checkURL+", message: " + exp.getLocalizedMessage(), true);
        } finally {
            httpclient.getConnectionManager().shutdown();
        }

    }
}
