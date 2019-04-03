Feature: Curso de automacao demy

  @cadastro
  Scenario Outline: Efetuar Cadastro
    Given que eu acesse o site "http://www.juliodelima.com.br/taskit/"
    When eu clicar no botao cadastro
    And eu preencher os campos nome com "<name>", login com "<login>" e senha com "<senha>"
    And eu clicar em SAVE
    Then eu fico logado no site
    Examples:
      | name  | login      | senha  |
      | Diego | dieGomes22 | 123456 |
      | Diego | dieGomes23 | 123456 |

  @login
  Scenario Outline: Efetuar Login
    Given que esteja cadastrado no site "http://www.juliodelima.com.br/taskit/"
    When eu clicar em Sign in
    And preencher os campos login com "<login>" e Password com "<senha>"
    And clicar no botao SIGN IN
    Then eu fico logado no site
    Examples:
      | login      | senha  |
      | dieGomes22 | 123456 |
      | dieGomes23 | 123456 |

  @adiciona
  Scenario Outline: Adiciona Dados
    Given que esteja logado no site
    When eu clicar no mome do usuario logado
    And eu clicar em More data about you
    And eu clicar em Add more data
    Then eu cosigo selecionar o tipo com "<tipo>"
    And eu consigo preencher com o campo contacto com "<contato>"
    And eu clico em SAVE
    Then eu vejo um pop com a mensagem "Your contact has been added!"
    Examples:
      | tipo  | contato          |
      | email | blabla@teste.com |
      | phone | 1111111111       |

  @exclui
  Scenario Outline: Excluir Contato
    Given que esteja logado no site
    When eu clicar no mome do usuario logado
    And eu clicar em More data about you
    Then eu cosigo excluir um "<contato>"
    And eu vejo um pop com a mensagem de exclusao
    Examples:
      | contato          |
      | blabla@teste.com |
      | 1111111111       |