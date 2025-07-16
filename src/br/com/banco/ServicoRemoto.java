package br.com.banco;



// Interface que define os métodos a serem implementados
public interface ServicoRemoto {

    ContaCorrente recuperarConta(String numeroConta);

    void persistirConta(ContaCorrente conta);

}
