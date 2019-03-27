package testCucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import testCucumber.support.Web;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver navegador = null;

    @Before
    public void setUp(){

        navegador = Web.getChromeDirver();
    }

//    @After
//    public void tearDonw(){
//        navegador.quit();
//    }

    public static WebDriver getNavegador(){
        return navegador;
    }
}
