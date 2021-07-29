package burger_Main;

import java.util.regex.Pattern;

public class RegEx {

	/**
	 * 
	 * 사용자의 id 검증
	 * 
	 * @param user_id
	 * @return id가 영어 대소문자 문자로 시작하는지, 이후 영어 대소문자, 숫자를 포함 4자 ~ 10자의 길이인지 검증 후 통과하면 true, 아니면 false
	 * 		      다음으로 id가 admin을 사용하지 못하도록 입력된 아이디와 비교하여 일치하면 result = false
	 */
	public static boolean idCheck(String user_id) {
		boolean result;
		String idPattern = "[a-zA-Z][a-zA-Z0-9]{3,9}";
		result = Pattern.matches(idPattern, user_id);
		String adminId = "admin";
		if(adminId.equals(user_id)){
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * 사용자의 password검증
	 * 
	 * @param user_pw
	 * @return pw가 특수문자가 들어가면 false, 아니면 true 반환 (길이  4 ~ 15)
	 */
	public static boolean pwCheck(String user_pw) {
		String pwPattern = "\\w{4,15}";
		return Pattern.matches(pwPattern, user_pw);
	}

	/**
	 * 
	 * 사용자의 이름 검증
	 * 
	 * @param user_name
	 * @return name이 한글 또는 영어 대소문자(한글 이름이면 한글만 영어 이름이면 영어만)로 되어 있으면 true, 아니면 false 리턴(길이 2~20자)
	 */
	public static boolean nameCheck(String user_name) {
		String namePattern = "[가-힣]{2,20}|[a-zA-Z]{2,20}";
		return Pattern.matches(namePattern, user_name);
	}

	/**
	 * 
	 * 사용자의 입력 금액 검증
	 * 
	 * @param user_cash
	 * @return 유저가 입력한 금액이 숫자인지 판별하여 숫자면 true, 아니면 false 리턴
	 */
	public static boolean cashCheck(String user_cash){
		String cashPattern = "[0-9]+";
		return Pattern.matches(cashPattern, user_cash);
	}
}
