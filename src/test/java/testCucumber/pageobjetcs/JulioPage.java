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
    public void clicaEmCadastro() throws InterruptedException {
        this.navegador.findElement(By.id("signup")).click();
    }

    public void preencheNome(String nome) throws InterruptedException {
        this.navegador.findElement(By.xpath("//input[@placeholder='Tell us what is your name']")).sendKeys(nome);
    }

    public void preencheLoginCadastro(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[1]/input")).sendKeys(login);
    }

    public void preencheSenhaCadastro(String senha) throws InterruptedException, IOException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[2]/input")).sendKeys(senha);
        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(), Screenshot.getNameMethod());
    }

    public void clicaEmSave() throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[2]/a")).click();
    }

    public void validaLogin() throws InterruptedException, IOException {
        WebElement logado = this.navegador.findElement(By.className("me"));
        String validacao = logado.getText();
        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(), Screenshot.getNameMethod());

        Assert.assertEquals("Hi, Diego", validacao);
    }
}
