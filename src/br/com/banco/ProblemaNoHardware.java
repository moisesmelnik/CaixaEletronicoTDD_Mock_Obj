package br.com.banco;



// Exceção personalizada para falhas no hardware

// Classe principal representando uma entidade ou funcionalidade
public class ProblemaNoHardware extends Exception {

    /**

	 * 

	 */

	private static final long serialVersionUID = 1L;



// Método público que retorna valor
	public ProblemaNoHardware(String mensagem) {

        super(mensagem);

    }

}
