package testCucumber.pageobjetcs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import testCucumber.support.Generator;
import testCucumber.support.Screenshot;

import java.io.IOException;

public class ModalAdicionaContato {
    private WebDriver navegador;

    public ModalAdicionaContato(WebDriver navegador) {
        this.navegador = navegador;
    }

    public ModalAdicionaContato selecionaTipo(String campo){
        WebElement dropDonw = this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[2]/select"));
        new Select(dropDonw).selectByValue(campo);

        return this;
    }

    public ModalAdicionaContato preencheContato(String contato) throws IOException {
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[1]/div[3]/div/input")).sendKeys(contato);

        Screenshot.tiraScreenshot(navegador, Generator.dataHoraParaArquivo(),Screenshot.getNameMethod());

        return this;
    }

    public PaginaLogado clicaEmSave(){
        this.navegador.findElement(By.xpath("//*[@id=\"addmoredata\"]/div[2]/a")).click();

        return new PaginaLogado(navegador);
    }
}
