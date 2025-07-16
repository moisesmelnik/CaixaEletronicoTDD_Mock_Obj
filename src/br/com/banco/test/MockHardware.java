package br.com.banco.test;



import br.com.banco.Hardware;

import br.com.banco.ProblemaNoHardware;



// Classe principal representando uma entidade ou funcionalidade
public class MockHardware implements Hardware {

    private boolean falha;

    private String numeroConta;



// Método público sem retorno, executa uma ação
    public void setFalha(boolean falha) {

        this.falha = falha;

    }



// Método público sem retorno, executa uma ação
    public void setNumeroConta(String numeroConta) {

        this.numeroConta = numeroConta;

    }



    @Override

// Método público que retorna valor
    public String pegarNumeroDaContaCartao() throws ProblemaNoHardware {

// Estrutura condicional
        if (falha) throw new ProblemaNoHardware("Falha ao ler cartão");

        return numeroConta;

    }



    @Override

// Método público sem retorno, executa uma ação
    public void entregarDinheiro() throws ProblemaNoHardware {

// Estrutura condicional
        if (falha) throw new ProblemaNoHardware("Falha ao entregar dinheiro");

    }



    @Override

// Método público sem retorno, executa uma ação
    public void lerEnvelope() throws ProblemaNoHardware {

// Estrutura condicional
        if (falha) throw new ProblemaNoHardware("Falha ao ler envelope");

    }

}
