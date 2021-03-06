import java.util.Scanner;

public class FracCalc {
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
		int[] answerparts = new int[2];
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
		
		if(str.indexOf("+")>0){
			answerparts = add(num1, denom1, num2, denom2);
		}
		else if(str.indexOf(" - ")>0){
			answerparts = subtract(num1, denom1, num2, denom2);
		}
		else if(str.indexOf("*")>0){
			answerparts = multiply(num1, denom1, num2, denom2);
		}
		else if(str.indexOf(" / ")>0){
			answerparts = divide(num1, denom1, num2, denom2);
		}
		
		if(answerparts[0] == 0){
			answer = "0";
		}
		else if(Calculate.isDivisibleBy(answerparts[0], answerparts[1])==true){
			int ans = answerparts[0] / answerparts[1];
			answer = ans+"";
		}
		else{
			answer = reduce(answerparts[0], answerparts[1]);
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
		if (opnum[0]<0){
			opnum[1] = -1*opnum[1];
		}
		return opnum;
	}
	
	public static int[] add(int num1, int denom1, int num2, int denom2){
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
		int [] answer = {numerator, denominator};
		return answer;
	}
	public static int[] subtract(int num1, int denom1, int num2, int denom2){
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
		int [] answer = {numerator, denominator};
		return answer;
	}
	public static int[] multiply(int num1, int denom1, int num2, int denom2){
		int numerator = num1 * num2;
		int denominator = denom1 * denom2;
		int [] answer = {numerator, denominator};
		return answer;
	}
	public static int[] divide(int num1, int denom1, int num2, int denom2){
		int numerator = num1*denom2;
		int denominator = num2*denom1;
		int [] answer = {numerator, denominator};
		return answer;
	}
	
	public static String reduce(int num, int denom){
		int gcf = Calculate.min(num, denom);
		while(num%gcf != 0 && denom%gcf != 0 && gcf>0){
			gcf--;
		}
		num = num/gcf;
		denom = denom/gcf;
		if (denom == 1){
			return (num+"");
		}
		else if (num>denom){
			return Calculate.toMixedNum(num, denom);
		}
		else{
			return (num+"/"+denom);
		}
	}
}
