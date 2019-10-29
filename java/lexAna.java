/**
 *  Jacob Malimban
 *
 *
 */
import java.io.*;
import java.lang.Character;

public class lexAna {

	// definitions
	enum CharClass {
		LETTER, DIGIT, UNKNOWN, END_OF_FILE
	}
	enum Token {
		INT_LIT, IDENT, ASSIGN_OP, ADD_OP, SUB_OP, MULT_OP, DIV_OP, LEFT_PAREN, RIGHT_PAREN, END_OF_FILE
	}

	// variables
	static	CharClass charClass;
	static	char lexeme[] = new char[100];
	static	char nextChar;
	static	int lexLen;
	static	Token token;
	static	Token nextToken;
	static	String fileName = "lexInput.txt";
// "front.in";
	static	String line = null;

	public static void main(String[] args) {

		try {
			// print to file?
			if(true) {
				PrintStream o = new PrintStream(new File("lexOutput.txt"));
				System.setOut(o);
			}
		} catch (FileNotFoundException e) {}

		// formatting
		System.out.println("Jacob M. Student, CSCI4200, Fall 2019, Lexical Analyzer");
		for(int i = 0; i < 80; i++)
			System.out.print("*");
		System.out.println();

		// try creating readers
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);

			// read input line by line, and build each lexeme =
			while((line = bReader.readLine()) != null) {
				System.out.println("Input: " + line);
				getChar();

				for(char ch : line.toCharArray()) {
					lex();
					if(nextToken == Token.END_OF_FILE)
						break;
				}
			}

			bReader.close();
			System.out.println("Lexical analysis of the program is complete!");
		} catch (Exception e) {
			System.out.println("Error - file unopenable or readers not initialized.");
		}
	}

	/**
	 *  For unknown, non-alphanumerics, addChar() to lexeme[] and assign token
	 *
	 *
	 */
	private static Token lookup(char ch) {
		switch(ch) {
			case '=':
				addChar();
				nextToken = Token.ASSIGN_OP;
				break;
			case '+':
				addChar();
				nextToken = Token.ADD_OP;
				break;
			case '-':
				addChar();
				nextToken = Token.SUB_OP;
				break;
			case '*':
				addChar();
				nextToken = Token.MULT_OP;
				break;
			case '/':
				addChar();
				nextToken = Token.DIV_OP;
				break;
			case '(':
				addChar();
				nextToken = Token.LEFT_PAREN;
				break;
			case ')':
				addChar();
				nextToken = Token.RIGHT_PAREN;
				break;
			default:
				addChar();
				nextToken = Token.END_OF_FILE;
				break;
		}
		return nextToken;
	}

	/**
	 *  Adds nextChar to lexeme[]
	 *
	 *
	 */
	private static void addChar() {
	}

	/**
	 *  Determines class of nextChar
	 *
	 *
	 */
	private static void getChar() {
	}

	/**
	 *  Finds non-whitespace char
	 *
	 *
	 */
	private static void getNonBlank() {
		while(Character.isWhitespace(nextChar))
			getChar();
	}

	/**
	 *  Fully identifies lexeme[] and associated nextToken (with lookup if necessary)
	 *
	 *
	 */
	public static Token lex() {
	}
}
