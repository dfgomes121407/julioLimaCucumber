package testCucumber.pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCucumber.support.Reports;
import testCucumber.support.Utils;

public class JulioPage {
    private WebDriver navegador;

    public JulioPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public void setUrl(String url) {
        this.navegador.get(url);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaEmCadastro() throws InterruptedException {
        this.navegador.findElement(By.id("signup")).click();
    }

    public void preencheNome(String nome) throws InterruptedException {
        this.navegador.findElement(By.xpath("//input[@placeholder='Tell us what is your name']")).sendKeys(nome);
    }

    public void preencheLoginCadastro(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[1]/input")).sendKeys(login);
    }

    public void preencheSenhaCadastro(String senha) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[2]/input")).sendKeys(senha);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaEmSave() throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[2]/a")).click();
        Thread.sleep(1000);
    }

    public void validaLogin() throws InterruptedException {
        this.navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li[1]/a"));
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        Thread.sleep(1000);
    }

    public void clicaEmSingIn() throws InterruptedException {
        this.navegador.findElement(By.linkText("Sign in")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        Thread.sleep(1000);
    }

    public void preencheLogin(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input")).sendKeys(login);
    }

    public void preencheSenha(String senha) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys(senha);
        Thread.sleep(1000);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void efetivaLogin() throws InterruptedException{

        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[2]/a")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        Thread.sleep(1000);
    }
}
