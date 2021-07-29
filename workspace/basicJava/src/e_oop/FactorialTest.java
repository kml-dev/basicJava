package e_oop;

public class FactorialTest {
	public static void main(String[] args) {	
		long result = FactorialTest.factorial(5);
		System.out.println(result);		
	}
	
	static long factorial(int num){
		long result = 0;
		if(num == 1){
			result = 1;
		}else{
			result = num * factorial(num-1);
		}
		return result;
	}
}
