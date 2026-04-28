package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	/**
	 * 'a' -> a
	 * '\123' -> el caracter ascii 123
	 * '\t' -> return \t
	 * @param str
	 * @return
	 */
	public static char lexemeToChar(String str) {
		try {
			// 1 - Quitamos las comillas simples
			String inner = str.substring(1, str.length() - 1);
			// 2. Si empieza por \, es una secuencia de escape
			if (inner.startsWith("\\")) {
				// Caso: Código ASCII numérico (ej: '\123')
				if (inner.length() > 1 && Character.isDigit(inner.charAt(1))) {
					return (char) Integer.parseInt(inner.substring(1));
				}
				// Caso: Escapes especiales (ej: '\n')
				if (inner.length() == 2) {
					switch (inner.charAt(1)) {
						case 'n':  return '\n';
						case 't':  return '\t';
						case 'r':  return '\r';
						case 'b':  return '\b';
						case '\\': return '\\';
						case '\'': return '\'';
					}
				}
			}
			// 3. Caso normal: un solo carácter 'a'
			return inner.charAt(0);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return 'e';
	}

	public static double lexemeToReal(String str) {
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1.0;
	}

}
