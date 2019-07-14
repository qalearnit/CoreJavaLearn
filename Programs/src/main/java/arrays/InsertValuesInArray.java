package arrays;

import java.util.Scanner;

public class InsertValuesInArray {

	public void insertValues()
	{
	System.out.println("Enter the size of the array");
	Scanner scan = new Scanner(System.in);
	int len = scan.nextInt();
	
	int arr[]=new int[len];
	Scanner arrScan = new Scanner(System.in);
	
	for(int i=0;i<len;i++)
	{
		int lenArr = arrScan.nextInt();
		
		System.out.println(arr[i]);
	}
	
	
}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsertValuesInArray val = new InsertValuesInArray();
		
		val.insertValues();
	}

}
