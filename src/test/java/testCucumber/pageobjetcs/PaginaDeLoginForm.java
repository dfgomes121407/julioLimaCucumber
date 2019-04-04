package testCucumber.pageobjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class PaginaDeLoginForm {
    private WebDriver navegador;

    public PaginaDeLoginForm(WebDriver navegador) {
        this.navegador = navegador;
    }

    public PaginaDeLoginForm preencheLogin(String login){
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input")).sendKeys(login);

        return this;
    }

    public PaginaDeLoginForm preencheSenha(String senha) throws IOException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys(senha);

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        return this;
    }

    public PaginaLogado efetivaLogin() {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[2]/a")).click();

        return  new PaginaLogado(navegador);
    }
}
