import java.util.Arrays;
public class LotsOfCopies {

	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		System.out.println();
		
		changeMe(num, strMain, arrMain);
		
		System.out.println(num);
		System.out.println(strMain);
		System.out.println(Arrays.toString(arrMain));
		System.out.println();
		
		int[] a = {3, 4, 5};
		int[] b = a;
		a[1]= 26;
		System.out.println(Arrays.toString(b));
		b[2] = 0;
		System.out.println(Arrays.toString(a));
	}
	public static void changeMe(int x, String str, int[] arr){
		x++;
		str = str.substring(0,str.length()-2);
		arr[1]=8;
	}
}