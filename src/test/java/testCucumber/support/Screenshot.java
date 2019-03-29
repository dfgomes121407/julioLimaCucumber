package testCucumber.support;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void tiraScreenshot(WebDriver navegador, String arquivo, String qualTeste) throws IOException {

        TestName teste = new TestName();

        File tiraScreenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        String locaArquivo = "C:\\Users\\t1407dgf\\IdeaProjects\\julioLimaCucumber\\evidencias\\";

        FileUtils.copyFile(tiraScreenshot, new File(locaArquivo+arquivo+qualTeste+".png"));
    }
}
