package testCucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class AdicionaDadosSteps {

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Given("^que esteja logado no site$")
    public void que_esja_logado_no_site() throws Exception {
        julioPage.setUrl("http://www.juliodelima.com.br/taskit/");
        julioPage.clicaEmSingIn();
        julioPage.preencheLogin("dieGomes11");
        julioPage.preencheSenha("123456");
        julioPage.efetivaLogin();
    }

    @When("^eu clicar no mome do usuario logado$")
    public void eu_clicar_no_mome_do_usuario_logado() throws Exception {
        julioPage.clicaNoNomeLogado();
    }

    @When("^eu clicar em More data about you$")
    public void eu_clicar_em_More_data_about_you() throws Exception {
        julioPage.clicaEmMoreDataAboutYou();
    }

    @When("^eu clicar em Add more data$")
    public void eu_clicar_em_Add_more_data() throws Exception {
        julioPage.clicaEmAddMoreData();
    }

    @Then("^eu cosigo cadastra um nome e-mail$")
    public void eu_cosigo_cadastra_um_nome_e_mail() throws Exception {
        julioPage.selecionaDropDonw("email");
        julioPage.preencheEmail();
        julioPage.salvaEmailCadastrado();
    }
}
