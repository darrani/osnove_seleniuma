package helper;

import org.openqa.selenium.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.FileHandler;

public class Helper {

    public boolean ElementExixt(WebDriver driver, By by){
        boolean elementExixt = true;
        try{
            WebElement div = driver.findElement(by);
        }catch (NoSuchElementException error){
            elementExixt = false;
        }
        return elementExixt;
    }
    public boolean elementExistByList(WebDriver driver, By by){
        return  driver.findElements(by).size() > 0;
    }
    public void downloadUsingStream(String urlStr, String relativePath) throws IOException, IOException{
        String file = new File(relativePath).getAbsolutePath();
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);

        byte[] buffer = new byte[1024];
        int count = 0;
        while((count = bis.read(buffer, 0, 1024))!= -1 );
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();

    }
//    public void takeScreenshot(WebDriver driver, String relativePath) throws  IOException{
//        TakesScreenshot ts = (TakesScreenshot) driver;
//
//        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),
//                new File(relativePath));

   // }
    public int getHTTPResponseStatusCode(String urlString) throws IOException{
        URL url = new URL (urlString);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        return http.getResponseCode();
    }
}
