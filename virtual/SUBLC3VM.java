public class SUBLC3VM {
	private static int basePointer;
	private static String[100] stack; 
	private static HashMap<String, int> vars = new HashMap<String, int>();

	public static void main(String[] args) {
	}

	private static void ADD(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = src1; 
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = src2;
		vars.put(dest, num1 + num2); 
	} 

	private static void SUB(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = src1; 
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = src2;
		vars.put(dest, num1 - num2);
	} 

	private static void MUL(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = src1; 
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = src2;
		vars.put(dest, num1 * num2);
	}

	private static void DIV(String dest, String src1, String src2) {
		int num1, num2;
		if(vars.containsKey(src1))  //src1 is a var
			num1 = vars.get(src1);
		else	// what if its a new var??
			num1 = src1; 
		if(vars.containsKey(src2))  //src2 is a var
			num2 = vars.get(src2);
		else
			num2 = src2;
		vars.put(dest, num1 /num2);
	}

	private static void IN(String var) {
		vars.put(var, scan.getLine());
	}

	private static void OUT(String out) {
		if(vars.containsKey(out))
			out = vars.get(out);
		System.out.println(out);
	}

	private static void STO (String var, String data) {
		if(vars.containsKey(var)) {
			// update
			vars.put(var, data);
		} else {
			vars.put(var, data);
		}
	}

	// control instructions
	private static int findLabel(String label) {
		for(int i = 0; I < stack.length; i++) {
			if(stack[i].equals(label))
				return i;
		}
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
		String verified;
		char c = ident.charAt(0);
		// starts with a letter
		If(c >= a && c <= z || c >= A && c <=Z)
			verified += c;
		else
			return false;

		// { letter | digit | _ }
		
	}
}

