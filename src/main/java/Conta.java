import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * Classe de conta bancaria utilizando o cucumber
 * 
 * @author Gabriel Alenxadre Rosa
 * @version 1.0
 * @since 1.0
 */
public class Conta {

    private int saldo; //Atributo int que armazena o saldo da conta
    private boolean isEspecial; //Atributo booleano que armarzena se é um usuario especial

    private boolean isSaqueRealizado = false; //Atributo booleano para identificar se o saque foi realizado ou não

    /**
     * Método que inicializa o valor inicial da conta do cliente e
     * qual o tipo da conta do dele.
     *
     * @param saldo Valor inicial do saldo da conta.
     */
    @Given("Um cliente especial com saldo atual de {int} reais")
    public void um_cliente_especial_com_saldo_atual_de_reais(Integer saldo) {
        this.saldo = saldo;
        this.isEspecial=true;
    }

    /**
     * Método que realiza um saque atravéz do método realizarSaque.
     *
     * @param saque Valor que ira ser sacado.
     */
    @When("for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(int saque) {
    	if (saque > 0 && (this.isEspecial || this.saldo >= saque)) {
            this.saldo -= saque;
            this.isSaqueRealizado = true;
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    /**
     * Método que verifica o saldo da conta após um saque.
     *
     * @param novoSaldo Novo valor do saldo da conta.
     */
    @Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int novoSaldo) {
        assert this.saldo == novoSaldo;
    }

    /**
     * Método que mostra uma mensagem caso o cliente for Especial e
     * caso o saldo for negativo.
     */
    @Then("check more outcomes")
    public void check_more_outcomes() {
        if (this.isEspecial) {
            System.out.println("Cliente especial.");
        }
        if (this.saldo < 0) {
            System.out.println("Saldo negativo.");
        }
    }


    /**
     * Método que defini o valor inicial da conta do cliente e
     * qual o tipo da conta dele.
     *
     * @param saldo inicial
     */
    @Given("Um cliente comum com saldo atual de {int} reais")
    public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
        this.saldo = saldo;
        this.isSaqueRealizado = false;
    }

    /**
     * Método que realiza um saque
     *
     * @param saque Valor a ser sacado.
     */
    @When("solicitar um saque de {int} reais")
    public void solicitar_um_saque_de_reais(int saque) {
    	if (saque > 0 && (this.isEspecial || this.saldo >= saque)) {
            this.saldo -= saque;
            this.isSaqueRealizado = true;
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }

    /**
     * Método que garante que um saque não foi efetuado.
     */
    @Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
    public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
        assert this.isSaqueRealizado == false;
    }   
}