//package util;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//
//public class UtilManager {
//
//    private static TakesScreenshot scrShot;
//
//    public UtilManager(WebDriver driver) {
//        scrShot =((TakesScreenshot)driver);
//    }
//
//    public void takeScreenshot() throws IOException {
//        TakesScreenshot scrShot =((TakesScreenshot) driver);
//        LocalDateTime localDateTime = LocalDateTime.now();
//        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//        File DestFile=new File("screenshots/"+localDateTime+".png");
//        FileUtils.copyFile(SrcFile, DestFile);
//    }
//}

/*
TakesScreenshot scrShot =((TakesScreenshot) driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("screenshots/s1.png");
        FileUtils.copyFile(SrcFile, DestFile);
 */
