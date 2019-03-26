Feature: Udemy

  @Teste
  Scenario: Efetua cadastro
    Given que eu acesse o site "http://www.juliodelima.com.br/taskit/"
    When eu clicar no botao cadastro
    And eu realizo o cadastro
    Then eu fico logado no site