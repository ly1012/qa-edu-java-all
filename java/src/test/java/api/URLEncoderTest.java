package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLEncoderTest {

    @Test
    public void testName() throws UnsupportedEncodingException {
        String encodeStr = URLEncoder.encode("@","UTF-8");
        Assert.assertEquals(encodeStr,"%40");
    }
}
