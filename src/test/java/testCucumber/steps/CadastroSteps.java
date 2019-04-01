package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class CadastroSteps {

    String nome = "Diego";
    String login = "dieGomes14";
    String senha = "123456";

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Given("^que eu acesse o site \"([^\"]*)\"$")
    public void que_eu_acesse_o_site(String url) throws Exception {
        julioPage.setUrl(url);
    }

    @When("^eu clicar no botao cadastro$")
    public void eu_clicar_no_botao_cadastro() throws Exception {
        julioPage.clicaEmCadastro();
    }

    @When("^eu realizo o cadastro$")
    public void eu_realizo_o_cadastro() throws Exception {
        julioPage.preencheNome(nome);
        julioPage.preencheLoginCadastro(login);
        julioPage.preencheSenhaCadastro(senha);
        julioPage.clicaEmSave();
    }

    @Then("^eu fico logado no site$")
    public void eu_fico_logado_no_site() throws Exception {
        julioPage.validaLogin();
    }
}
