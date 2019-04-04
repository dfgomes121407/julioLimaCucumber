package testCucumber.pageobjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class PaginaDeLogin {
    private WebDriver navegador;

    public PaginaDeLogin(WebDriver navegador){
        this.navegador = navegador;
    }


    public PaginaDeLoginForm clickSignIn(String url) throws IOException {
        this.navegador.get(url);
        this.navegador.findElement(By.linkText("Sign in")).click();
        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        return new PaginaDeLoginForm(navegador);
    }
}
