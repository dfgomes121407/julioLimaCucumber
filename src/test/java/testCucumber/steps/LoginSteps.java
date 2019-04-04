package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.PaginaDeLogin;
import testCucumber.pageobjetcs.PaginaDeLoginForm;
import testCucumber.pageobjetcs.PaginaLogado;

import java.io.IOException;

public class LoginSteps {

    PaginaDeLogin paginaDeLogin = new PaginaDeLogin(Hooks.getNavegador());
    PaginaDeLoginForm paginaDeLoginForm = new PaginaDeLoginForm(Hooks.getNavegador());
    PaginaLogado paginaLogado = new PaginaLogado(Hooks.getNavegador());

    @Given("^que esteja cadastrado no site \"([^\"]*)\"$")
    public void que_esteja_cadastrado_no_site(String url) throws Exception {
        this.paginaDeLogin
            .clickSignIn(url);
    }

    @When("^eu efetuar o login \"([^\"]*)\" \"([^\"]*)\"$")
    public void eu_efetuar_o_login(String login, String senha) throws Exception {
        this.paginaDeLoginForm
            .preencheLogin(login)
            .preencheSenha(senha)
            .efetivaLogin();
    }

    @Then("^eu realizo login no site$")
    public void euRealizoLoginNoSite() throws IOException {
        this.paginaLogado
            .ConfirmaLogin();
    }
}
