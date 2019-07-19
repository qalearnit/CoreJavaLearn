package aboutMethods;

/*
 * Same name for the method
 * Can contain different parameters
 * Can contain different return types
 * This is one of the types of polymorphism
 * In some cases, Java’s automatic type conversions can play a role in overload resolution
 * its compile time polymorphism
 * 
 */

public class OverloadMethods {
	
	public int sumOfNumbers(int a,int b)
	{
		return a+b;
	}
	
	public double sumOfNumbers(double a,double b)
	{
		return a+b;
	}
	
	public void sumOfNumbers()
	{
		System.out.println("This is a method with no return types");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OverloadMethods om = new OverloadMethods();
		
		System.out.println(om.sumOfNumbers(10.5, 20.9));
		
		System.out.println(om.sumOfNumbers(2, 6));
		om.sumOfNumbers();
	}

}
