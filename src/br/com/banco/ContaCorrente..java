package br.com.banco;



// Classe principal representando uma entidade ou funcionalidade
public class ContaCorrente {

    private String numeroConta;

    private double saldo;



// Método público que retorna valor
    public ContaCorrente(String numeroConta, double saldo) {

        this.numeroConta = numeroConta;

        this.saldo = saldo;

    }



// Método público que retorna valor
    public ContaCorrente(ContaCorrente outraConta) {

        this.numeroConta = outraConta.numeroConta;

        this.saldo = outraConta.saldo;

    }



// Método público que retorna valor
    public String getNumeroConta() {

        return numeroConta;

    }



// Método público que retorna valor
    public double getSaldo() {

        return saldo;

    }



// Método público sem retorno, executa uma ação
    public void sacar(double valor) {

// Estrutura condicional
        if (valor > 0 && saldo >= valor) {

            saldo -= valor;

        }

    }



// Método público sem retorno, executa uma ação
    public void depositar(double valor) {

// Estrutura condicional
        if (valor > 0) {

            saldo += valor;

        }

    }

}
