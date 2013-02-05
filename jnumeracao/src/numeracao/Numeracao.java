package numeracao;

/**
 * Converte as bases de numeração Binário, Octal, Decimal e Hexadecimal entre
 * elas. É válido ressaltar que os números são inteiros e não negativos.
 * 
 * @author Leonardo Melo Santos
 * @version 1.1
 */

public final class Numeracao {
	public static final int TIPO_ENTRADA_BINARIO = 0;

	public static final int TIPO_ENTRADA_DECIMAL = 1;

	public static final int TIPO_ENTRADA_OCTAL = 2;

	public static final int TIPO_ENTRADA_HEXADECIMAL = 3;

	public long converteBinarioParaDecimal(String numeroBinario)
			throws NumeroNaoBinarioException, NumeroVazioException {
		long lngRetorno = 0;
		if (this.numeroValido(numeroBinario, Numeracao.TIPO_ENTRADA_BINARIO)) {
			lngRetorno = paraDecimal(numeroBinario, 2);
		} else {
			throw new NumeroNaoBinarioException(numeroBinario);
		}
		return lngRetorno;
	}

	public String converteBinarioParaOctal(String numeroBinario)
			throws NumeroNaoBinarioException, NumeroVazioException {
		String strRetorno = null;
		if (this.numeroValido(numeroBinario, Numeracao.TIPO_ENTRADA_BINARIO)) {
			strRetorno = this.deDecimal(paraDecimal(numeroBinario, 2), 8);
		} else {
			throw new NumeroNaoBinarioException(numeroBinario);
		}
		return strRetorno;
	}

	public String converteBinarioParaHexadecimal(String numeroBinario)
			throws NumeroNaoBinarioException, NumeroVazioException {
		String strRetorno = null;
		if (this.numeroValido(numeroBinario, Numeracao.TIPO_ENTRADA_BINARIO)) {
			strRetorno = deDecimal(paraDecimal(numeroBinario, 2), 16);
		} else {
			throw new NumeroNaoBinarioException(numeroBinario);
		}
		return strRetorno;
	}

	public String converteOctalParaBinario(String numeroOctal)
			throws NumeroNaoOctalException, NumeroVazioException {
		String strRetorno = null;
		if (this.numeroValido(numeroOctal, Numeracao.TIPO_ENTRADA_OCTAL)) {
			strRetorno = deDecimal(paraDecimal(numeroOctal, 8), 2);
		} else {
			throw new NumeroNaoOctalException(numeroOctal);
		}
		return strRetorno;
	}

	public long converteOctalParaDecimal(String numeroOctal)
			throws NumeroNaoOctalException, NumeroVazioException {
		long lngRetorno = 0;
		if (this.numeroValido(numeroOctal, Numeracao.TIPO_ENTRADA_OCTAL)) {
			lngRetorno = paraDecimal(numeroOctal, 8);
		} else {
			throw new NumeroNaoOctalException(numeroOctal);
		}
		return lngRetorno;
	}

