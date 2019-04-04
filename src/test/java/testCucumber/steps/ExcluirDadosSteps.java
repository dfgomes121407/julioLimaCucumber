package testCucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.PaginaLogado;

import java.io.IOException;

public class ExcluirDadosSteps {
    PaginaLogado paginaLogado = new PaginaLogado(Hooks.getNavegador());
    String tipoContatoQueSeraExcluido;

    @When("^eu clicar em More data about you$")
    public void euClicarEmMoreDataAboutYou() throws IOException {
        this.paginaLogado
                .clicaNomeUsuarioLogado()
                .clicaEmMoreDataAboutYou();
    }

    @Then("^eu cosigo excluir um \"([^\"]*)\" do \"([^\"]*)\"$")
    public void euCosigoExcluirUmDo(String contato, String tipo) throws Throwable {
        this.paginaLogado
                .clicaLixeiraExcluirContato(contato)
                .clicaBotaoConfirmaExclusao();

        tipoContatoQueSeraExcluido = tipo;
    }

    @Then("^eu vejo um pop com a mensagem de exclusao$")
    public void eu_vejo_um_pop_com_a_mensagem_de_exclusao() throws Exception {
        this.paginaLogado
                .validaPopUpExclusao(tipoContatoQueSeraExcluido);
    }


}
