Este projeto é uma implementação simples de uma conta bancária usando Cucumber para testes de comportamento. Ele apresenta dois tipos de clientes: especial e comum, cada um com seu respectivo saldo inicial.

Autor
Gabriel Alexandre Rosa

Versão
1.0

Introdução
O projeto simula operações básicas de uma conta bancária, como saque e verificação de saldo. As funcionalidades são definidas por meio de cenários no formato Gherkin, utilizando a biblioteca Cucumber para Java.

Estrutura do Projeto
Conta.java: Classe principal que implementa a lógica da conta bancária e define os passos dos cenários utilizando anotações Cucumber.
Cenários de Teste
Um cliente especial com saldo atual de {int} reais

Inicializa um cliente especial com um saldo específico.
For solicitado um saque no valor de {int} reais

Realiza um saque na conta do cliente, atualizando o saldo.
Deve efetuar o saque e atualizar o saldo da conta para {int} reais

Verifica se o saque foi realizado com sucesso e se o saldo foi atualizado corretamente.
Check more outcomes

Verifica condições adicionais, como se o cliente é especial ou se o saldo é negativo.
Um cliente comum com saldo atual de {int} reais

Inicializa um cliente comum com um saldo específico.
Solicitar um saque de {int} reais

Realiza um saque na conta do cliente comum.
Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente

Garante que o saque não foi realizado se o saldo for insuficiente.
Executando os Testes
Para executar os testes, você pode utilizar uma ferramenta de execução de testes Cucumber, como o JUnit.
