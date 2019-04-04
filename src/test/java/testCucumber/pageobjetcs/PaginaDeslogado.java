package testCucumber.pageobjetcs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class PaginaDeslogado {
    private WebDriver navegador;

    public PaginaDeslogado(WebDriver navegador){
        this.navegador = navegador;
    }


    public PaginaDeLoginForm clickSignIn(String url) throws IOException {
        this.navegador.get(url);
        this.navegador.findElement(By.linkText("Sign in")).click();
        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        return new PaginaDeLoginForm(navegador);
    }

    public PaginaDeslogado acessaSite(String url){
        this.navegador.get(url);

        return this;
    }

    public PaginaDeslogado clicaEmCadastro(){
        this.navegador.findElement(By.id("signup")).click();

        return this;
    }

    public PaginaDeslogado preencheCampoNome(String nome) throws InterruptedException {
        this.navegador.findElement(By.xpath("//input[@placeholder='Tell us what is your name']")).sendKeys(nome);

        return this;
    }

    public PaginaDeslogado preencheCampoLogin(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[1]/input")).sendKeys(login);

        return this;
    }

    public PaginaDeslogado preencheCampoSenha(String senha) throws InterruptedException, IOException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[1]/form/div[3]/div[2]/input")).sendKeys(senha);

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(), Screenshot.getNameMethod());

        return this;
    }

    public PaginaLogado clicaEmSave() throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[2]/a")).click();

        return new PaginaLogado(navegador);
    }


}
