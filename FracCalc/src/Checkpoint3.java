import java.util.Scanner;

public class Checkpoint3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String statement = input.nextLine();
		while (!statement.equals("quit")){
			System.out.println(produceAnswer(statement));
			statement = input.nextLine();
		}	
	}
	
	
	public static String produceAnswer(String str){
		String op1 = str.substring(0, str.indexOf(" "));
		String op2 = str;
		String answer = "";
		if(str.indexOf("+")>0){
			op2 = str.substring(str.indexOf(" + ")+3);
		}
		else if(str.indexOf(" - ")>0){
			op2 = str.substring(str.indexOf(" - ")+3);
		}
		else if(str.indexOf("*")>0){
			op2 = str.substring(str.indexOf(" * ")+3);
		}
		else if(str.indexOf(" / ")>0){
			op2 = str.substring(str.indexOf(" / ")+3);
		}
		int[] firstOp = parseOperand(op1);
		int[] secondOp = parseOperand(op2);
		String improp1 = Calculate.toImproperFrac(firstOp[0], firstOp[1], firstOp[2]);
		String improp2 = Calculate.toImproperFrac(secondOp[0], secondOp[1], secondOp[2]);
		int num1 = Integer.parseInt(improp1.substring(0, improp1.indexOf("/")));
		int denom1 = Integer.parseInt(improp1.substring(improp1.indexOf("/")+1));
		int num2 = Integer.parseInt(improp2.substring(0, improp2.indexOf("/")));
		int denom2 = Integer.parseInt(improp2.substring(improp2.indexOf("/")+1));
		
		if (firstOp[0]<0){
			num1 = -num1;
		}
		if (secondOp[0]<0){
			num2 = -num2;
		}
		
		if(str.indexOf("+")>0){
			answer = add(num1, denom1, num2, denom2);
		}
		else if(str.indexOf(" - ")>0){
			answer = subtract(num1, denom1, num2, denom2);
		}
		else if(str.indexOf("*")>0){
			answer = multiply(num1, denom1, num2, denom2);
		}
		else if(str.indexOf(" / ")>0){
			answer = divide(num1, denom1, num2, denom2);
		}
		
		return answer;
	}
	
	public static int[] parseOperand(String op1){
		String numerator1 = "0";
		String denominator1 = "1";
		String whole1 = "0";
		String[] operand = new String[3];
		if (op1.indexOf("_")>0){
			whole1 = op1.substring(0, op1.indexOf("_"));
			if(op1.indexOf("/")>0){
				numerator1 = op1.substring(op1.indexOf("_")+1, op1.indexOf("/"));
				denominator1 = op1.substring(op1.indexOf("/")+1);
			}
			else{
				numerator1 = "0";
				denominator1 = "1";
				whole1 = op1.substring(0);
			}
		}
		else{
			if(op1.indexOf("/")>0){
				numerator1 = op1.substring(0, op1.indexOf("/"));
				denominator1 = op1.substring(op1.indexOf("/")+1);
			}
			else{
				whole1 = op1;
			}
		}
		operand[0] = whole1;
		operand[1] = numerator1;
		operand[2] = denominator1;
		int[] opnum = new int[3];
		for (int i = 0; i<3; i++){
			opnum[i] = Integer.parseInt(operand[i]);
		}
		return opnum;
	}
	
	public static String add(int num1, int denom1, int num2, int denom2){
		int numerator;
		int denominator;
		if (denom2 == denom1){
			denominator = denom1;
			numerator = num1 + num2;
		}
		else{
			denominator = denom1*denom2;
			numerator = (num1*denom2) + (num2 * denom1);
		}
		return (numerator+"/"+denominator);
	}
	public static String subtract(int num1, int denom1, int num2, int denom2){
		int numerator;
		int denominator;
		if (denom2 == denom1){
			denominator = denom1;
			numerator = num1 - num2;
		}
		else{
			denominator = denom1*denom2;
			numerator = (num1*denom2) - (num2 * denom1);
		}
		return (numerator+"/"+denominator);
	}
	public static String multiply(int num1, int denom1, int num2, int denom2){
		int numerator = num1 * num2;
		int denominator = denom1 * denom2;
		return(numerator+"/"+denominator);
	}
	public static String divide(int num1, int denom1, int num2, int denom2){
		int numerator = num1*denom2;
		int denominator = num2*denom1;
		return(numerator+"/"+denominator);
	}
}