package numeracao;

/**
* Esta classe representa uma exce��o para n�meros que n�o est�o sendo 
* representados em decimal.
*
* @author Leonardo Melo Santos	(leonardomelosantos@gmail.com)
* @version 1.0
*
*/
public class NumeroNaoDecimalException extends Exception {
	private static final long serialVersionUID = 1L;
	private String mensagem;

	public NumeroNaoDecimalException(String strNumero) {
		this.mensagem = "N�mero " + strNumero + " n�o est� representado em decimal.";
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}