package testCucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.ModalAdicionaContato;
import testCucumber.pageobjetcs.PaginaDeLogin;
import testCucumber.pageobjetcs.PaginaLogado;

import java.io.IOException;

public class AdicionaDadosSteps {

    PaginaDeLogin paginaDeLogin = new PaginaDeLogin(Hooks.getNavegador());
    PaginaLogado paginaLogado = new PaginaLogado(Hooks.getNavegador());
    ModalAdicionaContato modalAdicionaContato = new ModalAdicionaContato(Hooks.getNavegador());

    @Given("^que esteja logado no \"([^\"]*)\" com \"([^\"]*)\" e \"([^\"]*)\"$")
    public void queEstejaLogadoNoComE(String site, String login, String senha) throws Throwable {
        this.paginaDeLogin
                .clickSignIn(site)
                .preencheLogin(login)
                .preencheSenha(senha)
                .efetivaLogin();
    }

    @When("^eu clicar em Add more data$")
    public void euClicarEmAddMoreData() throws IOException {
        this.paginaLogado
                .clicaNomeUsuarioLogado()
                .clicaEmMoreDataAboutYou()
                .clicaEmAddMoreData();
    }

    @And("^selecionar o tipo com \"([^\"]*)\", preencher com o campo contacto com \"([^\"]*)\"$")
    public void selecionarOTipoComPreencherComOCampoContactoCom(String tipo, String contato) throws Throwable {
        this.modalAdicionaContato
                .selecionaTipo(tipo)
                .preencheContato(contato)
                .clicaEmSave();
    }

    @Then("^eu vejo um pop-up com a mensagem \"([^\"]*)\"$")
    public void euVejoUmPopUpComAMensagem(String mensagem) throws Throwable {
        this.paginaLogado
                .validaPopUpDeInclusao(mensagem);
    }
}
