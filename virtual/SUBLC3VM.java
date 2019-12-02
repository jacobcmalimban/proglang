import java.io.*;
import java.util.*;
/**
 * Jacob Malimban - CSCI 4200, Fall 2019 Virtual Machine
 *
 */

public class SUBLC3VM {
	private static int basePointer, stackPointer;
	private static String[] stack = new String[100];
	private static HashMap<String, Integer> vars = new HashMap<String, Integer>();
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

        try {
            // print to file?
            if(false) {
                PrintStream o = new PrintStream(new File("virtualOutput.txt"));
                System.setOut(o);
            }
        } catch (FileNotFoundException e) {}

		basePointer = stackPointer = 0;
		
		// scan in file name
		System.out.print("Enter the file name:\n> ");
		String fileName = "sampleLC3";
		
		// for each line, read into stack
		try {
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			String line;

			while((line = bReader.readLine()) != null) {
					if(stackPointer+1 > stack.length) {
						System.out.println("Program is too large");
						return;
					}
						
					stack[stackPointer++] = line;
			}

			// end of file reached
			bReader.close();

			System.out.println("Program read successfully!");
		} catch (Exception e) {
			System.out.println("Error - file unopenable or readers not initialized.");
		}
		
		
		// execute
		for(int i = 0; i < stack.length; i++){
			String instruction = stack[i];
			if(instruction == "HALT")
				return;
			System.out.println(stack[i]);
	        }
	}

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

	private static void OUT(String out) {
		if(vars.containsKey(out))
			out = "" + vars.get(out);
		else
			out = "Variable not found";
		System.out.println(out);
	}

	private static void STO (String var, String data) {
		// hashmaps either add or update
		vars.put(var, Integer.parseInt(data));
	}

	// control instructions
	private static int findLabel(String label) {
		for(int i = 0; i < stack.length; i++) {
			if(stack[i].equals(label))
				return i;
		}
		return -1;
	}

	private static void BRn(String var, String label) {
		if(vars.get(var) < 0)
			basePointer = findLabel(label);
	} 
	private static void BRz(String var, String label) {
		if(vars.get(var) == 0)
			basePointer = findLabel(label);
	} 
	private static void BRp(String var, String label) {
		if(vars.get(var) > 0)
			basePointer = findLabel(label);
	} 
	private static void BRzp(String var, String label) {
		if(vars.get(var) > -1)
			basePointer = findLabel(label);
	} 
	private static void BRzn(String var, String label) {
		if(vars.get(var) < 1)
			basePointer = findLabel(label);
	}

	// other controls
	private static void JMP(String label) {
		basePointer = findLabel(label);
	}

	// 
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

