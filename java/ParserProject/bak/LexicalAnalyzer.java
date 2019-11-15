/**
 *  Jacob Malimban
 *
 *
 */
import java.io.*;
import java.lang.Character;

public class LexicalAnalyzer {

	// definitions
	enum CharClass {
		LETTER, DIGIT, UNKNOWN, END_OF_LINE
	}
/** /
	enum Token {
		INT_LIT, IDENT, ASSIGN_OP, ADD_OP, SUB_OP, MULT_OP, DIV_OP, LEFT_PAREN, RIGHT_PAREN, END_OF_LINE, END_OF_FILE
	}
/**/

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

			// read input line by line, and build lexemes in each line
			while((line = bReader.readLine()) != null) {
				System.out.println("Input: " + line);
				getChar();

				for(char ch : line.toCharArray()) {
					lex();
					if(nextToken == Token.END_OF_LINE)
						break;
				}
			}

			// end of file reached
			bReader.close();

			lexeme[0] = 'E';
			lexeme[1] = 'O';
			lexeme[2] = 'F';
			lexeme[3] = '\u0000';
			lexLen = 4;
			nextToken = Token.END_OF_FILE;

			System.out.printf("%s%-20s%s%s%n", "Next Token is: ", nextToken, "next lexeme is ", String.valueOf(lexeme).substring(0, lexLen));
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
				nextToken = Token.END_OF_LINE;
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
		if(lexLen <= 98) {
			lexeme[lexLen++] = nextChar;
			lexeme[lexLen] = '\u0000';
		} else {
			System.out.println("Error: Lexeme too long");
		}
	}

	/**
	 *  Determines class of charClass
	 *
	 *
	 */
	private static void getChar() {
		try {
			nextChar = line.charAt(0);
			line = line.substring(1);

			// nextChar is printable?
			if((int) nextChar > 32 && (int)nextChar != 127) {
				if(Character.isLetter(nextChar))
					charClass = CharClass.LETTER;
				else if(Character.isDigit(nextChar))
					charClass = CharClass.DIGIT;
				else
					charClass = CharClass.UNKNOWN;
				return;
			}
		} catch(Exception e){}

		// either end of file or whitespace
		charClass = CharClass.END_OF_LINE;
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
		lexLen = 0;
		getNonBlank();
		switch(charClass) {
			case LETTER:
				do {
					addChar();
					getChar();
				} while(charClass == CharClass.LETTER || charClass == CharClass.DIGIT);

				nextToken = Token.IDENT;
				break;

			case DIGIT:
				do {
					addChar();
					getChar();
				} while(charClass == CharClass.DIGIT);

				nextToken = Token.INT_LIT;
				break;

			case UNKNOWN:
				lookup(nextChar);
				getChar();
				break;

			case END_OF_LINE:
/** /
				for(int i = 0; i<80; i++)
					System.out.print("*");
				System.out.println();
/**/
				EOL();
				return nextToken = Token.END_OF_LINE;
		}
		System.out.printf("%s%-20s%s%s%n", "Next Token is: ", nextToken, "next lexeme is ", String.valueOf(lexeme).substring(0, lexLen));
		return nextToken;
	}

	public static void EOL(){		//update line
		getChar();
	}
}
