Feature: Udemy

  @Cadastro
  Scenario: Efetua cadastro
    Given que eu acesse o site "http://www.juliodelima.com.br/taskit/"
    When eu clicar no botao cadastro
    And eu realizo o cadastro
    Then eu fico logado no site

  @Login
  Scenario: Efetua Login
      Given que esteja cadastrado no site "http://www.juliodelima.com.br/taskit/"
      When eu clicar em Sign in
      And preencher os campos Login e Password
      And clicar no botao SIGN IN
      Then eu fico logado no site

