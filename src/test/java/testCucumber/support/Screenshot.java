package testCucumber.support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void tiraScreenshot(WebDriver navegador, String arquivo, String qualTeste) throws IOException {

        File tiraScreenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        String locaArquivo = "C:\\Users\\Inmetrics.LP1439\\IdeaProjects\\julioLimaCucumber\\evidencias\\";


        FileUtils.copyFile(tiraScreenshot, new File(locaArquivo+arquivo+qualTeste+".png"));
    }
    public  static String getNameMethod() {
        Throwable thr = new Throwable();
        thr.fillInStackTrace ();
        StackTraceElement[] ste = thr.getStackTrace();
        return ste[1].getMethodName();
    }


}
