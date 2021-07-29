package i_reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx_01 {
	public static void main(String[] args) {
		/*
		 1. 정규식이란?
		   - 텍스트 데이터 중에서 원하는 조건과 일치하는 문자열을 찾기 위해 만들어 졌다.
		   - 정규식의 구성
		     : Pattern클래스를 이용하여 정규식을 정의한다.
		     : Matcher클래스를 이용하여 데이터를 비교한다.
		 */
		
		Pattern p = Pattern.compile("[a-z]*");
		
		Matcher m = p.matcher("asdf");
		
		System.out.println(m.matches());
		
		/*
		 ^  문자열의 시작
		 $  문자열의 끝
		 .  임의의 한문자 단. \는 제외
		 *  앞 문자가 없을 수도 무한정 있을 수도 있다.
		 +  앞 문자가 한번 이상 
		 ?  앞 문자가 없거나 하나
		 [] 문자의 집합이나 범위를 표현한다. [^ ] not의 의미
		 {} 횟수 또는 범위를 나타낸다. 
		 () 소괄호 안의 문자를 하나의 문자로 인지 (010)
		 |  패턴 안에서 or의 의미를 가진다. (1|2)
		 
		 \s 공백문자
		 \S 공백문자를 제외한 모든 문자
		 \w 알파벳 또는 숫자
		 \d 숫자 [0-9] \\d : 문자열 안에서 쓰려면 이렇게 해야함
		 
		 */
		
		// 1. 영어 소문자 2개 또는 3개로 이루어진 정규식
		Pattern p2 = Pattern.compile("[a-z]{2,3}");
		Matcher m2 = p2.matcher("a");
		System.out.println(m2.matches());
		
		String regEx01 = "[a-z]{2,3}";
		System.out.println(Pattern.matches(regEx01, "asd"));
		
		// 2. 영문자가 3회 나온 다음 숫자가 없을수도 무제한 있을 수도 있다.
		String regEx02 = "[a-zA-Z]{3}[\\d]*";
		System.out.println(Pattern.matches(regEx02, "asd"));
		System.out.println("===============================");
		// 3. 숫자3개 - 숫자4개 - 숫자 4개
		String regEx03 = "[\\d]{3}-[\\d]{4}-[\\d]{4}";
		System.out.println(Pattern.matches(regEx03, "111-1111-1111"));
		System.out.println("===============================");
		
		// 4. 010               - 0이 올 수 없다.숫자3개 - 숫자4개
		//      1,6,7,8,9
		String regEx04 = "01[^2-5]-[1-9][\\d]{3}-[\\d]{4}";
		System.out.println(Pattern.matches(regEx04, "016-1111-1111"));
		System.out.println("===============================");
				
		// 5.주민번호
		/*
		 년 월 일
		 숫자2개 0 1-9 0 0-9 - 1-4 숫자 6자리
		 	  1 0-2 1 0-9
		 	        2 0-9
		 	        3 0-1	 	     
		 */
		String regEx05 = "[\\d]{2}"
				+ "(([0][1378]([0][1-9]|[1-2][\\d]|[3][0-1]))"  // 1,3,7,8월일 때 31일까지
				+ "|([0][2]([0][1-9]|[1][\\d]|[2][0-8]))"		// 2월일 때 28일까지
				+ "|([0][469]([0][1-9]|[1-2][\\d]|[3][0]))"		// 4,6,9월일 때 30일까지
				+ "|([1][02]([0][1-9]|[1-2][\\d]|[3][0-1]))"	// 10,12월일 때 31일까지 
				+ "|([1][1]([0][1-9]|[1-2][\\d]|[3][0])))"		// 11월일 때 30일까지
				+ "-[1-4][\\d]{6}";
		System.out.println(Pattern.matches(regEx05, "941231-5234566"));
		System.out.println("===============================");
		
		// 6. 이메일 주소
		/*
		 pgsk0927@gmail.com
		 1. 영문자로 시작해야 한다. 
		 2. 영문자 또는 숫자 특수문자(-_.\)
		 3. @이후에 영문자 또는 숫자가 3~7자가 올 수 있다.
		 4. .이후에 영문자 또는 숫자가 2~3자가 올 수 있다.
		 5. .kr올 수 도 있다.
		 */
		String regEx06 = "[a-zA-Z][\\w_\\-\\.]*@[\\w]{3,7}.[\\w]{2,3}(.kr)?";
		System.out.println(Pattern.matches(regEx06, "p_@gmail.com.kr"));
		
		String text = "야이 개나리 십장생아 이런 조카신발 같은 경우를 봤나..";
		
		String result = filter(text);	
		System.out.println(result);
	}

	private static String filter(String text) {
		Pattern p = Pattern.compile("개나리|십장생|조카신발|병일신", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(text);
		StringBuffer sb = new StringBuffer();
		
		while(m.find()){
			String group = m.group();
			String re = maskword(group);
			m.appendReplacement(sb, re);
		}
		m.appendTail(sb);
		return sb.toString();
	}

	private static String maskword(String group) { // 개나리 -> 개❤❤ 
		char[] gg = group.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < gg.length; i++) {
			if(i == 0){
				sb.append(gg[i]);
			}else{
				sb.append("❤");
			}
		}
		
		return sb.toString();
	}
}
