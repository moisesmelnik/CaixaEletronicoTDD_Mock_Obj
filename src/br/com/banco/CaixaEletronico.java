package br.com.banco;



// Classe principal representando uma entidade ou funcionalidade
public class CaixaEletronico {

    private ServicoRemoto servicoRemoto;

    private Hardware hardware;

    private ContaCorrente contaAtual;



// Método público que retorna valor
    public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {

        this.servicoRemoto = servicoRemoto;

        this.hardware = hardware;

    }



// Método público que retorna valor
    public String logar() {

        try {

            String numeroConta = hardware.pegarNumeroDaContaCartao();

            contaAtual = servicoRemoto.recuperarConta(numeroConta);

// Estrutura condicional
            if (contaAtual != null) {

                return "Usuário Autenticado";

            }

        } catch (ProblemaNoHardware e) {

            return "Erro no hardware: " + e.getMessage();

        }

        return "Não foi possível autenticar o usuário";

    }



// Método público que retorna valor
    public String sacar(double valor) {

// Estrutura condicional
        if (contaAtual == null) {

            return "Usuário não autenticado";

        }

// Estrutura condicional
        if (contaAtual.getSaldo() < valor) {

            return "Saldo insuficiente";

        }

        try {

            hardware.entregarDinheiro();

            contaAtual.sacar(valor);

            servicoRemoto.persistirConta(new ContaCorrente(contaAtual)); // Passando cópia

            return "Retire seu dinheiro";

        } catch (ProblemaNoHardware e) {

            return "Erro no hardware: " + e.getMessage();

        }

    }



// Método público que retorna valor
    public String depositar(double valor) {

// Estrutura condicional
        if (contaAtual == null) {

            return "Usuário não autenticado";

        }

        try {

            hardware.lerEnvelope();

            contaAtual.depositar(valor);

            servicoRemoto.persistirConta(new ContaCorrente(contaAtual)); // Passando cópia

            return "Depósito recebido com sucesso";

        } catch (ProblemaNoHardware e) {

            return "Erro no hardware: " + e.getMessage();

        }

    }



// Método público que retorna valor
    public String saldo() {

// Estrutura condicional
        if (contaAtual == null) {

            return "Usuário não autenticado";

        }

        return "O saldo é R$" + String.format("%.2f", contaAtual.getSaldo());

    }

}
