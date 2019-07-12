package typecasting;

public class TypeCastDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a= 4;
		
		float b=3.5f;
		
		double d=12.945;
		
		System.out.println(" a is Assigned to b");
		b=(float)a;
		System.out.println("now b is "+b);
		
		System.out.println(" b is Assigned to a");
		a=(int)b;
		System.out.println("now b is "+a);
		
		System.out.println(" a is Assigned to d");
		d=(double)a;
		System.out.println("now b is "+d);
		
		System.out.println(" d is Assigned to b");
		b=(float)d;
		System.out.println("now b is "+b);
		
		System.out.println(" d is Assigned to a");
		a=(int)d;
		System.out.println("now b is "+a);
		
	}

}
