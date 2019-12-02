import java.io.*;
import java.util.*;
/**
 * Jacob Malimban - CSCI 4200, Fall 2019 Virtual Machine
 *
 */

public class SUBLC3VM {
	private static final int MAX_MEMORY_SIZE = 500, asterisk = 46;
	private static int stackPointer = 0;
	private static String[] stack = new String[MAX_MEMORY_SIZE];
	private static HashMap<String, Integer> vars = new HashMap<String, Integer>();
	private static HashMap<String, Integer> labels = new HashMap(vars);
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

	        try {
	            // print to file?
	            if(false) {
	                PrintStream o = new PrintStream(new File("mySubLC3_Output.txt"));
	                System.setOut(o);
	            }
	        } catch (FileNotFoundException e) {}

		// scan in file name
		//System.out.print("Enter the file name:\n> ");
		String fileName = "mySubLC3_Prog.txt";





		// for each line, read into stack
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;

			System.out.println("Jacob Malimban, CSCI 4200, Fall 2019");
			for(int i = 0; i < asterisk; i++)
				System.out.print("*");
			System.out.println();

			while((line = bReader.readLine()) != null) {
					if(stackPointer+1 > stack.length) {
						System.out.println("Program is too large");
						return;
					}

					stack[stackPointer++] = line;
					System.out.println("\t" + line);
			}

			// end of file reached
			bReader.close();

			for(int i = 0; i < asterisk; i++)
				System.out.print("*");
			System.out.println();

		} catch (Exception e) {
			System.out.println("Error - file unopenable or readers not initialized.");
		}

		// begin execution
		stackPointer = 0;

		while(true) {
			String[] split;
			String instruction = stack[stackPointer];
			stackPointer++;

			//decode
			if(instruction.charAt(0) == ';') { // ignore comments
				continue;
			} else {
				split = instruction.split(" ");
//				System.out.println(split[0]);
			}

			//execute
			if(split[0].equals("HALT")) // end after halt
				break;
			execute(split, instruction);
	        }


	}

	// helper method to take decoded instruction and find next method
	private static void execute(String[] splits, String inst) {
		switch(splits[0]) {
			case "ADD" :
				ADD(splits[1], splits[2], splits[3]);
				break;
			case "BRn" :
				BRn(splits[1], splits[2]);
				break;
			case "BRp" :
				BRp(splits[1], splits[2]);
				break;
			case "BRz" :
				BRz(splits[1], splits[2]);
				break;
			case "BRzn" :
				BRp(splits[1], splits[2]);
				break;
			case "DIV" :
				DIV(splits[1], splits[2], splits[3]);
				break;
			case "IN" :
				IN(splits[1]);
				break;
			case "JMP" :
				JMP(splits[1]);
				break;
			case "MUL" :
				MUL(splits[1], splits[2], splits[3]);
				break;
			case "OUT" :
				String str = inst.substring(4);
				OUT(str);
				break;
			case "STO" :
				STO(splits[1], splits[2]);
				break;
			case "SUB" :
				SUB(splits[1], splits[2], splits[3]);
				break;
			default:
				if(chkIdent(splits[0]))
					break;
				System.out.println("Statement invalid");
		}
	}

	// Take two var/int const sources
	// Store sum in dest variable
	private static void ADD(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = Integer.parseInt(src1);
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = Integer.parseInt(src2);
		vars.put(dest, num1 + num2);
	} 

	// Take two var/int const sources
	// Store difference in dest variable
	private static void SUB(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = Integer.parseInt(src1);
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = Integer.parseInt(src2);
		vars.put(dest, num1 - num2);
	} 

	// Take two var/int const sources
	// Store product in dest variable
	private static void MUL(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = Integer.parseInt(src1);
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = Integer.parseInt(src2);
		vars.put(dest, num1 * num2);
	}

	// Take two var/int const sources
	// Store result in dest variable
	private static void DIV(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = Integer.parseInt(src1);
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = Integer.parseInt(src2);
		vars.put(dest, num1 /num2);
	}

	// Accept input and store in var
	private static boolean IN(String var) {
		int in;
		try{
		    in = Integer.parseInt(scan.nextLine());
		}catch (NumberFormatException ex) {
			System.out.println("Invalid number, try again:");
			return IN(var);
		}
		vars.put(var, in);
		return true;
	}

	// out is either a variable, String, or int
	// output value
	private static void OUT(String out) {
		String output = out;
		if(vars.containsKey(out))
			output = "" + vars.get(out);

		else if(out.charAt(0) == '"') //remove quotes
			output = out.substring(1, out.length() -1);

		System.out.println(output);
	}

	// stores source data (variable or int) in destination var
	private static void STO (String var, String data) {
		int src;
		if(vars.containsKey(data)) // source data is var
			src = vars.get(data);
		else
			src = Integer.parseInt(data);

		// hashmaps either add or update
		vars.put(var, src);
	}

	/* control instructions */

	// helper method to findLabel
	private static int findLabel(String label) {
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].equals(label))
				return i;
		}
		return -1;
	}

	// if variable is negative, jump to label
	private static void BRn(String var, String label) {
		if(vars.get(var) < 0)
			stackPointer = findLabel(label);
	} 

	// if variable is zero, jump to label
	private static void BRz(String var, String label) {
		if(vars.get(var) == 0)
			stackPointer = findLabel(label);
	} 

	// if variable is positive, jump to label
	private static void BRp(String var, String label) {
		if(vars.get(var) > 0)
			stackPointer = findLabel(label);
	} 

	// if variable is zero or positive, jump to label
	private static void BRzp(String var, String label) {
		if(vars.get(var) > -1)
			stackPointer = findLabel(label);
	} 

	// if variable is zero or negative, jump to label
	private static void BRzn(String var, String label) {
		if(vars.get(var) < 1)
			stackPointer = findLabel(label);
	}

	// jump to label
	private static void JMP(String label) {
		stackPointer = findLabel(label);
	}

	// helper method to verify legal ident
	private static boolean chkIdent(String ident) {
		String verified = "";
		char fc = ident.charAt(0);

		// starts with a letter
		if(fc >= 'a' && fc <= 'z' || fc >= 'A' && fc <= 'Z')
			verified += fc;
		else
			return false;


		// { letter | digit | _ }
		for(char c : ident.substring(1).toCharArray()) {
			if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
				continue;
			if(c >= '0' && c <= '9')
				continue;
			if(c == '_')
				continue;
			return false;
		}

		return true;
	}
}

