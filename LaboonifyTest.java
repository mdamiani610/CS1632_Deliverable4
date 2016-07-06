/* 
 * Matthew Damiani
 * this is the test file for the laboonify() method. This test file contains test for 3
 * different properties
*/
import static org.junit.Assert.*;
import java.util.Random;

import org.junit.Test;
public class LaboonifyTest {

	/* 
	 * Helper method to do all the work of calculating the 100 randomly sized arrays of random
	 * values
	 * Return value is in the form of a 2D array, can be thought of as one big array containing 
	 * all of the 100 randomly generated arrays
	*/
	public int[][] get100RandomArrays() {
		Random rand = new Random();
		int[][] randomArrays = new int[100][];
		
		for( int i=0; i<100; i++ ){
			
			int  n1 = rand.nextInt(10) + 1;
			int[] randomArray = new int[n1];
			for( int j=0; j<n1; j++ ){
				int  n2 = rand.nextInt(10) + 1;
				
				randomArray[j]=n2;
			}
			randomArrays[i]=randomArray;
		}
		return randomArrays;
    }
	
	@Test
	/* 
	 * This tests the size property where the size of the array returned by laboonify() is
	 * expected to be 1 greater than the array passed into the laboonify() function. This is
	 * because the laboonify() function adds and extra value to the array which is the sum of
	 * all the squared original arrays values
	*/	
	public void testPropertySize() {
		
		int[][] randomArrays = get100RandomArrays();
		boolean result=false;
		boolean expResult=true;
		
		for( int i=0; i<100; i++ ){
			
			int[] laboonifyArray = Laboonify.laboonify(randomArrays[i]); 
			if(laboonifyArray.length==randomArrays[i].length+1){
				result=true;
			}
			else{
				result=false;
				fail();
			}
		}
		
		assertEquals(expResult, result);   
		
	}
	
	@Test
	/* 
	 * This tests the value property of each of the array values in the new array returned from
	 * the laboonify() function. It ensures that the corresponding index in the laboonify() 
	 * returned array is the squared value of the same index's value in the original array. 
	 * Lastly, it makes sure that the last index in the laboonify() array is the sum of all the
	 * values in the array returned by laboonify()
	*/	
	public void testPropertyValues() {
		
		int[][] randomArrays = get100RandomArrays();
		boolean result=false;
		boolean expResult=true;
		
		for( int i=0; i<100; i++ ){
			int[] laboonifyArray = Laboonify.laboonify(randomArrays[i]); 
			
			int j;
			int sum=0;
			
			
			
			for( j=0; j<randomArrays[i].length; j++ ){
				
				
				if(laboonifyArray[j]==(randomArrays[i][j]*randomArrays[i][j])){
					result=true;
				}
				else{
					result=false;
					fail();
				}
				sum=sum+laboonifyArray[j];
			}
			if(laboonifyArray[j]==sum){
				result=true;
			}
			else{
				result=false;
				fail();
			}
			
		}
		
		assertEquals(expResult, result);   
		
	}
	
	@Test
	/* 
	 * This tests the no less than property of each of the array values in the new array that was
	 * obtained by squaring the value at the same index in the original array. Since the last 
	 * value in the array returned from laboonify() is the sum of all the laboonify() array values
	 * and not obtained by squaring the corresponding index value from the original array, it is 
	 * not checked in this test. Also, we are only able to expect that squaring a value in the
	 * original array results in a value of equal or greater value because the range of possible
	 * array values for this project excludes numbers less than 1, which means squaring the positive
	 * integer greater than 1 will alway result in a larger number. This test checks that the 
	 * squared value at an index of the laboonify() array is no smaller than the value at
	 * the corresponding index in the original array.
	 * 
	*/			
	public void testPropertyNoLessThan() {
		
		int[][] randomArrays = get100RandomArrays();
		boolean result=false;
		boolean expResult=true;
		
		for( int i=0; i<100; i++ ){
			int[] laboonifyArray = Laboonify.laboonify(randomArrays[i]); 
			
			int j;
			
			
			
			for( j=0; j<randomArrays[i].length; j++ ){
				
				
				if(laboonifyArray[j]>=(randomArrays[i][j]*randomArrays[i][j])){
					result=true;
				}
				else{
					result=false;
					fail();
				}
				
			}
		
			
		}
		
		assertEquals(expResult, result);  
		
	}

}
