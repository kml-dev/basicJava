package h_javaLang;

import java.util.StringTokenizer;

public class STTest_01 {
	public static void main(String[] args) {
		String text = "100,,,200,,300,400";
		String[] sp = text.split("0,");
		
		for (int i = 0; i < sp.length; i++) {
			System.out.println(sp[i]);
		}
		
		System.out.println("============================================");
		StringTokenizer st = new StringTokenizer(text,"0,");
		
		while(st.hasMoreTokens()){
			System.out.println(st.nextToken());
		}
		
		
	}
}
