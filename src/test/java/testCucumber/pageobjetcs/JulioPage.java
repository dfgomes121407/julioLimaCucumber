package testCucumber.pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class JulioPage {
    private WebDriver navegador;
    WebDriverWait aguardar;

    public JulioPage(WebDriver navegador) {
        this.navegador = navegador;
        aguardar = new WebDriverWait(this.navegador, 10);
    }


    /**
     * Metodos que efetuam o cadastro no site
     */










    public void validaLogin() throws InterruptedException, IOException {
        WebElement logado = this.navegador.findElement(By.className("me"));
        String validacao = logado.getText();
        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(), Screenshot.getNameMethod());

        Assert.assertEquals("Hi, Diego", validacao);
    }
}
