package e_oop;

public class MemberCall {
	static int cv;
	int iv;
	
	static int cv2;
	int iv2 = iv;
	
	static void staticMethod1(){
		// cv, cv2, staticMethod2()
		// iv, iv2 => x
	}
	
	static void staticMethod2(){
		// cv, cv2, staticMethod2()
		// iv, iv2 => x
	}
	void instanceMethod1(){
		// iv, iv2, cv, cv2, staticMethod01(), staticMethod2()
	}
}
