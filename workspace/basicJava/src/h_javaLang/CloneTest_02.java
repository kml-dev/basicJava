package h_javaLang;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;

public class CloneTest_02 {
	public static void main(String[] args) {
		Point p1 = new Point(100,100);
		Point p2 = new Point(200,200);
		Point p3 = new Point(100,200);
		
		Point[] pArr = {p1, p2, p3};
		
		Point[] pCopy = pArr.clone();
		
		System.out.println(Arrays.toString(pArr));
		System.out.println(Arrays.toString(pCopy));
		
		pArr[0].x = 700;
		
		System.out.println(Arrays.toString(pArr));
		System.out.println(Arrays.toString(pCopy));
	}
}

class Point implements Serializable{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y + "]";
	}
	
	
	
}