	public String converteOctalParaHexadecimal(String numeroOctal)
			throws NumeroNaoOctalException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroOctal, Numeracao.TIPO_ENTRADA_OCTAL)) {
			retorno = deDecimal(paraDecimal(numeroOctal, 8), 16);
		} else {
			throw new NumeroNaoOctalException(numeroOctal);
		}
		return retorno;
	}

	public String converteDecimalParaBinario(String numeroDecimal)
			throws NumeroNaoDecimalException, NumberFormatException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroDecimal, Numeracao.TIPO_ENTRADA_DECIMAL)) {
			retorno = deDecimal(Long.parseLong(numeroDecimal), 2);
		} else {
			throw new NumeroNaoDecimalException(numeroDecimal);
		}
		return retorno;
	}

	public String converteDecimalParaOctal(String numeroDecimal)
			throws NumeroNaoDecimalException, NumberFormatException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroDecimal, Numeracao.TIPO_ENTRADA_DECIMAL)) {
			retorno = deDecimal(Long.parseLong(numeroDecimal), 8);
		} else {
			throw new NumeroNaoDecimalException(numeroDecimal);
		}
		return retorno;
	}

	public String converteDecimalParaHexadecimal(String numeroDecimal)
			throws NumeroNaoDecimalException, NumberFormatException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroDecimal, Numeracao.TIPO_ENTRADA_DECIMAL)) {
			retorno = deDecimal(Long.parseLong(numeroDecimal), 16);
		} else {
			throw new NumeroNaoDecimalException(numeroDecimal);
		}
		return retorno;
	}

	public String converteHexadecimalParaBinario(String numeroHexadecimal)
			throws NumeroNaoHexadecimalException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroHexadecimal,
				Numeracao.TIPO_ENTRADA_HEXADECIMAL)) {
			retorno = deDecimal(paraDecimal(numeroHexadecimal, 16), 2);
		} else {
			throw new NumeroNaoHexadecimalException(numeroHexadecimal);
		}
		return retorno;
	}

	public String converteHexadecimalParaOctal(String numeroHexadecimal)
			throws NumeroNaoHexadecimalException, NumeroVazioException {
		String retorno = null;
		if (this.numeroValido(numeroHexadecimal,
				Numeracao.TIPO_ENTRADA_HEXADECIMAL)) {
			retorno = deDecimal(paraDecimal(numeroHexadecimal, 16), 8);
		} else {
			throw new NumeroNaoHexadecimalException(numeroHexadecimal);
		}
		return retorno;
	}

	public long converteHexadecimalParaDecimal(String numeroHexadecimal)
			throws NumeroNaoHexadecimalException, NumeroVazioException {
		long retorno = 0;
		if (this.numeroValido(numeroHexadecimal,
				Numeracao.TIPO_ENTRADA_HEXADECIMAL)) {
			retorno = paraDecimal(numeroHexadecimal, 16);
		} else {
			throw new NumeroNaoHexadecimalException(numeroHexadecimal);
		}
		return retorno;
	}

	private String deDecimal(long decimal, long baseDesejada) {
		long dividendo;
		long divisor;
		long resto;
		String retorno = "";

		dividendo = decimal;
		divisor = baseDesejada;

		while (dividendo >= divisor) {
			resto = dividendo % divisor;
			dividendo = dividendo / divisor;
			retorno = asciiValor((int) resto) + retorno;
		}
		retorno = asciiValor((int) dividendo) + retorno;

		return retorno;
	}

	private long paraDecimal(String sequencia, int base) {

		int i = 0;
		long retorno = 0;
		long tamanho = 0;

		tamanho = sequencia.length();

		for (i = 0; i < tamanho; i++) {
			retorno += this.valorAscii(sequencia.charAt(i))
					* Math.pow((double) base, (double) (tamanho - i - 1));
		}
		return retorno;
	}

	/**
	 * Método que verifica se o número está na base de numerção desejada.
	 * 
	 * @param strNumero Número que será validade/verificado.
	 * @param intTipoNumeroEntrada Constante desta classe que representa em qual base será feita a verificação.
	 * 
	 * @return Verdadeiro/Falso
	 */
	public boolean numeroValido(String strNumero, int intTipoNumeroEntrada) throws NumeroVazioException {
		boolean blnRetorno = true;
		int i;

		if (strNumero.trim().equals("")) {
			blnRetorno = false;
			throw new NumeroVazioException();
		} else {
			if (intTipoNumeroEntrada == Numeracao.TIPO_ENTRADA_BINARIO) {
				for (i = 0; i < strNumero.length(); i++) {
					if (strNumero.charAt(i) != '0'
							&& strNumero.charAt(i) != '1') {
						blnRetorno = false;
						break;
					}
				}
			} else if (intTipoNumeroEntrada == Numeracao.TIPO_ENTRADA_DECIMAL) {
				for (i = 0; i < strNumero.length(); i++) {
					if (strNumero.charAt(i) != '0'
							&& strNumero.charAt(i) != '1'
							&& strNumero.charAt(i) != '2'
							&& strNumero.charAt(i) != '3'
							&& strNumero.charAt(i) != '4'
							&& strNumero.charAt(i) != '5'
							&& strNumero.charAt(i) != '6'
							&& strNumero.charAt(i) != '7'
							&& strNumero.charAt(i) != '8'
							&& strNumero.charAt(i) != '9') {
						blnRetorno = false;
						break;
					}
				}
			} else if (intTipoNumeroEntrada == Numeracao.TIPO_ENTRADA_HEXADECIMAL) {
				for (i = 0; i < strNumero.length(); i++) {
					if (strNumero.charAt(i) != '0'
							&& strNumero.charAt(i) != '1'
							&& strNumero.charAt(i) != '2'
							&& strNumero.charAt(i) != '3'
							&& strNumero.charAt(i) != '4'
							&& strNumero.charAt(i) != '5'
							&& strNumero.charAt(i) != '6'
							&& strNumero.charAt(i) != '7'
							&& strNumero.charAt(i) != '8'
							&& strNumero.charAt(i) != '9'
							&& strNumero.toUpperCase().charAt(i) != 'A'
							&& strNumero.toUpperCase().charAt(i) != 'B'
							&& strNumero.toUpperCase().charAt(i) != 'C'
							&& strNumero.toUpperCase().charAt(i) != 'D'
							&& strNumero.toUpperCase().charAt(i) != 'E'
							&& strNumero.toUpperCase().charAt(i) != 'F') {
						blnRetorno = false;
						break;
					}
				}
			} else if (intTipoNumeroEntrada == Numeracao.TIPO_ENTRADA_OCTAL) {
				for (i = 0; i < strNumero.length(); i++) {
					if (strNumero.charAt(i) != '0'
							&& strNumero.charAt(i) != '1'
							&& strNumero.charAt(i) != '2'
							&& strNumero.charAt(i) != '3'
							&& strNumero.charAt(i) != '4'
							&& strNumero.charAt(i) != '5'
							&& strNumero.charAt(i) != '6'
							&& strNumero.charAt(i) != '7') {
						blnRetorno = false;
						break;
					}
				}
			}
		}

		return blnRetorno;
	}

	private String asciiValor(int numero) {
		String retorno = "";

		if (numero <= 9) {
			retorno = Integer.toString(numero);
		} else {
			switch (numero) {
			case 10:
				retorno = "a";
				break;
			case 11:
				retorno = "b";
				break;
			case 12:
				retorno = "c";
				break;
			case 13:
				retorno = "d";
				break;
			case 14:
				retorno = "e";
				break;
			case 15:
				retorno = "f";
				break;
			}
		}
		return retorno;
	}

	private int valorAscii(char caracter) {
		int retorno = 0;

		switch (caracter) {
		case '0':
			retorno = 0;
			break;
		case '1':
			retorno = 1;
			break;
		case '2':
			retorno = 2;
			break;
		case '3':
			retorno = 3;
			break;
		case '4':
			retorno = 4;
			break;
		case '5':
			retorno = 5;
			break;
		case '6':
			retorno = 6;
			break;
		case '7':
			retorno = 7;
			break;
		case '8':
			retorno = 8;
			break;
		case '9':
			retorno = 9;
			break;
		case 'a':
			retorno = 10;
			break;
		case 'b':
			retorno = 11;
			break;
		case 'c':
			retorno = 12;
			break;
		case 'd':
			retorno = 13;
			break;
		case 'e':
			retorno = 14;
			break;
		case 'f':
			retorno = 15;
			break;
		}
		return retorno;
	}
}