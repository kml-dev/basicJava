package e_oop;

public class PrintCallTest {
	public static void main(String[] args) {
		//7. 3번의 add메서드를 호출하여라.  	
		int result1 = MyAdd.add(3);
		System.out.println(result1);
		
	    //8. 4번의 add메서드를 호출하여라.
		MyAdd ma = new MyAdd();
		int result2 = ma.add(1, 2);
		System.out.println(result2);
		
	    //9. 5번의 add메서드를 호출하여라.
		long result3 = ma.add(50, 10L);
		System.out.println(result3);
		
	    //10. 6번의 add메서드를 호출하여라.
		float result4 = ma.add('A',3f);  
		System.out.println(result4);    
		
		//11. 8번의 add메서드를 호출하여라.
		float result5 = ma.add(1,2L,3f);
		System.out.println(result5);
		
	}
}

class MyAdd {
	//1. 클래스변수 a를 선언하고 20의 값으로 초기화 하여라.
	static int a = 20;
	
	//2. 인스턴스변수 b를 선언하고 15의 값으로 초기화 하여라.
	int b = 15;
	
	//3. int타입의 매개변수가 하나이며 변수 a와 합을 반환하는 클래스메서드를 add를 작성하여라.
	static int add(int num1){
		int result = num1 + a;         
		return result;
	}

	//4. int타입의 매개변수가 두개이고 매개변수의 합을 반환하는 인스턴스메서드를 add를 작성 하여라.
	int add(int num1, int num2){
		int result = num1 + num2;
		return result;
	}


    //5. int타입, long타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스메서드 add를 작성 하여라.
	long add(int num1, long num2){
		long result = num1 + num2;
		return result;
	}

	//6 char타입, float타입 각 한 개의 매개변수, 매개변수의 합을 반환하는 인스턴스메서드 add를 작성 하여라.
	float add(char chr1, float num1){
		float result = chr1 + num1;
		return result;
	}
	//7. int타입의 매개변수가 두개이고 매개변수의 합을 반환하는 반환 타입이 long인 인스턴스 메서드add를 작성 하여라.
//	long add(int num1, int num2){	// 매개변수 타입이 2개 다 일치하는 인스턴스 메서드가 이미 있기 때문에
//		int result = num1 + num2;  // 힙스택에 인스턴스가 로드 될 때 구분을 할 수 없음
//		return result;
//	}
	
//	//8. int, long, float타입 각 한개의 매개변수, 매개변수의 합을 반환하는 클래스 메서드 add를 작성하여라.
//	// 클래스 변수를 사용하지 않기 때문에 인스턴스 메서드로 만드는게 더 효율적임.
//	/*static*/ float add(int num1, long num2, float num3){
//		float result = num1 + num2 + num3;
//		return result;
//	}
}