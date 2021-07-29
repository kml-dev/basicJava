package burger_Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import burger_Database.Database;
import burger_VO.AdminVO;
import burger_VO.KindVO;
import burger_VO.NotifyVO;
import burger_VO.OrderDetailsVO;
import burger_VO.OrderVO;
import burger_VO.ProductVO;
import burger_VO.QnAVO;
import burger_VO.UserVO;


public class View {
	// 타임 포맷
	SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	Date d = new Date();
//	String time = f1.format(d);
	
	// 로그인한 유저용
	UserVO user = null;
	
	// 서비스 구현 객체 생성
	IServiceImpl isim = new IServiceImpl();
	
	// 장바구니
	List<OrderDetailsVO> orderCart = new ArrayList<>();
	
	
	/**
	 * 문자열 입력 메서드
	 * @author 이경민
	 * @return String - 입력받은 문자열 리턴
	 */
	public String strIn(){
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine().trim();
		return result;		
	}
	
	/**
	 * 숫자 입력 메서드
	 * @author 이경민
	 * @return int - 입력받은 숫자 리턴
	 */
	public int intIn(){
		Scanner sc = new Scanner(System.in);
		int result = Integer.parseInt(sc.next().trim());
		return result;
	}
    /////////////////////////////////////////////////////////////////
	/**
	 * 프로그램 시작 메서드
	 * @author 이경민
	 */
	
