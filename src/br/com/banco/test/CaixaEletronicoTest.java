package br.com.banco.test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import br.com.banco.*;



// Classe principal representando uma entidade ou funcionalidade
public class CaixaEletronicoTest {

    private CaixaEletronico caixa;

    private MockServicoRemoto mockServico;

    private MockHardware mockHardware;



    @BeforeEach

// Método público sem retorno, executa uma ação
    public void setup() {

        mockHardware = new MockHardware();

        mockServico = new MockServicoRemoto();

        mockServico.adicionarConta(new ContaCorrente("12345", 100.0));

        caixa = new CaixaEletronico(mockServico, mockHardware);

    }



    @Test

// Método público sem retorno, executa uma ação
    public void deveLogarComSucesso() {

        mockHardware.setNumeroConta("12345");

        assertEquals("Usuário Autenticado", caixa.logar());

    }



    @Test

// Método público sem retorno, executa uma ação
    public void deveFalharNoLoginPorProblemaNoHardware() {

        mockHardware.setFalha(true);

        assertEquals("Erro no hardware: Falha ao ler cartão", caixa.logar());

    }



    @Test

// Método público sem retorno, executa uma ação
    public void deveFalharNoSaquePorProblemaNoHardware() {

        mockHardware.setNumeroConta("12345");

        caixa.logar();

        mockHardware.setFalha(true);

        assertEquals("Erro no hardware: Falha ao entregar dinheiro", caixa.sacar(50));

    }



    @Test

// Método público sem retorno, executa uma ação
    public void deveFalharAoSacarComSaldoInsuficiente() {

        mockHardware.setNumeroConta("12345");

        caixa.logar();

        assertEquals("Saldo insuficiente", caixa.sacar(150));

    }



    @Test

// Método público sem retorno, executa uma ação
    public void devePersistirContaComCopia() {

        mockHardware.setNumeroConta("12345");

        caixa.logar();

        caixa.depositar(50);

        ContaCorrente contaPersistida = mockServico.recuperarConta("12345");

        assertNotSame(contaPersistida, caixa);

        assertEquals(150.0, contaPersistida.getSaldo());

    }

}
