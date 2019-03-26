package testCucumber.support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import com.google.common.io.Files;
import java.nio.file.Paths;

public class Reports {

    private static final String PATH_EVIDENCES = Paths.get("").toAbsolutePath().toString() + "/Evidences";

    private Reports() {
    }

    public static void tirarFoto(WebDriver navegador, String nomeDoArquivo) {
        File foto = ((TakesScreenshot) navegador).getScreenshotAs(OutputType.FILE);
        File dest = new File(PATH_EVIDENCES + "/" + nomeDoArquivo + ".png");
        try {
            File dir = new File(PATH_EVIDENCES);
            if (!dir.exists()) dir.mkdir();
            Files.copy(foto, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}