	void start(){
		while(true){
			System.out.println("⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕");
			System.out.println("⁕                                                               ⁕");
			System.out.println("⁕        우리 햄벅해볼까요?(´▽`ʃ♡ƪ)    ⁕");
			System.out.println("⁕                                                               ⁕");
			System.out.println("⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕⁕");
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 종료");
			System.out.println();
			System.out.println();
			try{
				switch(intIn()){
				case 1:
					System.out.println("로그인 호출");
					login();
					break;
				case 2:
					System.out.println("회원가입 호출");
					register();
					break;
				case 0:
					System.out.println("프로그램 종료");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
				}
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
		}	
	}
	
	/**
	 * 회원가입 메서드
	 * @author 이경민
	 */
	void register(){
		while(true){
			// db에 id가 겹치는지 체크 boolean 
			// 아이디 정규식 체크
			// 비밀번호 정규식 체크 boolean
			// 이름 정규식 체크 boolean
			// db에 회원추가 boolean 성공 true, 실패 false리턴
			
			UserVO user = new UserVO();
			System.out.println("회원가입 메서드입니다");
		
			System.out.println("아이디 입력 : ");
			System.out.println("영어로 시작, 영어 대소문자만 사용가능 (길이 4자 ~ 10자)");
			boolean result = true;
			while(result){
				String id = strIn();
				if(checkId(id)){
					System.out.println("중복되는 아이디가 있습니다.");
					continue;
				}if(!(idRegCheck(id))){
					System.out.println("조건에 맞지 않는 아이디입니다.");
					continue;
				}
				user.setId(id);
				result = false;
			}
			System.out.println("비밀번호 입력");
			System.out.println("특수문자를 제외한 모든 문자 (길이 4자 ~ 15자)");
			result = true;
			while(result){
				String pw = strIn();
				if(!(pwRegCheck(pw))){
					System.out.println("조건에 맞지 않는 비밀번호입니다.");
					continue;
				}
				user.setPw(pw);
				result = false;
			}
									
			System.out.println("이름 입력");
			System.out.println("한글 또는 영어, 중복 사용 불가 (길이 2자 ~ 20)");
			result = true;
			while(result){
				String name = strIn();
				if(!(nameRegCheck(name))){
					System.out.println("조건에 맞지 않는 이름입니다.");
					continue;
				}
				user.setName(name);
				result = false;
			}
			
			System.out.println("충전 금액 입력");
			result = true;
			while(result){
				String cash = strIn();
				if(!(cashRegCheck(cash))){
					System.out.println("올바르지 않은 입력입니다.");
					continue;
				}
				try{
					user.setCash(Integer.parseInt(cash));
				}catch(NumberFormatException e){
					System.out.println("최대 입력 범위는 1000억입니다. 다시 입력하세요.");
					continue;
				}
				result = false;
			}
			
			result = isim.insertUser(user);
			if(result == true){
				System.out.println("회원가입 완료");				
			}
			return;
		}
	}
	
	// db에 id가 겹치는지 체크 boolean 
	// 아이디 정규식 체크
	// 비밀번호 정규식 체크 boolean
	// 이름 정규식 체크 boolean
	// db에 회원추가 boolean 성공 true, 실패 false리턴
	
	/**
	 * 유저 아이디가 db에 있는지 확인하는 메서드
	 * 
	 * @param user_id
	 * @return  있으면 true, 없으면 false 리턴 (false면 가입 가능, true면 가입 불가)
	 * @author  이경민
	 */
	private boolean checkId(String user_id) {
		boolean result = isim.checkId(user_id);
		return result;
	}
	
	/**
	 * 
	 * 아이디 정규식 체크 메서드
	 * @param user_id
	 * @return 정규식에 맞으면 true, 아니면 false 리턴
	 * 
	 */
	private boolean idRegCheck(String user_id){
		return RegEx.idCheck(user_id);
	}
	
	/**
	 * 
	 * 비밀번호 정규식 체크 메서드
	 * @param user_pw
	 * @return 정규식에 맞으면 true, 아니면 false 리턴
	 */
	private boolean pwRegCheck(String user_pw){
		return RegEx.pwCheck(user_pw);
	}
	
	/**
	 * 이름 정규식 체크 메서드
	 * 
	 * @param user_name
	 * @return 정규식에 맞으면 true, 아니면 false 리턴
	 */
	private boolean nameRegCheck(String user_name){
		return RegEx.nameCheck(user_name);
	}


	/**
	 * 금액이 정확히 입력되었는지 확인하는 메서드
	 * 
	 * @param user_cash
	 * @return 조건에 맞으면 true, 아니면 false
	 */
	private boolean cashRegCheck(String user_cash){
		return RegEx.cashCheck(user_cash);
	}

	
//===============================================================================
	/**
	 * Login 메서드
	 * @author 이경민
	 */
	
	void login(){
		while(true){
			AdminVO admin = new AdminVO();
			// id가 db에 있는지 검증 boolean
			// 비밀번호가 입력받은 id에 있는 pw와 일치하는지 검증 boolean
			// user의 isActivate가 true인지 검증
			
			System.out.println("아이디 입력 : ");
			String id = strIn();
			System.out.println("비밀번호 입력 : ");
			String pw = strIn();
			if(id.equals(admin.getId()) && pw.equals(admin.getPass())){
				adminLogin();
			}else if(checkId(id)){
				if(isim.loginSuccess(id, pw)){
					user = isim.getUserInfo(id, pw);
					if(user.isActivate()){
						showMain();						
						return;
					}
					System.out.println("탈퇴한 회원입니다.");
				}
				System.out.println("올바르지 않은 비밀번호입니다.");
				continue;
			}
			System.out.println("존재하지 않는 아이디입니다.");
			break;
	    }
		return;
	}
	
	////////////////////////////////////////////////////////////////
	/**
	 * 관리자 로그인 메서드
	 * @author 이경민
	 */
	void adminLogin(){
		while(true){
			System.out.println("[1] 공지관리");
			System.out.println("[2] 재고관리");
			System.out.println("[3] 회원관리");
			System.out.println("[0] 로그아웃");
			
			try{
				switch(intIn()){
				case 1:
//					System.out.println("공지관리 호출");
					adminNoti();
					break;
				case 2:
//					System.out.println("재고관리 호출");
					adminProduct();
					break;
				case 3:
//					System.out.println("회원관리 호출");
					adminMemb();
					break;
				case 0:
					System.out.println("로그아웃");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
				}	
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}
	
	/**
	 * 공지관리 메서드
	 * @author 이경민
	 */
	void adminNoti(){
		while(true){
			List<NotifyVO> notiList = isim.showAllNotify();
			for (int i = 0; i < notiList.size(); i++) {
				System.out.println("(" + (i+1) + ") 제목 : " + notiList.get(i).getTitle());
			}
			System.out.println();
			System.out.println("[1] 공지추가");
			System.out.println("[2] 공지수정");
			System.out.println("[3] 공지삭제");
			System.out.println("[4] 공지상세");
			System.out.println("[0] 돌아가기");
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}

			switch(in){
				case 1:
					System.out.println("공지추가 호출");
					addNoti();
					break;
				case 2:
					System.out.println("공지수정 호출");
					changeNoti();
					break;
				case 3:
					System.out.println("공지삭제 호출");
					delNoti();
					break;
				case 4:
	//				System.out.println("공지상세 호출");
					for (int i = 0; i < notiList.size(); i++) {
						System.out.println("(" + (i+1) + ") 제목 : " + notiList.get(i).getTitle());
					}
					System.out.println("상세 보기할 공지의 번호를 입력하세요.");
					int selNum = 0;
					try{
						selNum = intIn();						
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					System.out.println(notiList.get(selNum-1));
					System.out.println("[0] 돌아가기");
					while(true){
						int in2 = 0;
						try{
							in2 = intIn();
						}catch(Exception e){
							System.out.println("올바르지 않은 입력입니다.");
							continue;
						}
						switch(in2){
							case 0:
								return;
							default:
								System.out.println("올바르지 않은 입력입니다.");
								continue;
						}	
					}
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}		
		}
	}
	
	/**
	 * 공지추가 메서드
	 * @author 이경민
	 */
	void addNoti(){
		while(true){
			// 공지 추가 메서드 호출 boolean
//			System.out.println("공지추가 메서드");
			List<NotifyVO> notiList = isim.showAllNotify();
			for (int i = 0; i < notiList.size(); i++) {
				System.out.println("(" + (i+1) + ") 제목 : " + notiList.get(i).getTitle());
			}
			
			NotifyVO newNoti = new NotifyVO();
			System.out.println("추가할 공지 제목 입력 :");
			String title = strIn();
			System.out.println("추가할 공지 내용 입력: ");
			String contents = strIn();
			System.out.println("추가 하시겠습니까?");
			System.out.println("[1] 확인");
			System.out.println("[0] 돌아가기");
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in) {
				case 1:
					Date d = new Date();
					String time = f1.format(d);
					newNoti.setSeq(++Database.notify_seq);
					newNoti.setTitle(title);
					newNoti.setContents(contents);
					newNoti.setDate(time);
					boolean result = isim.insertNotify(newNoti);
					if(result){
						System.out.println("공지가 추가되었습니다.");
					}
				case 0:
					return;
				default:
					break;
			}
		}
	}
	
	/**
	 * 공지수정 메서드
	 * @author 이경민
	 */
	void changeNoti(){
		while(true){
//			System.out.println("공지수정 메서드");
			// 공지 목록 가져오기
			List<NotifyVO> notiList = isim.showAllNotify();
			for (int i = 0; i < notiList.size(); i++) {
				System.out.println("(" + (i+1) + ") 제목 : " + notiList.get(i).getTitle());
			}
			
			System.out.println();
			System.out.println("[1] 수정하기");
			System.out.println("[0] 돌아가기");
			
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in) {
				case 1:
					Map<String, Object> updateNotifyInfo = new HashMap<>();
					// 수정할 공지 선택 : seq로 불러오기 boolean
					System.out.println("수정할 공지를 선택하세요.");
					int inputIndex = 0;						
					try{
						inputIndex = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					
					NotifyVO selNoti = isim.selectNotify(notiList.get(inputIndex-1).getSeq());
					updateNotifyInfo.put("seq", notiList.get(inputIndex-1).getSeq());
					System.out.println(selNoti);
					
					System.out.println("공지 제목을 입력하세요.");
					updateNotifyInfo.put("title", strIn());
					
					System.out.println("공지 내용을 입력하세요.");
					updateNotifyInfo.put("contents", strIn());
					
					System.out.println("수정 하시겠습니까?");
					System.out.println("[1] 예");
					System.out.println("[2] 아니오");
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 1:
							boolean result = isim.updateNotify(updateNotifyInfo);
							if(result == true){
								System.out.println("수정 되었습니다.");
								return;								
							}
						case 2:
							break;
						default:
							System.out.println("올바르지 않은 입력입니다.");						
					}
					
				case 0:
//					System.out.println("돌아가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}
	
	/**
	 * 공지삭제 메서드
	 * @author 이경민
	 * 
	 * 
	 */
	void delNoti(){
		while(true){
			// 선택한 공지 삭제 : seq통해 불러오기 boolean
			// 삭제성공시 true, 실패시 false boolean
//			System.out.println("공지삭제 메서드");
			List<NotifyVO> notiList = isim.showAllNotify();
			for (int i = 0; i < notiList.size(); i++) {
				System.out.println("(" + (i+1) + ") 제목 : " + notiList.get(i).getTitle());
			}
			
			System.out.println();
			System.out.println("[1] 삭제하기");
			System.out.println("[0] 돌아가기");
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in) {
				case 1:
					System.out.println("삭제할 공지를 선택하세요.");
					int inputIndex = 0;
					try{
						inputIndex = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					NotifyVO selNoti = isim.selectNotify(notiList.get(inputIndex-1).getSeq());
					System.out.println(selNoti);
					System.out.println();
					
					System.out.println("정말 삭제 하시겠습니까?");
					System.out.println("[1] 예");
					System.out.println("[2] 아니오");
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 1:
							boolean result = isim.deleteNotify(notiList.get(inputIndex-1).getSeq());
							if(result){
								System.out.println("삭제 되었습니다.");
								return;
							}
						case 2:
							break;
						default:
							System.out.println("올바르지 않은 입력입니다.");
					}
					
				case 0:
					return;
				default:
					break;
			}
		}
	}
	
	////////////////////////////////////////////////////////////////
	/**
	 * 재고관리 메서드
	 * @author 이경민
	 */
	void adminProduct(){
		while(true){
			// 물품목록 불러오기 
			System.out.println("=========현재 보유 재고 목록=========");
			List<ProductVO> prodList = isim.showAllProduct();
			for (int i = 0; i < prodList.size(); i++) {
				System.out.println("(" + (i+1) + ") 물품명 : " + prodList.get(i).getName());
			}
			System.out.println();
			System.out.println("[1] 물품 추가");
			System.out.println("[2] 물품 수정");
			System.out.println("[3] 물품 상태");
			System.out.println("[0] 돌아가기");
			System.out.println();
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
//					System.out.println("물품추가 호출");
					addProduct();
					break;
				case 2:
//					System.out.println("물품수정 호출");
					changeProduct();
					break;
				case 3:
//					System.out.println("물품 상태 변경 호출");
					delProduct();
					break;
				case 0:
//					System.out.println("뒤로가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}			
		}
	}
	
	void addProduct(){
		while(true){
			// 객체를 생성하여 db에 넘겨 추가되면 true boolean
//			List<ProductVO> prodList = isim.showAllProduct();
//			for (int i = 0; i < prodList.size(); i++) {
//				System.out.println("(" + (i+1) + ") 물품 이름 : " + prodList.get(i).getName());
//			}
//			System.out.println();
//			System.out.println("물품추가 메서드");
			ProductVO newProd = new ProductVO();
			System.out.println("추가할 물품 이름 입력 :");
			String name = strIn();
			if(isim.checkProductName(name)){
				System.out.println("같은 이름의 물품이 존재합니다.");
				System.out.println("==========================");
				continue;
			}
			System.out.println("물품 가격 입력: ");
			int price = 0;
			try{
				price = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			if(price < 0){
				System.out.println("양수만 입력하세요.");
				continue;
			}
			System.out.println("물품 수량 입력: ");
			int stock = 0;
			try{
				stock = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			if(stock < 0){
				System.out.println("양수만 입력하세요.");
				continue;
			}
			System.out.println("물품 분류를 선택하세요 : ");
			System.out.println("[1] 패티");
			System.out.println("[2] 빵");
			System.out.println("[3] 야채");
			System.out.println("[4] 소스");
			System.out.println("[5] 사이드");
			System.out.println("[6] 음료");
			String kind = "";
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					kind = "패티";
					break;
				case 2:
					kind = "빵";
					break;
				case 3:
					kind = "야채";
					break;
				case 4:
					kind = "소스";
					break;
				case 5:
					kind = "사이드";
					break;
				case 6:
					kind = "음료";
					break;
				default:
					System.out.println("올바르지 않은 입력입니다.");
					
			}
			System.out.println("추가 하시겠습니까?");
			System.out.println("[1] 확인");
			System.out.println("[0] 돌아가기");
			int in2 = 0;
			try{
				in2 = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in2) {
				case 1:
					newProd.setSeq(++Database.product_seq);
					newProd.setName(name);
					newProd.setPrice(price);
					newProd.setStock(stock);
					newProd.setKind_name(kind);
					
					boolean result = isim.insertProduct(newProd);
					if(result){
						System.out.println("물품이 추가되었습니다.");
					}
					return;
				case 0:
					return;
				default:
					break;
			}
		}
	}
	
	void changeProduct(){
		while(true){
//			System.out.println("물품 수정 메서드");
			// 물품목록 불러오기 
			List<ProductVO> prodList = isim.showAllProduct();
			for (int i = 0; i < prodList.size(); i++) {
				System.out.println("(" + (i+1) + ") 물품 이름 : " + prodList.get(i).getName());
			}
			System.out.println();
			System.out.println("[수정할 물품의 번호를 선택해주세요]");
			
			//수정할 물품 선택하는 창으로 넘어와서, 분류 이름 가격 
			//1. 분류 kind에서 종류 겹치는거 있으면 안되고, 없는거 추가하면 안됨
			//2. 이름 스트링으로 구분없이받고
			//3. 가격 스트링입력시 오류 안생기게하기 
			//0. 돌아가기
			Map<String, Object> updateProductInfo = new HashMap<>(); //업데이트 정보 가져갈 해시맵
			
			int inputIndex = 0; //순번고르기 입력키
			try{
				inputIndex = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			if(inputIndex > prodList.size()){
				System.out.println("목록에 있는 숫자만 입력하세요.");
				continue;
			}
			ProductVO selProd = isim.selectProduct(prodList.get(inputIndex-1).getSeq());
			updateProductInfo.put("seq", selProd.getSeq()); //수정할 친구의 seq넘버
			
			
			//수정할 물품 선택하는 창으로 넘어와서, 분류 이름 가격 
			//1. 분류 kind에서 종류 겹치는거 있으면 안되고, 없는거 추가하면 안됨
			//2. 이름 스트링으로 구분없이받고
			//3. 가격 스트링입력시 오류 안생기게하기 
			//0. 돌아가기
			
			System.out.println("[1] 이름수정");
			System.out.println("[2] 가격수정");
			System.out.println("[3] 분류수정");
			System.out.println("[0] 돌아가기");
			
			boolean result = false;
			
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in) {	
				case 1: //분류수정
					System.out.println("수정하실 이름을 입력하세요 : ");
					String name = strIn().trim();
					if(isim.checkProductName(name)){
						System.out.println("같은 이름의 물품이 존재합니다.");
						continue;
					} else if(name == null){
						System.out.println("이름을 입력해주세요.");
						continue;
					}
					
					updateProductInfo.put("product_name", name);
					result = isim.updateProduct(updateProductInfo);
					if(result == true){
						System.out.println("수정되었습니다.");
						return;
					} else {
						System.out.println("수정 실패");
						System.out.println("==========================");
						return;
					}
					
				case 2: //가격수정
					System.out.println("수정하실 가격을 입력하세요 : ");
					int price = 0;
					try{
						price = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(price < 0){
						System.out.println("금액을 정확히 입력해주세요.");
						System.out.println("==========================");
						continue;
					}
					updateProductInfo.put("product_price", price);
					result = isim.updateProduct(updateProductInfo);
					if(result == true){
						System.out.println("수정되었습니다.");
						return;
					} else {
						System.out.println("수정 실패");
						System.out.println("==========================");
						return;
					}
					
				case 3: //종류수정
					System.out.println("수정하실 분류를 선택하세요 : ");//여기서 분류에 없으면 안되게해야함 
					System.out.println("[1] 패티");
					System.out.println("[2] 빵");
					System.out.println("[3] 야채");
					System.out.println("[4] 소스");
					System.out.println("[5] 사이드");
					System.out.println("[6] 음료");
					String kind = "";
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 1:
							kind = "패티";
							break;
						case 2:
							kind = "빵";
							break;
						case 3:
							kind = "야채";
							break;
						case 4:
							kind = "소스";
							break;
						case 5:
							kind = "사이드";
							break;
						case 6:
							kind = "음료";
							break;
						default:
							System.out.println("올바르지 않은 입력입니다.");					
					}
					updateProductInfo.put("product_kind", kind);
					result = isim.updateProduct(updateProductInfo);
					if(result){
						System.out.println("수정 되었습니다.");
						return;
					}
					System.out.println("수정 실패");
					System.out.println("==========================");
					return;
				case 0:									// 수정하기 선택 스위치문
					return;
				default:								// 수정하기 선택 스위치문
					System.out.println("올바르지 않은 입력입니다.");
					System.out.println("==========================");
					return;
			}
		}
	}
	
	void delProduct(){
		while(true){
			// 물품목록 불러오기 
			// seq와 일치하는 물품 선택
			// setIsActivate를 false로 바꿈 boolean
//			System.out.println("판매 상태 변경 메서드");
			System.out.println("=========현재 보유 재고 목록=========");
			List<ProductVO> prodList = isim.showAllProduct();
			for (int i = 0; i < prodList.size(); i++) {
				System.out.println("(" + (i+1) + ") 물품 이름 : " + prodList.get(i).getName());
			}
			System.out.println();
			System.out.println("상태를 확인할 물품의 번호를 입력하세요.");
			int inputIndex = 0;
			try{
				inputIndex = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			if(inputIndex > prodList.size()){
				System.out.println("목록이 있는 번호만 입력하세요.");
				continue;
			}
			ProductVO selProd = isim.selectProduct(prodList.get(inputIndex-1).getSeq());
			System.out.println(selProd);

			System.out.println("[1] 판매 상태 변경");
			System.out.println("[0] 돌아가기");
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					boolean result = isim.changeProductAct(selProd.getSeq());
					String status = "";
					if(result == true){
						status = "(판매가능)";
					}else{
						status = "(판매중지)";
					}
					System.out.println("물품 판매 상태가" + status + "로 변경 되었습니다.");
					System.out.println();
					System.out.println();
					return;
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
					return;
			}

		}
	}
	////////////////////////////////////////////////////////////////
	/**
	 * 회원관리 메서드
	 * @author 이경민
	 */
	void adminMemb(){
		while(true){
			System.out.println("[1] 회원 정보 조회");
			System.out.println("[2] 회원 질문내역 조회");
			System.out.println("[0] 돌아가기");
			System.out.println();
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					System.out.println("회원 정보 조회 호출");
					userDetails();
					break;
				case 2:
					System.out.println("질문내역 호출");
					qnaDetails();
					break;
				case 0:
					System.out.println("돌아가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}			
		}
	}
	
	/**
	 * 회원 정보 조회 메서드
	 * @author 이경민
	 */
	void userDetails(){
		while(true){
			System.out.println("회원 정보 조회 메서드");
			// 회원 목록 출력
			List<UserVO> allUser = isim.showAllUser();
			for (int i = 0; i < allUser.size(); i++) {
				System.out.println("(" + (i+1) + ") 회원 정보 : " + allUser.get(i).getId() + ", " + allUser.get(i).getName());
			}
			// 사용자 입력으로 유저 선택
			
//			selectUser();
			// 해당하는 유저의 orderDetails 출력
			// userId 일치하는 orderDetails 출력
			System.out.println("[1] 회원 상세 정보 조회");
			System.out.println("[2] 회원 구매 내역 조회");
			System.out.println("[0] 돌아가기");
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch (in) {
				case 1:
					System.out.println("상세 정보를 조회할 회원의 번호를 입력하세요.");
					int selNum = 0;
					try{
						selNum = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum > allUser.size()){
						System.out.println("목록에 있는 번호만 입력하세요.");
						continue;
					}
					System.out.println(allUser.get(selNum-1));
					System.out.println("[0] 돌아가기");
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 0:
							break;
						default:
							System.out.println("올바르지 않은 입력입니다.");
					}
					break;
				case 2:
					System.out.println("구매 내역을 조회할 회원의 번호를 입력하세요.");
					int selNum2 = 0;
					try{
						selNum2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum2 > allUser.size()){
						System.out.println("목록에 있는 번호만 입력하세요.");
						continue;
					}
//					List<OrderDetailsVO> ordList = isim.showOrderInfo(allUser.get(selNum2-1).getId());
					
					//이게 선택한 회원 아이디임 allUser.get(selNum2-1).getId()
					List<OrderVO> userOrderList = isim.showAllOrderList(allUser.get(selNum2-1).getId());
					//이걸로 회원의 구매리스트를 뽑아볼거임 
					
					
					//리스트가 없으면 IndexOutOfBoundsEx 떠서 이프문 돌릴것임
					if(userOrderList.size() == 0){
						System.out.println("해당 회원의 구매내역이 없습니다.");
						return;
						//이거 안하면 오류남
						
					} else {
						//여기서 해당 회원의 구매 리스트를 출력해야함 
						//여기 아이디를 입력받은 해당 회원 구매리스트 출력
						for(int i = 0 ; i < userOrderList.size() ; i++ ){
							System.out.println("(" + (i+1) +")" + userOrderList.get(i).getDate());
						}
						
					}
					
					System.out.println("상세 내역 확인을 위해 해당 날짜 주문번호를 입력해주세요.");
					System.out.println("[0] 돌아가기");
//					userOrderList.get(selNum2-1).getSeq(); //이게 오더넘버
//					showMyOrderDetails(여기다가 주문번호 오더넘버 넣으면 될듯 );		
					int selNum3 = 0;
					try{
						selNum3 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum3 > userOrderList.size()){
						System.out.println("목록에 있는 번호만 입력하세요.");
						continue;
					}
					showMyOrderDetails(userOrderList.get(selNum3-1).getSeq());
					System.out.println("------------------------------------");
//					switch(intIn()){
//						case 0:
//							return;
//						default:
//							System.out.println("올바르지 않은 입력입니다.");
//					}
					return;
				case 0:
					System.out.println("돌아가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}
	
	/**
	 * 질문내역 조회 메서드
	 * @author 이경민
	 */
	void qnaDetails(){
		while(true){
			// qna리스트 출력
			List<QnAVO> qnaList = isim.showAllQnA();
			System.out.println("[No]"+" ID"+"\t"+"\t"+"Question Title");
			for (int i = 0; i < qnaList.size(); i++) {
				System.out.println("[" + (i+1) + "]  "+qnaList.get(i).getUser_id() +"\t"+ qnaList.get(i).getTitle());
			}
			System.out.println();
			System.out.println("[1] 답변등록");
			System.out.println("[0] 돌아가기");
			System.out.println();
			int in = 0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					System.out.println("답변을 등록하실 질문의 번호를 입력하세요");
					Map<String, Object> updateComment = new HashMap<>();
					int selNum = 0;
					try{
						selNum = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum > qnaList.size()){
						System.out.println("목록에 있는 번호만 입력하세요.");
						continue;
					}
					System.out.println(qnaList.get(selNum-1));
					updateComment.put("seq", qnaList.get(selNum-1).getSeq());
					System.out.println("답변을 입력하세요");
					String comment = strIn();
					System.out.println("답변을 등록하시겠습니까?");
					updateComment.put("comment", comment);
					System.out.println("[1] 네");
					System.out.println("[0] 아니오");
					
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch (in2) {
						case 1:
							boolean result = isim.answerRegister(updateComment);
							if(result){
								System.out.println("답변이 등록되었습니다.");
							}
							break;
						case 0:
							System.out.println("돌아가기");
							break;
						default:
							System.out.println("올바르지 않은 입력입니다.");
					}
					break;
				case 0:
					System.out.println("돌아가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}
	
	
	
	////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////
	/**
	 * 
	 * 회원 로그인 성공시 화면 출력
	 * @author 구나은
	 */
	private void showMain(){
		while(true){
			if (user == null) {
				return;
			}
			System.out.println("----------------------------------");
			System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("░░░░░░░░██████████████████░░░░░░░░");
			System.out.println("░░░░░░██░░░░░░░░░░░░░░░░░░██░░░░░░");
			System.out.println("░░░░██░░░░░░░░░░░░░░░░░░░░░░██░░░░");
			System.out.println("░░██████████████████████████████░░");
			System.out.println("░░░░██░░██░░██░░██░░██░░██░░██░░░░");
			System.out.println("░░██░░██░░██░░██░░██░░██░░██░░██░░");
			System.out.println("░░░░██████████████████████████░░░░");
			System.out.println("░░██░░░░░░░░░░░░░░░░░░░░░░░░░░██░░");
			System.out.println("░░░░██████████████████████████░░░░");
			System.out.println("░░████░░████░░████░░████░░██████░░");
			System.out.println("░░██████████████████████████████░░");
			System.out.println("░░░░██░░░░░░░░░░░░░░░░░░░░░░██░░░░");
			System.out.println("░░░░░░██████████████████████░░░░░░");
			System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("░░░░[맛있는 수제버거, 햄벅에 어서오세요!]░░░░");
			System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");			
			System.out.println("----------------------------------");
			System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
			System.out.println("[1] 주문하기");
			System.out.println("[2] 공지사항 게시판");
			System.out.println("[3] QnA");
			System.out.println("[4] 마이페이지 ");
			System.out.println("[0] 로그아웃");
			System.out.println("----------------------------------");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:				//[1] 주문 하기
					order();
					break;
				case 2:				//[2] 공지사항
					showNoti();
					break;
				case 3:				//[3] 질문답변
					showQnA();
					break;
				case 4:				//[4] 개인정보
					showMyPage();
					break;
				case 0:				//[0] 돌아가기
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}

	////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * 회원 공지사항 접근 메서드
	 * 공지사항 내용 출력
	 * @param 
	 * @author 구나은
	 */
	
	private void showNoti(){
		while(true){
			
			System.out.println("----------------------------------");
			System.out.println("환영합니다! 공지사항 게시판입니다.\n원하시는 서비스를 선택해주세요.");
			System.out.println("----------------------------------");
			List<NotifyVO> notiList = isim.showAllNotify();
			
			System.out.println("[1] 공지확인");	
			System.out.println("[0] 나가기");
			System.out.println("------------------------");
			
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					System.out.println("          📄 확인하실 공지 번호를 입력하세요.📄");
					System.out.println("┌─────────────────────────────────┐");
					for(int i = 0 ; i < notiList.size() ; i++){
						System.out.println("   "+"[" + (i+1) + "] " + notiList.get(i).getTitle());
						System.out.println("├─────────────────────────────────┤");
					}	
					System.out.println("└─────────────────────────────────┘");
					
					int selNum = 0;
					try{
						selNum = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum>notiList.size()){
						System.out.println("해당 번호의 공지사항이 존재하지 않습니다.");
						continue;
					}
					System.out.println(notiList.get(selNum-1));
					System.out.println("[0] 돌아가기");
					
					int in2 = 0;
					try{
						in2 = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 0:
							return;
						default:
							System.out.println("올바르지 않은 입력입니다.");
					}
					break;
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
			 
			
					
		}
	}

	////////////////////////////////////////////////////////////////

	/**
	 * 
	 * 회원 QnA 메서드
	 * @author 구나은
	 */
	
	private void showQnA(){
		while(true){
			System.out.println("[1] 질문작성하기");
			System.out.println("[2] 내 질문 목록");
			System.out.println("[0] 나가기");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
			case 1:				//질문하기
				userAsk();
				break;
			case 2:				//질문답변 확인하기
				showUserAsk();
				break;
			case 0:				//나가기
				return;
			default:
				System.out.println("올바르지 않은 입력입니다.");
			}
		}
	}

	/**
	 * 
	 * 회원 질문작성 메서드
	 * @author 구나은
	 */
	
	private void userAsk(){
		while(true){			
			
			Date d = new Date();
			String time = f1.format(d);
			
			QnAVO newQna = new QnAVO();
			newQna.setSeq(++Database.qna_seq);
			newQna.setUser_id(user.getId());
			newQna.setDate(time);
			
			System.out.println("───────────────────────────────────");
			System.out.println("질문 제목을 입력해주세요");
			System.out.println("───────────────────────────────────");
			String qtitle = strIn();
			newQna.setTitle(qtitle);
			
			System.out.println("───────────────────────────────────");
			System.out.println("질문 내용을 입력해주세요");
			System.out.println("───────────────────────────────────");
			String qcontent = strIn();
			newQna.setContent(qcontent);
			
			System.out.println("질문을 등록 하시겠습니까?");
			System.out.println("[1] 네");
			System.out.println("[0] 아니오");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					boolean result = isim.insertQnA(newQna);
					if(result){
						System.out.println("==============질문작성완료=============");
					}
					return;
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
					
			}		
		}
	}
	
	/**
	 * 
	 * 회원 질문목록 확인 메서드
	 * 질문 목록이 출력됨
	 * 질문 목록에서 번호를 선택하면 해당 질문의 상세정보로 이동함
	 * @author 구나은
	 */
	
	private void showUserAsk(){
		while(true){
			
			List<QnAVO> qnaList = isim.showMyQnA(user.getId());
			
			System.out.println("[1] 질문/답변 확인하기");
			System.out.println("[0] 돌아가기");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
//					System.out.println("질문/답변을 확인할 질문 번호를 입력하세요.");
//					System.out.println("------------- 나의 질문 목록 -------------");
					System.out.println("              📄 확인하실 질문 번호를 입력하세요.📄");
					System.out.println("┌─────────────────────────────────┐");
					
					if(qnaList.size() == 0){
						System.out.println("          "+"작성된 질문 목록이 존재하지 않습니다.");
						System.out.println("└─────────────────────────────────┘");						
						return;
					} 
					
					for(int i = 0; i < qnaList.size(); i++){	
						System.out.println("├─────────────────────────────────┤");
						System.out.println("    "+"[" + (i+1) + "] " + qnaList.get(i).getTitle());
					}
					System.out.println("└─────────────────────────────────┘");
					
					int selNum = 0;
					
					try{
						selNum = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum>qnaList.size()){
						System.out.println("해당 번호의 질문이 존재하지 않습니다.");
						continue;
					}
					System.out.println(qnaList.get(selNum-1));
					if(qnaList.get(selNum-1).getComment() == null){
						System.out.println("──────────────답변 안내───────────────");
						System.out.println("답변이 아직 작성되지 않았습니다.");
						System.out.println("───────────────────────────────────");
						return;
					}else{
						System.out.println("──────────────답변 안내───────────────");
						System.out.println(qnaList.get(selNum-1).getComment());
						System.out.println("───────────────────────────────────");
					}
					System.out.println("[0] 돌아가기");
					int in2 =0;
					try{
						in = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					switch(in2){
						case 0:
							return;
						default:
							System.out.println("올바르지 않은 입력입니다.");				
					}
					break;
				case 0:
					System.out.println("돌아가기");
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");	
			}
		}
	}
	
	////////////////////////////////////////////////////////////////	
	
	/**
	 * 
	 * 회원 마이페이지 확인 메서드
	 * @author 구나은
	 */
	
	private void showMyPage(){
		while(true){
			if (user == null) {
				return;
			}
			
			System.out.println("----------------개인정보---------------");	
			System.out.println("고객명 :: " + user.getName());
			System.out.println("보유금액 :: " + user.getCash());
			System.out.println("잔여포인트 :: " + user.getPoint());
			System.out.println("------------------------------------");
			System.out.println();
			System.out.println("[1] 주문내역");
			System.out.println("[2] 이름수정");
			System.out.println("[3] 암호수정");
			System.out.println("[4] 금액충전");
			System.out.println("[5] 회원탈퇴");
			System.out.println("[0] 나가기");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:				//1) 주문 내역 확인
					showMyOrder();
					break;
				case 2:				//2) 이름 수정
					System.out.println("이름수정 호출");
					modifyUserName();
					break;
				case 3:				//3) 암호 수정
					System.out.println("암호수정 호출");
					modifyPw();
					break;
				case 4:				//4) 금액 충전
					System.out.println("금액충전 호출");
					addMoney();
					break;
				case 5:				//5) 회원 탈퇴
					System.out.println("탈퇴하기호출");
					exitHere();
					break;
				case 0:				//나가기
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}			
		}
	}
		
	/**
	 *         
	 * 회원 주문내역 확인 메서드
	 * @author 구나은
	 */
	private void showMyOrder(){
		while(true){
			List<OrderVO> orderList = isim.showAllOrderList(user.getId());
			if(orderList.size() == 0){
				System.out.println("주문내역이 없습니다.");
				return;
			}
			for(int i = 0; i < orderList.size(); i++){	
				System.out.println("(" + (i+1) + ") " + "주문 날짜:" + orderList.get(i).getDate());
			}
			System.out.println("고객님의 주문내역을 조회합니다.");
			System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
			System.out.println();
			System.out.println("[1] 주문 상세 내역 조회");
			System.out.println("[0] 돌아가기");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:
					System.out.println("주문일자에 해당하는 주문번호를 누르면");
					System.out.println("상세정보가 출력됩니다.");
					int selNum = 0;
					try{
						selNum = intIn();
					}catch(Exception e){
						System.out.println("올바르지 않은 입력입니다.");
						continue;
					}
					if(selNum>orderList.size()){
						System.out.println("올바르지 않은 입력입니다.");
						System.out.println();
						continue;						
					}
					showMyOrderDetails(orderList.get(selNum-1).getSeq());
					System.out.println("------------------------------------");
					return;
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}
		}	
	}
	
	/**
	 * 
	 * @param ord_seq
	 * @return 유저가 클릭한 해당 번호에 맞는 주문내역 출력 
	 * @author 구나은
	 */
	private void showMyOrderDetails(int ord_seq){
		while(true){
			//db에 있는 ord리스트에서 디테일시퀀스넘버 꺼내옴 이거랑 비교하면 될듯
			List<OrderDetailsVO> myOrderDetails = isim.orderDetail(ord_seq);
			//이게 해당 번호에 맞는 오더디테일이 담긴 주문내역임
			//여기서 상품번호 + 재고 + 가격 꺼내서 출력하면 될듯
			
			System.out.println("------------------------------------");
			System.out.println("품명"+"\t"+"수량"+"\t"+"가격");
			System.out.println("------------------------------------");
			int total = 0;
			
//			System.out.println("(" + (i+1) + ")");//  + myOrderDetails.get(i)
			for (int i = 0; i < myOrderDetails.size(); i++) {
				//seq 1: 호밀빵, 2: 플랫브레드, 3: 비프, 4: 포크, 5: 치킨, 6: 양상추
			
				if(myOrderDetails.get(i).getProduct_seq() == 1){
					System.out.print("호밀빵"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 2){
					System.out.print("플랫브레드"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 3){
					System.out.print("비프"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 4){
					System.out.print("포크"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 5){
					System.out.print("치킨"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 6){
					System.out.print("양상추"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
			    // 7: 양파, 8: 토마토, 9: 핫소스, 10: 마요네즈, 11: 케첩, 12: 코울슬로, 13: 치킨랩
				if(myOrderDetails.get(i).getProduct_seq() == 7){
					System.out.print("양파"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 8){
					System.out.print("토마토"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 9){
					System.out.print("핫소스"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 10){
					System.out.print("마요네즈"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 11){
					System.out.print("케첩"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 12){
					System.out.print("코울슬로"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 13){
					System.out.print("치킨랩"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				//   14: 감자튀김, 15: 스프라이트, 16: 콜라, 17: 아메리카노
				if(myOrderDetails.get(i).getProduct_seq() == 14){
					System.out.print("감자튀김"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 15){
					System.out.print("스프라이트"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 16){
					System.out.print("콜라"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
				if(myOrderDetails.get(i).getProduct_seq() == 17){
					System.out.print("아메리카노"+"\t");
					System.out.print(myOrderDetails.get(i).getUserStock()+"\t");
					System.out.println(myOrderDetails.get(i).getTotalPrice() + "원");
					//가격저장 
					total = myOrderDetails.get(i).getTotalPrice();
					total += total;
					
				}
			}
			
			System.out.println("------------------------------------");
			System.out.println("\t" + "합계" + total + "원");
			System.out.println("------------------------------------");
			
			System.out.println("[0] 돌아가기");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 0:
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
					return;
			}
		}
	}
	
	/**
	 * 
	 * 회원 이름 수정 메서드
	 * @author 구나은
	 */
	
	private void modifyUserName(){
		while(true){
			System.out.println("수정할 이름을 입력해주세요. "
					+ "\n" + "한글 또는 영어, 2자 ~ 20자 사이");
			System.out.println("------------------------------------");
			
			String nm = strIn();
			Map<String, Object> newName = new HashMap<>();
			
			newName.put("user_id", user.getId());
			newName.put("user_name", nm);
			
			if(isim.modifyUser(newName)){
				System.out.println("안녕하세요, "+ nm +"님.");
				System.out.println("이름 변경이 성공적으로 이루어졌습니다.");
				System.out.println("------------------------------------");
				break;
			} else {
				System.out.println("이름 변경 실패");
				break;
			}
		}		
	}
	
	/**
	 * 
	 * 회원 암호 수정 메서드
	 * @author 구나은
	 */
	
	private void modifyPw(){
		while(true){
			System.out.println("수정할 암호를 입력해주세요." +"\n"
					+ "특수문자 제외, 4자 ~ 15자 사이");
			System.out.println("------------------------------------");
			
			String pw = strIn();
			Map<String, Object> newPw = new HashMap<>();
			
			newPw.put("user_id", user.getId());
			newPw.put("user_pw", pw);
			
			if(isim.modifyUser(newPw)){
				System.out.println("암호 수정이 성공적으로 이루어졌습니다.");
				break;
			} else {
				System.out.println("암호 수정 실패.");
				break;				
			}	
		}		
	}

	/**
	 * 
	 * 회원 금액충전 메서드
	 * @author 구나은
	 */
	
	private void addMoney(){
		while(true){
			System.out.println("------입금할 금액을 입력해주세요--최대 100만원------");
			int addCash = 0; //고객이 입력한 금액

			try{
				addCash = intIn();
			}catch(Exception e){
				System.out.println("100만원 이내의 금액을 입력해주세요.");
				continue;
			}
			
			if(0<addCash && addCash<100000){
				Map<String,Object> userCashInfo = new HashMap<>();
				userCashInfo.put("user_id", (String)user.getId());
				userCashInfo.put("user_cash", (Integer)user.getCash() + addCash);
				
				int result = isim.addCash(userCashInfo);
				
				System.out.println("성공");
				System.out.println("고객 입금액 :: " + addCash);
				System.out.println("잔고에 남은 금액 :: "+ result);
				System.out.println("------------------------------------");
				return;
				
			} else if(addCash>1000000) {
				System.out.println("------------------------------------");
				System.out.println("입금  불가능! 충전 가능한 금액을 초과했습니다.");
				System.out.println("------------------------------------");
				return;
				
			} else if(addCash < 0) {
				System.out.println("====================================");
				System.out.println("입금  불가능! 올바르지 않은 입력입니다.");				
				System.out.println("====================================");
				return;
			} else { //숫자외의 금액
				System.out.println("====================================");
				System.out.println("입금  불가능! 올바르지 않은 입력입니다.");				
				System.out.println("====================================");
				return;
				
			}
		}		
	}
	
	/**
	 *         
	 * 회원 탈퇴 메서드
	 * @author 구나은
	 */
	private void exitHere(){
		while(true){
			System.out.println("정말 탈퇴하시겠습니까?");
			System.out.println("[1] 예");			
			System.out.println("[0] 아니오");
			int in =0;
			try{
				in = intIn();
			}catch(Exception e){
				System.out.println("올바르지 않은 입력입니다.");
				continue;
			}
			switch(in){
				case 1:				
					//유저 아이디가 성공적으로 비활성화되면 true반환
					boolean re = isim.exitHere(user.getId(), user.getPw());
					if(re){
						user = null;
						System.out.println("--회원 탈퇴 완료--");
						return;
					} else {
						System.out.println("--탈퇴실패--");
						return;
					}
				case 0:				//나가기
					return;
				default:
					System.out.println("올바르지 않은 입력입니다.");
			}			
		}	
	}
	
	////////////////////////////////////////////////////////////////

	//-------------------------------------------------------------------------

	 /**
	    * 주문하기 메서드
	    * @author 구나은
	    * @return 
	    */
		void order(){
			// 주문 Order객체 생성 , 주문번호 seq부여 
			while(true){
				//새로운 오더 만들어주기 얘는 주문번호를 가지고 있음
				
				Date d = new Date();
				String time = f1.format(d);
				
				orderCart.clear();
				OrderVO ord = new OrderVO();
				ord.setUser_id(user.getId());
				ord.setSeq(++Database.order_seq);
				ord.setDate(time);
				//주문번호를 오더디테일스에 넣어줘야함 나중에 이 주문번호를 가진 오더디테일스를 묶을거임
				//그럴라면 이 번호를 쭉쭉 넘겨주면서 아래에 있는 오더디테일스들에게 줘야할듯 
				chooseMeat(ord);		
				return;
			}
			
		}
			
	      /**
	       * 고기 선택하기 메서드
	       * @author 신민경, 구나은
	       * @return 
	       */      
	      void chooseMeat(OrderVO ord){
	         while (true) {
	            OrderDetailsVO meatOrder = new OrderDetailsVO();
	            
	            
	            //메뉴 목록 가져오기
	            List<ProductVO> meatList = isim.showMeat();
	            
	            
	            //메뉴가 출력됨
	            //1 비프 2 포크 3 치킨 
	            System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
	            System.out.println("[1] 고기 선택");
	            System.out.println("[0] 주문 취소");
	            int in = 0;
	            try {
	               in = intIn();
	            } catch (Exception e) {
	               System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	               continue;
	            }
	            switch(in){
	               case 1:
	                  System.out.println("[1단계] 선택할 패티의 번호를 입력하세요.");
	                  System.out.println("[Meat Menu]");
	                  for(int m = 0; m < meatList.size(); m++){
	                     System.out.println("[" + (m+1) + "] " + meatList.get(m).getName());
	                  }
	                  int selNum = 0;
	                  try {
	                     selNum = intIn();
	                  } catch (Exception e) {
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum > meatList.size()){
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  for(ProductVO prod : meatList){
	                     if(prod.getSeq() == meatList.get(selNum-1).getSeq()){
	                        if(prod.isActivate()){
	                           meatOrder.setTotalPrice(prod.getPrice() * 1);
	                           break;                           
	                        }
	                        System.out.println("선택하신 메뉴는 품절입니다.");
	                     }
	                  }
	                  meatOrder.setSeq(++Database.orderDetail_seq);
	                  meatOrder.setOrder_seq(ord.getSeq());
	                  meatOrder.setProduct_seq(meatList.get(selNum-1).getSeq());
	                  meatOrder.setUserStock(1);
	                  orderCart.add(meatOrder);
	                  chooseBread(ord);
	                  return;
	               case 0:
	                  return;
	               default:
	                  System.out.println("올바르지 않은 입력입니다.");
	            }
	         }
	      }
	      
	      void chooseBread(OrderVO ord){
	         while (true) {
	            OrderDetailsVO breadOrder = new OrderDetailsVO();
	                        
	            List<ProductVO> breadList = isim.showBread();
	            System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
	            System.out.println("[1] 빵 선택");
	            System.out.println("[0] 주문취소");
	            int in = 0;
	            try {
	               in = intIn();
	            } catch (Exception e) {
	               System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	               continue;
	            }
	            switch(in){
	               case 1:
	                  System.out.println("[2단계] 선택하실 빵의 번호를 입력하세요.");
	                  System.out.println("[Bread Menu]");
	                  for(int b = 0; b < breadList.size(); b++){
	                     System.out.println("(" + (b+1) + ") " + breadList.get(b).getName());
	                  }
	                  int selNum = 0;
	                  try {
	                     selNum = intIn();
	                  } catch (Exception e) {
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum > breadList.size()){
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  for(ProductVO prod : breadList){
	                     if(prod.getSeq() == breadList.get(selNum-1).getSeq()){
	                        if(prod.isActivate()){
	                           breadOrder.setTotalPrice(prod.getPrice() * 1);
	                           break;                           
	                        }
	                        System.out.println("선택하신 메뉴는 품절입니다.");
	                     }
	                  }
	                  breadOrder.setSeq(++Database.orderDetail_seq);
	                  breadOrder.setOrder_seq(ord.getSeq());   
	                  breadOrder.setProduct_seq(breadList.get(selNum-1).getSeq());
	                  breadOrder.setUserStock(1);
	                  orderCart.add(breadOrder);
	                  chooseVegetable(ord);
	                  return;
	               case 0:
	                  return;
	               default:
	                  System.out.println("올바르지 않은 입력입니다.");
	            }
	         }      
	      }
	      

	      /**
	       * 야채 선택하기 메서드
	       * @author 신민경, 구나은
	       * @return 
	       */
	      void chooseVegetable(OrderVO ord){
	         while (true) {
	            OrderDetailsVO vegeOrder = new OrderDetailsVO();
	            
	            List<ProductVO> vegeList = isim.showVegetable();
	            
	            System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
	            System.out.println("[1] 야채선택 (다중 선택 가능)");
	            System.out.println("[2] 다음으로");
	            System.out.println("[0] 주문취소");
	            int in = 0;
	            try {
	               in = intIn();
	            } catch (Exception e) {
	               System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	               continue;
	            }
	            switch(in){
	               case 1:
	                  System.out.println("[3단계] 선택하실 야채의 번호를 입력하세요.");
	                  System.out.println("[Vegetable Menu]");
	                  for(int v = 0; v < vegeList.size(); v++){
	                     System.out.println("(" + (v+1) + ") " + vegeList.get(v).getName());
	                  }
	                  int selNum = 0;
	                  try {
	                     selNum = intIn();
	                  } catch (Exception e) {
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum > vegeList.size()){
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }

	                  for(ProductVO prod : vegeList){
	                     if(prod.getSeq() == vegeList.get(selNum-1).getSeq()){
	                        if(prod.isActivate()){
	                           System.out.println("주문하실 개수를 입력하세요.(1개 : 30g)");
	                           int selStock = 0;
	                           try {
	                              selStock = intIn();
	                           } catch (Exception e) {
	                              System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                              continue;
	                           }
	                           if(prod.getStock() > selStock){
	                              vegeOrder.setSeq(++Database.orderDetail_seq);
	                              vegeOrder.setOrder_seq(ord.getSeq());
	                              vegeOrder.setProduct_seq(prod.getSeq());
	                              vegeOrder.setUserStock(selStock);
	                              vegeOrder.setTotalPrice(prod.getPrice() * selStock);
	                              System.out.println("선택 되었습니다");
	                              break;
	                           }
	                           System.out.println("주문하신 개수가 물품 잔량보다 많습니다.");
	                           break;
	                        }
	                        System.out.println("선택하신 메뉴는 품절입니다.");
	                        break;
	                     }
	                  }
	                  if(vegeOrder.getTotalPrice() != 0){
	                     orderCart.add(vegeOrder);                     
	                  }
	                  continue;
	               case 2:
	                  chooseSauce(ord);
	                  return;
	               case 0:
	                  return;
	               default:
	                  System.out.println("올바르지 않은 입력입니다.");
	            }
	         }
	      }
	      
	      /**
	       * 소스 선택하기 메서드
	       * @author 신민경, 구나은
	       * @return 
	       */
	      void chooseSauce(OrderVO ord){
	         while (true) {
	            OrderDetailsVO sauceOrder = new OrderDetailsVO();

	            List<ProductVO> sauceList = isim.showSauce();
	            
	            System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
	            System.out.println("[1] 소스 선택 (다중 선택 가능)");
	            System.out.println("[2] 다음으로");
	            System.out.println("[0] 주문취소");
	            int in = 0;
	            try {
	               in = intIn();
	            } catch (Exception e) {
	               System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	               continue;
	            }
	            switch(in){
	               case 1:
	                  System.out.println("[4단계] 선택하실 소스의 번호를 입력하세요.");
	                  System.out.println("[Sauce Menu]");
	                  for(int sa = 0; sa < sauceList.size(); sa++){
	                     System.out.println("(" + (sa+1) + ") " + sauceList.get(sa).getName());
	                  }
	                  int selNum = 0;
	                  try {
	                     selNum = intIn();
	                  } catch (Exception e) {
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum > sauceList.size()){
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  for(ProductVO prod : sauceList){
	                     if(prod.getSeq() == sauceList.get(selNum-1).getSeq()){
	                        if(prod.isActivate()){
	                           System.out.println("주문하실 개수를 입력하세요.(1개 : 9g)");
	                           int selStock = 0;
	                           try {
	                              selStock = intIn();
	                           } catch (Exception e) {
	                              System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                              continue;
	                           }
	                           if(prod.getStock() > selStock){
	                              sauceOrder.setSeq(++Database.orderDetail_seq);
	                              sauceOrder.setOrder_seq(ord.getSeq());
	                              sauceOrder.setProduct_seq(prod.getSeq());
	                              sauceOrder.setUserStock(selStock);
	                              sauceOrder.setTotalPrice(prod.getPrice() * selStock);
	                              System.out.println("선택 되었습니다");
	                              break;
	                           }
	                           System.out.println("주문하신 개수가 물품 잔량보다 많습니다.");
	                           break;
	                        }
	                        System.out.println("선택하신 메뉴는 품절입니다.");
	                        break;
	                     }
	                  }
	                  if(sauceOrder.getTotalPrice() != 0){
	                     orderCart.add(sauceOrder);                     
	                  }
	                  continue;
	               case 2:
	                  chooseElse(ord);
	                  return;
	               case 0:
	                  return;
	               default:
	                  System.out.println("올바르지 않은 입력입니다.");
	            }         
	         }
	      }
	      
	      
	      /**
	       * 사이드 메뉴, 음료수 선택 메서드
	       * @author 신민경, 구나은
	       * @return 
	       */
	      void chooseElse(OrderVO ord){
	         while (true) {
	            OrderDetailsVO sideOrder = new OrderDetailsVO();
	            OrderDetailsVO beverOrder = new OrderDetailsVO();
	            
	            List<ProductVO> sideList = isim.showSide();
	            List<ProductVO> beverList = isim.showBever();
	            
	            System.out.println("원하는 서비스를 선택하세요☜(ﾟヮﾟ☜)");
	            System.out.println("[1] 사이드/음료 선택 (다중 선택 가능)");
	            System.out.println("[2] 결제하기");
	            System.out.println("[0] 주문취소");
	            int in = 0;
	            try {
	               in = intIn();
	            } catch (Exception e) {
	               System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	               continue;
	            }
	            
	            switch(in){
	               case 1:
	                  System.out.println("[5단계] 선택하실 사이드와 음료의 번호를 입력하세요.");
	                  System.out.println("[Side Menu]");
	                  for(int si = 0; si < sideList.size(); si++){
	                     System.out.println("(" + (si+1) + ") " + sideList.get(si).getName());
	                  }
	                  System.out.println("[Bever Menu]");
	                  for(int be = sideList.size(); be < (beverList.size()+sideList.size()); be++){
	                     System.out.println("(" + (be+1) + ") " + beverList.get(be-sideList.size()).getName());
	                  }
	                  int selNum = 0;
	                  try {
	                     selNum = intIn();
	                  } catch (Exception e) {
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum > beverList.size()+sideList.size()){
	                     System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                     continue;
	                  }
	                  if(selNum <= sideList.size()){
	                     for(ProductVO prod : sideList){
	                        if(prod.getSeq() == sideList.get(selNum-1).getSeq()){
	                           if(prod.isActivate()){
	                              System.out.println("주문하실 개수를 입력하세요.");
	                              int selStock = 0;
	                              try {
	                                 selStock = intIn();
	                              } catch (Exception e) {
	                                 System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                                 continue;
	                              }
	                              if(prod.getStock() > selStock){
	                                 sideOrder.setSeq(++Database.orderDetail_seq);
	                                 sideOrder.setOrder_seq(ord.getSeq());
	                                 sideOrder.setProduct_seq(prod.getSeq());
	                                 sideOrder.setUserStock(selStock);
	                                 sideOrder.setTotalPrice(prod.getPrice() * selStock);
	                                 System.out.println("선택 되었습니다");
	                                 break;
	                              }
	                              System.out.println("주문하신 개수가 물품 잔량보다 많습니다.");
	                              break;
	                           }
	                           System.out.println("선택하신 메뉴는 품절입니다.");
	                           break;
	                        }
	                     }
	                  }else if(selNum <= beverList.size()+sideList.size()){
	                     for(ProductVO prod : beverList){
	                        if(prod.getSeq() == beverList.get(selNum-sideList.size()-1).getSeq()){
	                           if(prod.isActivate()){
	                              System.out.println("주문하실 개수를 입력하세요.");
	                              int selStock = 0;
	                              try {
	                                 selStock = intIn();
	                              } catch (Exception e) {
	                                 System.out.println("[❗알림❗] 올바르지 않은 입력입니다.");
	                                 continue;
	                              }
	                              if(prod.getStock() > selStock){
	                                 beverOrder.setSeq(++Database.orderDetail_seq);
	                                 beverOrder.setOrder_seq(ord.getSeq());
	                                 beverOrder.setProduct_seq(prod.getSeq());
	                                 beverOrder.setUserStock(selStock);
	                                 beverOrder.setTotalPrice(prod.getPrice() * selStock);
	                                 System.out.println("선택 되었습니다");
	                                 break;
	                              }
	                              System.out.println("주문하신 개수가 물품 잔량보다 많습니다.");
	                              break;
	                           }
	                           System.out.println("선택하신 메뉴는 품절입니다.");
	                           break;
	                        }
	                     }
	                  }
	                  
	                  if(sideOrder.getTotalPrice() != 0){
	                     orderCart.add(sideOrder);                     
	                  }
	                  if(beverOrder.getTotalPrice() != 0){
	                     orderCart.add(beverOrder);
	                  }
	                  continue;   
	               case 2:
	                  payment(ord);
	                  return;
	               case 0:
	                  return;
	               default:
	                  System.out.println("올바르지 않은 입력입니다.");
	            }
	         }   
	      }
	   
	//-------------------------------------------------------------------------   
	/**
	 * 
	 * 결제하기 메서드
	 * @author 구나은
	 * @return 
	 */
	 void payment(OrderVO ord){   //주문 번호를 받아옴
	    while(true){
//	       // 장바구니 여기 안에 그간 구매한 것들이 임시저장되어있음 이제 이 친구를 디비로 보낼것임 
	       
	       int total = 0;
	       for(OrderDetailsVO ordD : orderCart){
	          if(ordD.getOrder_seq() == ord.getSeq()){
	             //일단 금액을 뽑아서 합계를 냄
	             total += ordD.getTotalPrice();      
	             //그리고 이 친구들을 디비에 저장하는건 결제가 다 끝나고 나서 하면 될듯 
	          }
	       }
	       
	       //////////////////////////////////////////////////////////////////////
	       System.out.println("-------------💰💰💰💰💰💰-------------");
	       System.out.println("\t     [선택한  메뉴]");
	       List<ProductVO> prodList = isim.showAllProduct();
	       for(OrderDetailsVO odd : orderCart){
	           for(ProductVO prod : prodList){
	        	   if(odd.getProduct_seq() == prod.getSeq()){
	        		   System.out.print("\t    " + prod.getName() + "\t    " + odd.getTotalPrice()+"원\n");
	            	}
	           }
	       }
	       System.out.println("------------------------------------");
	       System.out.println("\t    합계 " + "\t    " + total + "원");
	       System.out.println("-------------💰💰💰💰💰💰-------------");
	       System.out.println("[알림] 결제 하시겠습니까?");
	       System.out.println("[1] 예");
	       System.out.println("[0] 아니오");
	       System.out.println("------------------------------------");
	       System.out.println();
	       
	       int in = 0;
	       try{
	          in = intIn();
	       }catch(Exception e){
	          System.out.println("100만원 이내의 금액을 입력해주세요.");
	          continue;
	       }
	       switch (in) {
	          case 1:
	             if(user.getCash() < total){
	                System.out.println("[알림❗] 잔액이 부족합니다.");
	                return;
	             } else if(user.getCash() >= total||(user.getCash()+user.getPoint()) >= total){
	                selectPayment(ord, total);
	                return;                  
	             }
	          case 0:
	             System.out.println("초기화면으로");
	             return;
	          default:
	             System.out.println("올바르지 않은 입력입니다.");
	       }
	    }
	 }
	       
	/**
	* 결제수단선택 메서드
	* @author 신민경
	* @return 
	*/
	void selectPayment(OrderVO ord, int total){
	   while (true) {
	      System.out.println("------------------------------------");
	      System.out.println("[안내] 결제 방법을 선택해주세요.");
	      System.out.println("[1] 바로 결제");
	      System.out.println("[2] 포인트 사용");
	      System.out.println("[0] 뒤로가기");
	      System.out.println("------------------------------------");
	      int in = 0;
	      try{
	         in = intIn();
	      }catch(Exception e){
	         System.out.println("올바르지 않은 입력입니다.");
	         continue;
	      }
	      switch(in){
	         case 1:
	            subCash(ord, total); //바로결제
	            return;
	         case 2:
	            usePoint(ord, total); //포인트 사용
	            return;
	         case 0:
	            return;   //돌아가기
	         default:
	            System.out.println("올바르지 않은 입력입니다.");
	      }
	   }   
	}   
	
	/**
	* 포인트 사용화면 메서드
	* @author 신민경
	* @return 
	*/
	
	void usePoint(OrderVO ord, int total){
	   while(true){
	      // 해당유저의 point 불러오기 
	      System.out.println("포인트 사용 후 남은 금액은 현금으로 자동 결제됩니다.");
	      System.out.println("[1] 포인트 차감");
	      System.out.println("[0] 뒤로가기");
	      System.out.println();
	      int in = 0;
	      try{
	         in = intIn();
	      }catch(Exception e){
	         System.out.println("올바르지 않은 입력입니다.");
	         continue;
	      }
	      switch (in) {
	         case 1:   //포인트 차감 페이지로 넘어감
	            subPoint(ord, total);
	            return;
	         case 0:
	            return;
	         default:
	            System.out.println("올바르지 않은 입력입니다.");
	         }
	      }
	}
	/**
	* 포인트 차감 메서드
	* @author 구나은
	* @return 
	*/
	
	void subPoint(OrderVO ord, int total){

		// 유저의 point차감, total에서 point만큼 차감
		int userPoint = user.getPoint();
		int last = 0;
		
		if(total > userPoint){
			last = total - userPoint;
			user.setPoint(0);
			System.out.println("사용 포인트 : " + user.getPoint());
			System.out.println("잔여 포인트 : " + 0);
			System.out.println("------------------------------------");
			subCash(ord, last);
			return;
		} else if(total <= userPoint) {
			last = userPoint - total;
			System.out.println("------------------------------------");
			boolean result = isim.insertOrderDetails(orderCart);
			if(result){
				System.out.println("결제가 완료되었습니다.");
				System.out.println("사용 포인트 : " + total);
				System.out.println("잔여 포인트 : " + last);			
			}
			return;			
		}
		
	}
	
	/**
	* 소지금 차감 메서드
	* @author 구나은
	* @return 
	*/   
	void subCash(OrderVO ord, int total){

		int userCash = user.getCash();
		
		if(total > userCash){
			System.out.println("잔액이 부족합니다.");
			return;
		} else if(total <= userCash){
			int last = userCash - total;
			int pp = (int)(total*0.05);
			user.setPoint(user.getPoint()+pp);
			user.setCash(last);			
			boolean result = isim.insertOrderDetails(orderCart);
			isim.subStock(orderCart);
			isim.insertOrder(ord);
			if(result){
				System.out.println("현금 결제 금액 : " + total + " 원");
				System.out.println("잔여 보유 금액 : " + last + " 원");
				System.out.println("결제가 완료되었습니다. 맛있는 햄벅하세요!ヾ(≧▽≦*)o");
			}
			return;
		}
	}
}   
