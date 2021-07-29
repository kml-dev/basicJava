package burger_Main;


import java.util.List;
import java.util.Map;

import burger_VO.NotifyVO;
import burger_VO.OrderDetailsVO;
import burger_VO.OrderVO;
import burger_VO.ProductVO;
import burger_VO.QnAVO;
import burger_VO.UserVO;

public interface IService {
	
	/**
	 * 회원가입 - 유저 정보 DB에 입력
	 * 
	 * @param user
	 * @return DB에 insert성공 시 true, 실패 시 false 반환
	 * @author 이경민
	 */
	boolean insertUser(UserVO user);

	/**
	 * id가 DB에서 중복되는지 체크하는 메서드
	 * 
	 * @param user_id
	 * @return DB에 해당하는 id가 있으면 true, 없으면 false 반환 (false일 때 가입가능)
	 * @author 이경민
	 */
	boolean checkId(String id);
	
	/**
	 * 
	 * user_pw가 user_id와 일치하는지 체크하는 메서드
	 * 
	 * @param user_id, user_pw
	 * @return user_id와 user_pw가 일치하면 true, 일치하지 않으면 false 리턴
	 * @author 이경민
	 * 
	 */
	public boolean loginSuccess(String user_id,String user_pw);
	
	/**
	 * 
	 * user_pw가 user_id와 일치하는 객체 받아오는 메서드
	 * 
	 * @return user_id와 user_pw가 일치하는 객체 리턴
	 * @author 이경민
	 * 
	 */
	public UserVO getUserInfo(String user_id, String user_pw);
	
	/**
	 * 
	 * 공지 목록 불러오기 - 관리자 메서드
	 * 
	 * @return List<NotifyVO> : 모든 공지 목록을 리스트에 담아 반환
	 * @author 이경민
	 * 
	 */
	List<NotifyVO> showAllNotify();
	
	/**
	 * 공지 추가 메서드  - 관리자 메서드
	 * 
	 * @param notify
	 * @return DB에 공지가 추가되면 true, 실패하면 false를 반환 
	 * @author 이경민
	 */
	boolean insertNotify(NotifyVO notify);
	
	/**
	 * 
	 * 공지 선택 메서드 - 관리자 메서드
	 * 
	 * @param 해당하는 seq의 공지 객체 불러오기
	 * @return 불러오기 성공 true, 실패 false
	 * @author 이경민
	 */
	NotifyVO selectNotify(int seq);
	
	
	
	/**
	 * 공지 수정 메서드 - 관리자 메서드
	 * 
	 * @param updateNotifyInfo 
	 * @return  성공 true, 실패 false
	 * @author 이경민
	 * 
	 */
	boolean updateNotify(Map<String, Object> updateNotifyInfo);
	
	/**
	 * 
	 * 공지 삭제 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return DB에서 seq와 일치하는 객체가 있으면 notifyList에서 삭제 후 true리턴, 없으면 false리턴  
	 * @author 이경민
	 */
	boolean deleteNotify(int seq); //매개변수
	
	/**
	 * 
	 * 물품 목록 조회 메서드 - 관리자 메서드
	 * 
	 * @author 이경민
	 */
	List<ProductVO> showAllProduct();
	
	/**
	 * 
	 * 같은 이름의 물품이 DB에 있는지 확인하는 메서드
	 * 
	 * @param name
	 * @return 있으면 true, 없으면 false 리턴
	 * @author 이경민
	 */
	boolean checkProductName(String name);
	
	/**
	 * 
	 * 물품 추가 메서드 - 관리자 메서드 
	 * 
	 * @param product
	 * @return DB의 productList에 product객체가 없으면 추가 후 true리턴,
	 * 		      있으면 추가하지 않고 false리턴.
	 * @author 이경민
	 */
	boolean insertProduct(ProductVO product);
	
	
	/**
	 * 
	 * 물품 선택 메서드 - 관리자 메서드
	 * 
	 * @param 해당하는 seq의 물품 객체 불러오기
	 * @return 불러오기 성공 true, 실패 false
	 * @author 이경민
	 */
	ProductVO selectProduct(int seq);
	
	
	/**
	 * 
	 * 물품 수정 메서드 - 관리자 메서드
	 * 
	 * @param  Map<String, Object> updateProductInfo
	 * @return 수정 성공하면 true 아니면 false
	 * @author 이경민
	 */
	boolean updateProduct(Map<String, Object> updateProductInfo);
	
	
	
	/**
	 * 
	 * 물품 판매 상태 변경 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return 일치하는 seq값을 가지고 있는 Product객체의 isActivate = !isActive로 바꾸고 현재 상태 리턴
	 * @author 이경민
	 */
	boolean changeProductAct(int seq);
	
	/**
	 * 
	 * 회원 목록 조회 - 관리자 메서드
	 * 
	 * @return 유저 객체를 담고 있는 List리턴
	 * @author 이경민
	 */
	List<UserVO> showAllUser();
	
