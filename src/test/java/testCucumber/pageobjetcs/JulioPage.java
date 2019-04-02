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

    //    ACESSA O SITE
    public void acessaSite(String url) throws IOException {
        this.navegador.get(url);
        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

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
        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());
    }

    public void clicaEmSave() throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signupbox\"]/div[2]/a")).click();
    }

    public void validaLogin() throws InterruptedException, IOException {
        WebElement logado = this.navegador.findElement(By.className("me"));
        String validacao = logado.getText();
        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        Assert.assertEquals("Hi, Diego",validacao);
    }
    /**
     * Metodos que fazem login no site
     */

    public void clicaEmSingIn() throws InterruptedException {
        this.navegador.findElement(By.linkText("Sign in")).click();
    }

    public void preencheLogin(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input")).sendKeys(login);
    }

    public void preencheSenha(String senha) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys(senha);
    }

    public void efetivaLogin() throws InterruptedException{
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[2]/a")).click();
    }
    /**
     * Metodos que adicionam dados de contato apos login no site
     */
    public void clicaNoNomeLogado() throws InterruptedException {
        this.navegador.findElement(By.linkText("Hi, Diego")).click();
    }

    public void clicaEmMoreDataAboutYou() throws InterruptedException{
        this.navegador.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
    }

    public void clicaEmAddMoreData() throws InterruptedException{this.navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();}

    public void selecionaDropDonw(String campo){
        WebElement dropDonw = this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[2]/select"));
        new Select(dropDonw).selectByValue(campo);
    }

    public void preencheContato(String contato){
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys(contato);
    }

    public void salvaContatoCadastrado() throws InterruptedException{
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();
    }

    public void validaPopUpInclusao(String texto) throws IOException {
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        Assert.assertEquals(texto,mensagem);

        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
    }

//    EXCLUI DADOS JA LOGADO

    public void excluiDados(String contato){navegador.findElement(By.xpath("//span[text()=\""+contato+"\"]/following-sibling::a")).click();}

    public void clicaBotaoConfirmaExclusao(){
        navegador.switchTo().alert().accept();
    }

    public void validaPopUpExclusao() throws IOException {
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        if (mensagem == "Rest in peace, dear phone!" ) {
            Assert.assertEquals("Rest in peace, dear phone!",mensagem);
        } else {
            Assert.assertEquals("Rest in peace, dear email!",mensagem);
        }

        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
    }

    public void efetuaLogoff(){
        navegador.findElement(By.linkText("Logout")).click();
    }
}
