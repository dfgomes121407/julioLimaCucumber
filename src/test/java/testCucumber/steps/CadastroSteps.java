package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.PaginaDeslogado;
import testCucumber.pageobjetcs.PaginaLogado;

import java.io.IOException;

public class CadastroSteps {
    PaginaDeslogado paginaDeslogado = new PaginaDeslogado(Hooks.getNavegador());
    PaginaLogado paginaLogado = new PaginaLogado(Hooks.getNavegador());

    @Given("^que eu acesse o site \"([^\"]*)\"$")
    public void que_eu_acesse_o_site(String url) throws Exception {
        this.paginaDeslogado
                .acessaSite(url);
    }

    @When("^eu clicar no botao cadastro$")
    public void eu_clicar_no_botao_cadastro() throws Exception {
        this.paginaDeslogado
                .clicaEmCadastro();
    }

    @When("^eu preencher os campos nome com \"([^\"]*)\", login com \"([^\"]*)\" e senha com \"([^\"]*)\"$")
    public void eu_preencher_os_campos_nome_com_login_com_e_senha_com(String nome, String login, String senha) throws Exception {
        this.paginaDeslogado
                .preencheCampoNome(nome)
                .preencheCampoLogin(login)
                .preencheCampoSenha(senha);
    }

    @Then("^eu clico em SAVE e fico logado no site$")
    public void euClicoEmSAVEEFicoLogadoNoSite() throws InterruptedException, IOException {
        this.paginaDeslogado
                .clicaEmSave()
                .ConfirmaLogin();

        this.paginaLogado
                .efetuaLogof();
    }
}
