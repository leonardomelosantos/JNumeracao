package numeracao;

/**
* Esta classe representa uma exceção para números que não
* estão sendo representados em hexadecimal.
*
* @author Leonardo Melo Santos	(leonardomelosantos@gmail.com)
* @version 1.0
*
*/
public class NumeroNaoHexadecimalException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;
	
	public NumeroNaoHexadecimalException(String strNumero) {
		this.mensagem = "Número " + strNumero + " não está representado em hexadecimal.";
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}