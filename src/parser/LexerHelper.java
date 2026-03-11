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
	 * '\\t' -> return \t
	 * @param str
	 * @return
	 */
	public static char lexemeToChar(String str) {
		try {

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

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	
}
