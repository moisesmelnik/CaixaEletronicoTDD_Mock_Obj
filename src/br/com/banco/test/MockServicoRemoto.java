package br.com.banco.test;



import br.com.banco.ContaCorrente;

import br.com.banco.ServicoRemoto;



import java.util.HashMap;

import java.util.Map;



// Classe principal representando uma entidade ou funcionalidade
public class MockServicoRemoto implements ServicoRemoto {

// Método privado usado internamente na classe
    private Map<String, ContaCorrente> contas = new HashMap<>();



// Método público sem retorno, executa uma ação
    public void adicionarConta(ContaCorrente conta) {

        contas.put(conta.getNumeroConta(), new ContaCorrente(conta)); // Armazena uma cópia

    }



    @Override

// Método público que retorna valor
    public ContaCorrente recuperarConta(String numeroConta) {

        return contas.containsKey(numeroConta) ? new ContaCorrente(contas.get(numeroConta)) : null;

    }



    @Override

// Método público sem retorno, executa uma ação
    public void persistirConta(ContaCorrente conta) {

        contas.put(conta.getNumeroConta(), new ContaCorrente(conta)); // Salva uma cópia

    }

}
