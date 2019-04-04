package testCucumber.pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class PaginaLogado {
    private WebDriver navegador;
    WebDriverWait aguardar;


    public PaginaLogado(WebDriver navegador) {
        this.navegador = navegador;
        aguardar = new WebDriverWait(navegador, 10);
    }

    public void ConfirmaLogin() throws IOException {
        String texto = this.navegador.findElement(By.className("me")).getText();

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        Assert.assertEquals("Hi, Diego",texto);
    }

    public PaginaLogado clicaNomeUsuarioLogado() throws IOException {
        this.navegador.findElement(By.linkText("Hi, Diego")).click();

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        return this;
    }

    public PaginaLogado clicaEmMoreDataAboutYou(){
        this.navegador.findElement(By.xpath("//html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();

        return this;
    }

    public ModalAdicionaContato clicaEmAddMoreData(){
        this.navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();

        return new ModalAdicionaContato(navegador);
    }

    public PaginaLogado validaPopUpDeInclusao(String texto) throws IOException {
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        Assert.assertEquals(texto,mensagem);

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        return this;
    }

    public PaginaLogado clicaLixeiraExcluirContato(String contato){
        navegador.findElement(By.xpath("//span[text()=\""+contato+"\"]/following-sibling::a")).click();

        return this;
    }

    public PaginaLogado clicaBotaoConfirmaExclusao(){
        navegador.switchTo().alert().accept();

        return this;
    }

    public PaginaLogado validaPopUpExclusao(String tipo) throws IOException {
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();

        if (tipo.equals("phone")){
            Assert.assertEquals("Rest in peace, dear phone!", mensagem);
        }else {
            Assert.assertEquals("Rest in peace, dear email!", mensagem);
        }

        Screenshot.tiraScreenshot(navegador,Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

        return this;
    }
}
