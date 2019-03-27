package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class LoginSteps {

    String nome = "Diego";
    String login = "dieGomes11";
    String senha = "123456";

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Given("^que esteja cadastrado no site \"([^\"]*)\"$")
    public void que_esteja_cadastrado_no_site(String url) throws Exception {
        julioPage.setUrl(url);
    }

    @When("^eu clicar em Sign in$")
    public void eu_clicar_em_Sign_in() throws Exception {
        julioPage.clicaEmSingIn();
    }

    @When("^preencher os campos Login e Password$")
    public void preencher_os_campos_e() throws Exception {
        julioPage.preencheLogin(login);
        julioPage.preencheSenha(senha);
    }

    @When("^clicar no botao SIGN IN$")
    public void clicar_no_botao_SIGN_IN() throws Exception {
        julioPage.efetivaLogin();
    }
}
