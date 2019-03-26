package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.LoginPage;

public class CadastroSteps {

    LoginPage loginPage = new LoginPage(Hooks.getNavegador());

    @Given("^que eu acesse o site \"([^\"]*)\"$")
    public void que_eu_acesse_o_site(String arg1) throws Exception {
        loginPage.setUrl(arg1);
    }

    @When("^eu clicar no botao cadastro$")
    public void eu_clicar_no_botao_cadastro() throws Exception {
        loginPage.clicaEmCadastro();
    }

    @When("^eu realizo o cadastro$")
    public void eu_realizo_o_cadastro() throws Exception {
        loginPage.preencheNome("Diego");
        loginPage.preencheLogin("dieGomes6");
        loginPage.preencheSenha("dieGomes");
        loginPage.clicaEmSave();

    }

    @Then("^eu fico logado no site$")
    public void eu_fico_logado_no_site() throws Exception {
        loginPage.validaLogin();

    }
}
