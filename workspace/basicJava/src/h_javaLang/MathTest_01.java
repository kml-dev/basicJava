package h_javaLang;

import static java.lang.Math.*;
public class MathTest_01 {
	public static void main(String[] args) {
		double d = 3.1415926535;
		
		// 반올림
		System.out.println(round(d));
		
		// 올림
		System.out.println(ceil(d));
		
		// 버림
		System.out.println(floor(d));
		
		// 제곱
		System.out.println(pow(3, 2));
		
		// 루트
		System.out.println(sqrt(4));
		
		// Point2메서드의 getDistance메서드를 호출하여 두점사이의 거리를 구해주세요
		Point2 p1 = new Point2(100,100);
		Point2 p2 = new Point2(200,200);
		
		double re = p1.getDistance(p2);
		float result = round(re*100)/100f;
		
		System.out.println(result);
	}
}

class Point2{
	int x;
	int y;
	
	Point2(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[x = " + x + ", y = " + y + "]";
	}
	
	double getDistance(Point2 p2){
		double w = p2.x - this.x;
		double h = p2.y - this.y;
		double result = sqrt(pow(w,2) + pow(h,2));
		return result;
	}
	
	
}
