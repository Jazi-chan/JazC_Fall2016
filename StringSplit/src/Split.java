import java.util.Arrays;

public class Split {
	public static void main(String[] args) 
	{
		//String.split();
		//It's a method that acts on a string, <StringName>.split(<String sp>);
		//Where sp is the string where the string splits
		//And it returns an array
		"I like apples!".split(" "); 
		//		it will split at spaces and return an array of ["I","like","apples!"]
		// Example 2: "I really like really red apples"split("really")
		//		it will split at the word "really" and return an array of ["I "," like "," apples!"]
		
		System.out.println(Arrays.toString("I reallyreally like apples".split("really")));
		System.out.println();
		sandwichSplit("applespineapplesbreadlettustomatobaconmayohambreadcheese");
		sandwichSplit("breadcheesetomatobreadmayomeatbread");
		sandwichSplit("applebreadcheese");
		System.out.println();
		sandwichSpaces("apples pineapples bread lettus tomato bacon mayo ham bread cheese");
		sandwichSpaces("bread cheese tomato bread mayo meat bread");
		sandwichSpaces("apple bread cheese");
	}
		
		//Your task:
		/*Write a method that take in a string like "applespineapplesbreadlettustomatobaconmayohambreadcheese" describing a sandwich
		 * use String.split to split up the sandwich by the word "bread" and return what's in the middle of the sandwich and ignores what's on the outside
		 * What if it's a fancy sandwich with multiple pieces of bread?
		*/
	public static void sandwichSplit(String sandwich){
		if (sandwich.indexOf("bread")<0){
			System.out.println("This isn't a sandwich.");
			return;
		}
		String breadfinder= sandwich.substring(sandwich.indexOf("bread")+5);
		sandwich=breadfinder;
		if (sandwich.indexOf("bread")<0){
			System.out.println("This isn't a sandwich.");
			return;
		}
		while(breadfinder.indexOf("bread")>=0){
			breadfinder = breadfinder.substring(breadfinder.indexOf("bread")+5);
		}
		String[] filling = sandwich.split("bread");
		if ((breadfinder.trim()).equals("")){
			for (int i=0; i<filling.length; i++){
				System.out.print(filling[i]);
			}
		}
		else{
			for(int i = 0; i<filling.length-1; i++){
				System.out.print(filling[i]);
			}
		}
		System.out.println();
	}
		
		//Your task pt 2:
		/*Write a method that take in a string like "apples pineapples bread lettus tomato bacon mayo ham bread cheese" describing a sandwich
		 * use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of the sandwich and ignores what's on the outside
		 * Again, what if it's a fancy sandwich with multiple pieces of bread?
		*/
	public static void sandwichSpaces(String sandwichwithspace){
		sandwichwithspace=sandwichwithspace.trim();
		String[] fillingarray = sandwichwithspace.split(" ");
		String sandwich = ""; 
		for (int i=0; i<fillingarray.length; i++){
			sandwich = sandwich+fillingarray[i];
		}
		sandwichSplit(sandwich);
	}
		

	

}
