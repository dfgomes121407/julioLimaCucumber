package testCucumber.steps;

import cucumber.api.java.en.Then;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class ExcluirDadosSteps {

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Then("^eu cosigo excluir um \"([^\"]*)\"$")
    public void eu_cosigo_excluir_um(String contato) throws Exception {
        julioPage.excluiDados(contato);
        julioPage.clicaBotaoConfirmaExclusao();
    }

    @Then("^eu vejo um pop com a mensagem de exclusao$")
    public void eu_vejo_um_pop_com_a_mensagem_de_exclusao() throws Exception {
        julioPage.validaPopUpExclusao();
        julioPage.efetuaLogoff();
    }
}
