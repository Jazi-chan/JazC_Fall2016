//Jasmine Carson with Kaitlyn Chan
import java.util.*;
public class ProccessigNumbers {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
//get number of repetitions
		System.out.println("How many numbers?");
		int loops = input.nextInt();
//get first number, initialize. Make it even to give starting point for evenmax.
		System.out.println("Enter your numbers separated by spaces. Start with an even number.");
		int max=input.nextInt();
		int min=max;
		int evenmax=max;
		int evensum = evenmax;
		int next;
//i<loops because we did the first number already
		for (int i=1; i<loops; i++){
			next=input.nextInt();
			if (next<=min){
				min=next;
				//find minimum
			}
			else if (next>=max){
				max=next;
				//find maximum
			}
			if (next%2==0){
				evensum=evensum+next;
				//find evens and add
				if(next>=evenmax){
					evenmax=next;
					//if even, check if more than evenmax, find max even.
				}
			}
		}
//return numbers
		System.out.println("Max is "+max+". Min is "+min+". Sum of evens is "+evensum+". Max even is "+evenmax+".");
	}
}
