package testCucumber.support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void tiraScreenshot(WebDriver navegador, String arquivo) throws IOException {
        File tiraScreenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tiraScreenshot, new File(arquivo));
    }
}
