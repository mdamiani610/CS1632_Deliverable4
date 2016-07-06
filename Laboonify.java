/* 
 * Matthew Damiani
 * this is the laboonify method that squares the value at each index in the array and adds an 
 * extra array index that is the sum of all the array values
*/
import java.util.Arrays;

public class Laboonify {
	/* 
	 * this main function is to simply show you that my laboonify function works, using the 
	 * example arrays given in the deliverable description
	*/
	public static void main(String[] args) {
		int[] sample1={1,2,3};
		int[] sample2={4};
		int[] sample3={10,10,10};
		int[] sample4={1,1,2,2,3,3};
		
		
		int[] result1 = laboonify(sample1);
		System.out.println(Arrays.toString(sample1)+" -> "+Arrays.toString(result1));
		int[] result2 = laboonify(sample2);
		System.out.println(Arrays.toString(sample2)+" -> "+Arrays.toString(result2));
		int[] result3 = laboonify(sample3);
		System.out.println(Arrays.toString(sample3)+" -> "+Arrays.toString(result3));
		int[] result4 = laboonify(sample4);
		System.out.println(Arrays.toString(sample4)+" -> "+Arrays.toString(result4));
		
	}
	/* 
	 * this is the actual laboonify() function that will be tested using unit tests
	*/
	static int[] laboonify(int[] original){
		
		int[] result= new int[original.length+1];
		int i;
		int sum=0;
		
		
		for( i=0; i<original.length; i++){
			
			result[i]=original[i]*original[i];
			sum = sum + result[i];
			
		}
		
		result[i]=sum;
		
		
		return result;
	}
	
}
