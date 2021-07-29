package h_javaLang;

import java.util.Arrays;

public class CloneTest_01 {
	public static void main(String[] args) {
		CloneEx ce = new CloneEx(1, 2);
		
		CloneEx ceClone = (CloneEx)ce.clone();
		
		ce.x = 50;
		
		System.out.println(ce);
		System.out.println(ceClone);
		
		CloneEx ce1 = new CloneEx(1, 2);
		CloneEx ce2 = new CloneEx(2, 3);
		CloneEx ce3 = new CloneEx(3, 4);
		
		CloneEx[] ceArr = {ce1, ce2, ce3};
		
		System.out.println(Arrays.toString(ceArr));
		
	}
}

class CloneEx implements Cloneable{
	int x;
	int y;
	
	CloneEx(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "CloneEx [x = " + x + ", y = " + y + "]";
	}

	@Override
	protected Object clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	
	
	
}