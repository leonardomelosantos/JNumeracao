package numeracao;

/**
 * 
 * Esta classe representa uma exec��o no sistema quando o usu�rio
 * solicita a combina��o mas a entrada � vazia. 
 * 
 * @author Leonardo Melo Santos	(leonardomelosantos@gmail.com)
 * @version 1.0
 *
 */
public class NumeroVazioException extends Exception {
	
	public NumeroVazioException() {
		super("N�mero vazio");
	}

}