	/**
	 * 
	 * 회원 선택 메서드 - 관리자 메서드
	 * 
	 * @param 해당하는 user_id의  회원 객체 불러오기
	 * @return 불러오기 성공 true, 실패 false
	 * @author 이경민
	 */
	UserVO selectUser(String user_id);
	
	/**
	 * 
	 * 회원 구매내역 조회 - 관리자 메서드
	 * 
	 * @param ser_id
	 * @return userId와 일치하는 객체  반환
	 * @author 이경민
	 */
	List<OrderDetailsVO> showOrderInfo(String user_id);
	
	/**
	 * 
	 * 질문 내역 불러오기 - 관리자 메서드
	 * 
	 * @author 이경민
	 */
	List<QnAVO> showAllQnA(); 
	
	/**
	 * 
	 * 답변 등록 메서드 - 관리자 메서드
	 * 
	 * @param Map<String, Object> updateComment
	 * @return seq에 해당하는 qna의  comment를 변경후 성공시 true리턴, 없으면 false리턴
	 * @author 이경민
	 * 
	 */
	boolean answerRegister(Map<String, Object> updateComment); // Map 어떤글, 답변내용
	
	///////////////////////////////////////////////////////////////////////////////////
	/**
	 * 고기 목록 보기 - 사용자 메서드
	 * 
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	List<ProductVO> showMeat();
	
	/**
	 * 빵 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	List<ProductVO> showBread();
	
	/**
	 * 야채 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	List<ProductVO> showVegetable();
	
	/**
	 * 소스 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	List<ProductVO> showSauce();
	
	/**
	 * 
	 * 사이드 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return
	 * @author 신민경
	 */
	List<ProductVO> showSide();
	
	/**
	 * 
	 * 음료 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return
	 * @author 신민경
	 */
	List<ProductVO> showBever();
	
	/**
	 * 장바구니에 담겨있던 주문내역 저장하는거임 
	 * @param ord
	 * @return
	 */
	public boolean insertOrderDetails(List<OrderDetailsVO> ordD);
	
	/**
	 * 
	 * @param ordD
	 * @return
	 */
	public boolean subStock(List<OrderDetailsVO> ordD);
	
	/**
	 * 
	 * @param ord
	 * @return 주문번호 DB에 추가 성공시 true, 실패 false
	 * 
	 */
	public boolean insertOrder(OrderVO ord);

	///////////////////////////////////////////////////////////////////////////////////
	
		
	/** [유저] 선택한 공지 확인하기 
	 * 
	 * @param notify_seq
	 * @return NotifyVO
	 * @author 구나은
	 */
	NotifyVO userNotiDetail(int notify_seq);
	
	/**
	 * [유저] 개인정보 가져오기 (마이페이지에 출력할 것)
	 * 
	 * @param user_id
	 * @return UserVO
	 * @author 구나은
	 */
	UserVO showUser(String user_id);
	
	/**
	 * [유저] 나의 주문내역 전체 보기 
	 * 
	 * @param user_id
	 * @return List<OrderVO>
	 * @author 구나은
	 */
	List<OrderVO> showAllOrderList(String user_id);
	
	
	/**
	 * 
	 * @param ord_seq
	 * @return 주문 상세내역 리스트 리턴
	 * @author 구나은
	 */
	List<OrderDetailsVO> orderDetail(int ord_seq);
	
	/**
	 * [유저] 개인정보 업데이트 메서드
	 * 
	 * @param userInfo
	 *            <"user_id", user_id> 아이디는 바꿀 수 없게 해야함 set안넣으면 되는거 
	 *            <"user_pw", user_pw>
	 *            <"user_name", user_name>
	 * @return 성공 true, 실패 false boolean 
	 * @author 구나은
	 */
	boolean modifyUser(Map<String, Object> userInfo);
	
	/**
	 * [유저] 금액 충전 메서드 
	 * 
	 * @param userCash
	 * @return 충전후 총 금액 반환
	 * @author 구나은
	 */
	int addCash(Map<String, Object> userCash);
	
	/**
	 * [유저] 새로운 질문 등록
	 * @param QnAVO userAsk
	 * @return 성공하면 true
	 * @author 구나은
	 */
	public boolean insertQnA(QnAVO userAsk);

	/**
	 * [유저] 내 질문 가져오기 
	 * 
	 * @param user_id
	 * @return List<QnAVO>
	 * @author 구나은
	 */
	List<QnAVO> showMyQnA(String user_id);
	
	
	/**
	 * [유저] 탈퇴 메서드
	 * 
	 * @param user_id 와 일치하는 객체의 isActivate false로
	 * @return 성공 true, 실패 false boolean
	 * @author 구나은
	 */
	boolean exitHere(String user_id, String user_pw);
}