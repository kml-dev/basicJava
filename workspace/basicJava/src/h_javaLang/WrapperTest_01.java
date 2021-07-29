package h_javaLang;

import java.util.Arrays;

public class WrapperTest_01 {
	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		System.out.println(i1);
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Integer.SIZE);
		
		// JDK 1.8
		// Integer.BYTES
		
		Integer[] iArr = new Integer[3];
		iArr[0] = new Integer(10);
		iArr[1] = new Integer(20);
		iArr[2] = 30;             // auto-boxing
		System.out.println(Arrays.toString(iArr));
		
		int i3 = iArr[1];  		  // unBoxing
		System.out.println(i3);
		
		Object[] obj = new Object[1];
		obj[0] = 10;			  // auto-boxing + upCasting
		
		int o2 = (int)obj[0];
		
	}
}
