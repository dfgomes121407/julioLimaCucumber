Feature: Curso de automacao Udemy

  @cadastro
  Scenario Outline: Efetuar Cadastro
    Given que eu acesse o site "http://www.juliodelima.com.br/taskit/"
    When eu clicar no botao cadastro
    And eu preencher os campos nome com "<name>", login com "<login>" e senha com "<senha>"
    Then eu clico em SAVE e fico logado no site
    Examples:
      | name  | login      | senha  |
      | Diego | dieGomes100 | 123456 |

  @EfetuarLogin
  Scenario Outline: Login
    Given que esteja cadastrado no site "http://www.juliodelima.com.br/taskit/"
    When eu efetuar o login "<login>" "<senha>"
    Then eu realizo login no site

    Examples:
      | login | senha |
      |dieGomes22|123456|

  @inclusao
  Scenario Outline: Adiciona Dados
    Given que esteja logado no "http://www.juliodelima.com.br/taskit/" com "<usuario>" e "<senha>"
    When eu clicar em Add more data
    And selecionar o tipo com "<tipo>", preencher com o campo contacto com "<contato>"
    Then eu vejo um pop-up com a mensagem "Your contact has been added!"
    Examples:
      | usuario | senha | tipo | contato |
      |dieGomes22|123456|phone |222222222|
      |dieGomes22|123456|email |3333@teste.com|

  @exclusao
  Scenario Outline: Excluir Contato
    Given que esteja logado no "http://www.juliodelima.com.br/taskit/" com "<usuario>" e "<senha>"
    When  eu clicar em More data about you
    Then eu cosigo excluir um "<contato>" do "<tipo>"
    And eu vejo um pop com a mensagem de exclusao
    Examples:
      | usuario | senha | contato | tipo|
      |dieGomes22|123456|222222222|phone|
      |dieGomes22|123456|3333@teste.com|email|
