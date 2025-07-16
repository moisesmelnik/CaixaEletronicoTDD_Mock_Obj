package br.com.banco;



// Interface que define os métodos a serem implementados
public interface Hardware {

    String pegarNumeroDaContaCartao() throws ProblemaNoHardware;

    void entregarDinheiro() throws ProblemaNoHardware;

    void lerEnvelope() throws ProblemaNoHardware;

}
