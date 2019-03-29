package testCucumber.steps;

import cucumber.api.java.en.Then;
import testCucumber.Hooks;
import testCucumber.pageobjetcs.JulioPage;

public class ExcluirDadosSteps {

    JulioPage julioPage = new JulioPage(Hooks.getNavegador());

    @Then("^eu cosigo excluir um contato$")
    public void eu_cosigo_excluir_um_contato() throws Exception {
        julioPage.excluiDados("diego@teste.com.br");
        julioPage.clicaBotaoConfirmaExclusao();
        julioPage.validaPopUpExclusao();
        julioPage.efetuaLogoff();
    }
}
