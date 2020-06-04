package sort;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {

    @Test
    public void testName() throws IOException {
        File file = new File("E:\\jars\\auto-api-gyt-record.jar");
        System.out.println(file.lastModified());
    }

    @Test
    public void testURLClassLoader() {
        try {
            URL url = new URL("file:E:\\jars\\auto-api-gyt-record.jar");
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{ url });
            Class CouponHandler = urlClassLoader.loadClass("com.tairan.qa.gyt.cls.CouponHandler");
            Method handle = CouponHandler.getMethod("hanlde",String.class);
            handle.invoke(CouponHandler.newInstance(),"hzlyun");


            URL url2 = new URL("file:E:\\jars\\auto-api-gyt-record2.jar");
            URLClassLoader urlClassLoader2 = new URLClassLoader(new URL[]{ url2 });
            Class CouponHandler2 = urlClassLoader2.loadClass("com.tairan.qa.gyt.cls.CouponHandler");
            Method handle2 = CouponHandler2.getMethod("hanlde",String.class);
            handle2.invoke(CouponHandler2.newInstance(),"hzlyun");


            URL url3 = new URL("file:E:\\jars\\auto-api-gyt-record3.jar");
//            URL url3 = new URL("https://download.360fintime.cn/jars/auto-api-gyt-record3.jar");
            URLClassLoader urlClassLoader3 = new URLClassLoader(new URL[]{ url3 });
            Class CouponHandler3 = urlClassLoader3.loadClass("com.tairan.qa.gyt.cls.CouponHandler");
            Method handle3 = CouponHandler3.getMethod("hanlde",String.class);
            handle3.invoke(CouponHandler3.newInstance(),"hzlyun");
            Class CouponHandler4 = urlClassLoader3.loadClass("com.tairan.qa.gyt.cls.CouponHandler");
            Method handle4 = CouponHandler4.getMethod("hanlde",String.class);
            handle4.invoke(CouponHandler4.newInstance(),"hzlyun");

            Thread.sleep(4000);

//            urlClassLoader.close();
//            urlClassLoader2.close();
//            urlClassLoader3.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
