package testCucumber.pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    }

    public void validaLogin() throws InterruptedException {
        WebElement logado = this.navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li[1]/a"));
        String vai = logado.getText();
        Assert.assertEquals("Hi, Diego",vai);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaEmSingIn() throws InterruptedException {
        this.navegador.findElement(By.linkText("Sign in")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void preencheLogin(String login) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[1]/input")).sendKeys(login);
    }

    public void preencheSenha(String senha) throws InterruptedException {
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[1]/form/div[2]/div[2]/input")).sendKeys(senha);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void efetivaLogin() throws InterruptedException{
        this.navegador.findElement(By.xpath("//*[@id=\"signinbox\"]/div[2]/a")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaNoNomeLogado() throws InterruptedException {
        this.navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li[1]/a")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaEmMoreDataAboutYou() throws InterruptedException{
        this.navegador.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void clicaEmAddMoreData() throws InterruptedException{
        this.navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void selecionaDropDonw(String campo){
        WebElement dropDonw = this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[2]/select"));
        new Select(dropDonw).selectByValue(campo);
    }

    public void preencheContato(String contato){
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys(contato);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void salvaContatoCadastrado() throws InterruptedException{
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());
    }

    public void validaPopUpInclusao(){
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        Assert.assertEquals("Your contact has been added!",mensagem);
        Reports.tirarFoto(this.navegador, Utils.getTimestamp());

        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

    }

    public void excluiDados(String contato){
        navegador.findElement(By.xpath("//span[text()=\""+contato+"\"]/following-sibling::a")).click();
    }

    public void clicaBotaoConfirmaExclusao(){
        navegador.switchTo().alert().accept();
    }

    public void validaPopUpExclusao(){
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        if (mensagem == "Rest in peace, dear phone!" ) {
            Assert.assertEquals("Rest in peace, dear phone!",mensagem);
            Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        } else {
            Assert.assertEquals("Rest in peace, dear email!",mensagem);
            Reports.tirarFoto(this.navegador, Utils.getTimestamp());
        }

        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
    }

    public void efetuaLogoff(){
        navegador.findElement(By.linkText("Logout")).click();
    }

}
