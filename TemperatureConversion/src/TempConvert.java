/**
 * @author Jasmine Carson  1st Period
 * TempConvert: converts fahrenheit to celsius
 * 8/30/16
 */
public class TempConvert {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double f = 77;
		double c;
		double coefficient = 5.0/9.0;
		c = coefficient * (f - 32);
		System.out.println("The Celsius value of "+f+" degrees Fahrenheit is "+c+" degrees Celsius.");
		f = 59;
		c = coefficient * (f - 32);
		System.out.println("The Celsius value of "+f+" degrees Fahrenheit is "+c+" degrees Celsius.");
	}

}
