package numeracao;

/**
 * 
 * Esta classe representa uma execção no sistema quando o usuário
 * solicita a combinação mas a entrada é vazia. 
 * 
 * @author Leonardo Melo Santos	(leonardomelosantos@gmail.com)
 * @version 1.0
 *
 */
public class NumeroVazioException extends Exception {
	
	public NumeroVazioException() {
		super("Número vazio");
	}

}
