package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class CadastroSteps {

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Given("^que eu acesse o site \"([^\"]*)\"$")
    public void que_eu_acesse_o_site(String url) throws Exception {
    }

    @When("^eu clicar no botao cadastro$")
    public void eu_clicar_no_botao_cadastro() throws Exception {
    }

    @When("^eu preencher os campos nome com \"([^\"]*)\", login com \"([^\"]*)\" e senha com \"([^\"]*)\"$")
    public void eu_preencher_os_campos_nome_com_login_com_e_senha_com(String nome, String login, String senha) throws Exception {

    }

    @When("^eu clicar em SAVE$")
    public void eu_clicar_em_SAVE() throws Exception {
    }

    @Then("^eu fico logado no site$")
    public void eu_fico_logado_no_site() throws Exception {
    }
}
