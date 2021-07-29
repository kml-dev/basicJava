package h_javaLang;

import java.util.Arrays;

public class StringTest_02 {
	public static void main(String[] args) {
		// char charAt(int index) : 문자열에서 지정된 index번째 문자 하나를 돌려준다.
//		String s= "Hello";
//		char ch  = s.charAt(2);
//		System.out.println(ch);
//		
//		// oracle에서도 사용되는 것
//		// String concat(String str) : 기존 문자열에 새로운 문자열을 덧붙인다
//		String s2 = s.concat(" jQuery");
//		System.out.println(s2);
//		
//		// boolean contains(String str) : 기존 문자열이 해당 문자열을 포함하고 있는지 확인한다.
//		boolean s3 = s2.contains("jQ");
//		System.out.println(s3);
//		
//		// 확장자 처리에 필요한 것
//		// boolean endswith(String str) : 문자열이 str로 끝나는지 확인한다.
//		String s4 = "은서가 외로워하고 있어요 미라야...~!.hwp";
//		boolean re = s4.endsWith(".hwp");
//		System.out.println(re);
//		
//		// 그 외
//		// 1. int lastIndexOf() : 지정된 문자 또는 문자코드 문자열의 오른쪽 끝에서부터 찾아서 
//		// 						    위치를 반환 해준다. 못 찾으면 -1을 반환한다.
//		System.out.println(s2.lastIndexOf("k"));
//		
//		// 2. String replace(String oldStr, String newStr)
//		// 기존 문자열을 새로운 문자열로 변환
//		String s5 = s2.replace("jQuery", "Java");
//		System.out.println(s5);
//		
//		// 3. String[] split(구분자) : 문자열을 지정한 구분자로 나누어 문자열형 배열에 저장한다.
//		String s6 = "100,,,200,,300,400";
//		String[] sArr = s6.split(",,");
//		System.out.println(Arrays.toString(sArr));
//		
//		// 4. String subString(int start, int end)
//		// 주어진 문자열을 시작부터 끝 위치 범위에 포함된 문자열을 얻는다.
//		String s7 = s5.substring(2, 6); // He llo Java
//		System.out.println(s7);
//		
//		// 5. String trim() : 주어진 문자열 양 끝의 공백을 제거해준다.
//		String s8 = "    eun    seo    ";
//		String s9 = s8.trim();
//		System.out.println(s9);
		
		// 6. int compareTo(String str) : 문자열과 사전순서를 비교하여 같으면 0, 사전순 이전이면 음수, 이후면 양수를 리턴
//		String a = "abcd";
//		int num = a.compareTo("ab"); 
//		System.out.println(num);  // 2인 이유는 a에서 "ab"를 포함하고 있기 때문에 문자열 길이 차이를 리턴
//		int num2 = a.compareTo("c");
//		System.out.println(num);  // 2인 이유는 맨 앞에서 이미 c와 다르기 때문에 첫번쨰 'a' 와 'c'의 차이를 리턴
//		int num3 = a.compareTo("f");
//		System.out.println(num3); // -5인 이유는 a 와 f의 아스키 코드 값 차이
		
		// 7. String toLowerCase() : 저장되어 있는 모든 문자열을 소문자로 바꿔서 String으로 리턴
//		String a = "ABBBBB";
//		String b = a.toLowerCase();
//		System.out.println(b);
		
		// 8. String toUpperCase() : 저장되어 있는 모든 문자열을 대문자로 바꿔서 String으로 리턴
//		String a = "aBBBCCc";
//		String b = a.toUpperCase();
//		System.out.println(b);
		
		// 9. static String valueOf() : 지정된 값을 문자열로 변환하여 반환
//		int a = 123;
//		boolean b = false;
//		char c = 'a';
//		String str1 = String.valueOf(a);
//		String str2 = String.valueOf(b);
//		String str3 = String.valueOf(c);
//		
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str3);
		
		
		
		
	}
}
