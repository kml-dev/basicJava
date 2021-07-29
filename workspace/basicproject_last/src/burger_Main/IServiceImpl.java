package burger_Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import burger_VO.NotifyVO;
import burger_Database.Database;
import burger_VO.OrderDetailsVO;
import burger_VO.OrderVO;
import burger_VO.ProductVO;
import burger_VO.QnAVO;
import burger_VO.UserVO;

public class IServiceImpl implements IService{
	Database database = new Database();
	
	/**
	 * 회원가입 - 유저 정보 DB에 입력
	 * 
	 * @param user
	 * @return DB에 insert성공 시 true, 실패 시 false 반환
	 * @author 이경민
	 */
	@Override
	public boolean insertUser(UserVO user) {
		return database.insertUser(user);
	}
	
	/**
	 * id가 DB에서 중복되는지 체크하는 메서드
	 * 
	 * @param user_id
	 * @return DB에 해당하는 id가 있으면 true, 없으면 false 반환 (false일 때 가입가능)
	 * @author 이경민
	 */
	@Override
	public boolean checkId(String user_id) {
		boolean result = false;
		if(database.idUniqueCheck(user_id)){
			result = true;
		}
		return result;
	}
	
	/**
	 * 
	 * user_pw가 user_id와 일치하는지 체크하는 메서드
	 * 
	 * @param user_id, user_pw
	 * @return user_id와 user_pw가 일치하면 true, 일치하지 않으면 false 리턴
	 * @author 이경민
	 * 
	 */
	@Override
	public boolean loginSuccess(String user_id,String user_pw){
		boolean result = database.idMatchPw(user_id, user_pw);
		return result;
	}
	
	/**
	 * 
	 * user_pw가 user_id와 일치하는 객체 받아오는 메서드
	 * 
	 * @return user_id와 user_pw가 일치하는 객체 리턴
	 * @author 이경민
	 * 
	 */
	@Override
	public UserVO getUserInfo(String user_id, String user_pw){
		UserVO user = database.sendUser(user_id, user_pw);
		return user;
	}
	
	///////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * 공지 목록 불러오기 - 관리자 메서드
	 * 
	 * @return List<NotifyVO> : 모든 공지 목록을 리스트에 담아 반환
	 * @author 이경민
	 * 
	 */
	@Override
	public List<NotifyVO> showAllNotify() {
		return database.getNotifyList();
	}
	
	/**
	 * 공지 추가 메서드  - 관리자 메서드
	 * 
	 * @param notify
	 * @return DB에 공지가 추가되면 true, 실패하면 false를 반환 
	 * @author 이경민
	 */
	@Override
	public boolean insertNotify(NotifyVO notify) {
		return database.insertNotify(notify);
	}
	
	/**
	 * 
	 * 공지 선택 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return 해당하는 seq의 객체 리턴 
	 * @author 이경민
	 */
	@Override
	public NotifyVO selectNotify(int seq) {
		List<NotifyVO> notiList = database.getNotifyList();
		NotifyVO selNoti = new NotifyVO();
		for(NotifyVO noti : notiList){
			if(seq == noti.getSeq()){
				selNoti = noti;
				break;
			}
		}
		return selNoti;
	}

	/**
	 * 공지 수정 메서드 - 관리자 메서드
	 * 
	 * @param Map<String, Object> updateNotifyInfo
	 * @return 수정 성공 true, 실패 false
	 * @author 이경민
	 * 
	 */
	@Override
	public boolean updateNotify(Map<String, Object> updateNotifyInfo) {
		boolean result = database.updateNotify(updateNotifyInfo);
		return result;
	}
	
	/**
	 * 
	 * 공지 삭제 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return DB에서 seq와 일치하는 객체가 있으면 notifyList에서 삭제 후 true리턴, 없으면 false리턴  
	 * @author 이경민
	 */
	
	@Override
	public boolean deleteNotify(int seq) {
		boolean result = database.deleteNotify(seq);
		return result;
	}
	
	/**
	 * 
	 * 물품 목록 조회 메서드 - 관리자 메서드
	 * 
	 * @author 이경민
	 */
	@Override
	public List<ProductVO> showAllProduct() {
		return database.getProductList();
	}
	
	/**
	 * 
	 * 같은 이름의 물품이 DB에 있는지 확인하는 메서드
	 * 
	 * @param name
	 * @return 있으면 true, 없으면 false 리턴 (false면 물품 추가 가능)
	 * @author 이경민
	 */
	@Override
	public boolean checkProductName(String name){
		boolean result = database.checkProductName(name);
		return result;
	}
	
	/**
	 * 
	 * 물품 추가 메서드 - 관리자 메서드 
	 * 
	 * @param product
	 * @return DB의 productList에 product객체가 없으면 추가 후 true리턴,
	 * 		      있으면 추가하지 않고 false리턴.
	 * @author 이경민
	 */
	@Override
	public boolean insertProduct(ProductVO product) {
		return database.insertProduct(product);
	}

	/**
	 * 
	 * 물품 선택 메서드 - 관리자 메서드
	 * 
	 * @param 해당하는 seq의 물품 객체 불러오기
	 * @return 불러오기 성공 true, 실패 false
	 * @author 이경민
	 */
	@Override
	public ProductVO selectProduct(int seq) {
		List<ProductVO> prodList = database.getProductList();
		ProductVO selProd = new ProductVO();
		for(ProductVO prod : prodList){
			if(seq == prod.getSeq()){
				selProd = prod;
				break;
			}
		}
		return selProd;
	}
	
	/**
	 * 
	 * 물품 수정 메서드 - 관리자 메서드
	 * 
	 * @param Map<String, Object> updateProductInfo
	 * @return 수정 성공하면 true 아니면 false
	 * @author 이경민
	 */
	@Override
	public boolean updateProduct(Map<String, Object> updateProductInfo){
		boolean result = database.updateProduct(updateProductInfo);
		return result;
	}
	
	/**
	 * 
	 * 물품 판매 상태 변경 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return 일치하는 seq값을 가지고 있는 Product객체의 isActivate = !isActive로 바꾸고 현재 상태 리턴
	 * @author 이경민
	 */
	@Override
	public boolean changeProductAct(int seq) {
		boolean result = database.changeProductAct(seq);
		return result;
	}
	
	/**
	 * 
	 * 회원 목록 조회 - 관리자 메서드
	 * 
	 * @return 유저 객체를 담고 있는 List리턴
	 * @author 이경민
	 */
	@Override
	public List<UserVO> showAllUser() {
		return database.getUserList();
	}
	
	/**
	 * 
	 * 회원 선택 메서드 - 관리자 메서드
	 * 
	 * @param 해당하는 user_id의  회원 객체 불러오기
	 * @return 불러오기 성공 true, 실패 false
	 * @author 이경민
	 */
	@Override
	public UserVO selectUser(String user_id) {
		List<UserVO> userList = database.getUserList();
		UserVO selUser = new UserVO();
		for(UserVO user : userList){
			if(user_id.equals(user.getId())){
				selUser = user;
				break;
			}
		}
		return selUser;
	}
	
	/**
	 * 
	 * 회원 구매내역 조회 - 관리자 메서드
	 * 
	 * @param user_id
	 * @return user_id와 일치하는 객체 반환
	 * @author 이경민
	 */
	@Override
	public List<OrderDetailsVO> showOrderInfo(String user_id) {
		List<OrderVO> ordList = database.getOrderList();
		List<OrderDetailsVO> ordDList = database.getOrderDetailList();
		List<OrderDetailsVO> selOd = new ArrayList<>();
		
		for(OrderVO ord : ordList){
			if(ord.getUser_id().equals(user_id)){
				for(OrderDetailsVO ordD : ordDList){
					if(ord.getSeq() == ordD.getOrder_seq()){
						selOd.add(ordD);
					}
				}
			}
		}
		return selOd;
	}
	
	/**
	 * 
	 * 질문 내역 불러오기 - 관리자 메서드
	 * 
	 * @author 이경민
	 */
	@Override
	public List<QnAVO> showAllQnA() {
		return database.getQnaList();
	}

	/**
	 * 
	 * 답변 등록 메서드 - 관리자 메서드
	 * 
	 * @param Map<String, Object> updateComment
	 * @return seq에 해당하는 qna의  comment를 변경후 성공시 true리턴, 없으면 false리턴
	 * @author 이경민
	 * 
	 */
	@Override
	public boolean answerRegister(Map<String, Object> updateComment){
		boolean result = database.answerRegister(updateComment);
		return result;
	}
	
	////////////////////////////////////////////////////////////////////////
	
	/**
	 * 고기 목록 보기 - 사용자 메서드
	 * 
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showMeat() {
		return database.showMeat();
	}
	
	/**
	 * 빵 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showBread() {
		return database.showBread();
	}
	
	/**
	 * 야채 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showVegetable() {
		return database.showVegetable();
	}
	
	/**
	 * 소스 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return 일치하는 productList리턴
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showSauce() {
		return database.showSauce();
	}
	
	/**
	 * 
	 * 사이드 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showSide() {
		return database.showSide();
	}
	
	/**
	 * 
	 * 음료 목록 보기 - 사용자 메서드
	 * @param kind_name
	 * @return
	 * @author 신민경
	 */
	@Override
	public List<ProductVO> showBever() {
		return database.showBever();
	}

	/**
	 * 장바구니에 담겨있던 주문내역 저장하는거임 
	 * @param ord
	 * @return
	 */
	public boolean insertOrderDetails(List<OrderDetailsVO> ordD){
		return database.insertOrderDetails(ordD);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
		
	/**
	 * 
	 * @param notify_seq
	 * @return 입력받은 번호에 해당하는 공지 객체 반환
	 * @author 구나은
	 */
	@Override
	public NotifyVO userNotiDetail(int notify_seq) {
		NotifyVO notiDetail = database.userNotiDetail(notify_seq);
		return notiDetail;
	}
	
	/**
	 * [유저] 새로운 질문 등록
	 * @param QnAVO userAsk
	 * @return 성공하면 true
	 * @author 구나은
	 */
	@Override
	public boolean insertQnA(QnAVO userAsk) {
		boolean result = database.insertQnA(userAsk);
		return result;
	}
	
	/**
	 * 
	 * [유저] 유저의 질문목록 보여주는 메서드임 
	 * @param String user_id
	 * @return List<QnAVO> 타입의 질문목록 반환함.
	 * @author 구나은
	 */
	@Override
	public List<QnAVO> showMyQnA(String user_id) {
		return database.showMyQnA(user_id);
	}
	
	/**
	 * 
	 * @param String user_id
	 * @return UserVO 유저정보반환
	 * @author 구나은
	 */
	@Override
	public UserVO showUser(String user_id) {
		UserVO user = database.showUser(user_id);
		return user;
	}
	
	/**
	 * 
	 * @param String user_id
	 * @return List<OrderVO> 구매목록 반환 / showMyList에서 호출중임
	 * @author 구나은
	 */
	@Override
	public List<OrderVO> showAllOrderList(String user_id) {
		List<OrderVO> orderList = database.showAllOrderList(user_id);
		return orderList;
	}
	
	/**
	 * 
	 * 선택한 번호에 대한 오더정보 호출
	 * @param int ord_seq
	 * @return 주문 상세내역 리스트 리턴
	 * @author 구나은
	 */
	@Override
	public List<OrderDetailsVO> orderDetail(int ord_seq) {
		List<OrderDetailsVO> od = database.orderDetail(ord_seq);
		return od;
	}
	
	/**
	 * @param Map<String, Object> userInfo
	 * @return 수정에 성공하면 true, 실패하면 false
	 * @author 구나은
	 */
	@Override
	public boolean modifyUser(Map<String, Object> userInfo) {
		boolean result = database.modifyUser(userInfo);
		return result;
	}
	
	/**
	 * @param user_id
	 * @return 유저 아이디가 성공적으로 비활성화되면 true, 아니면 false
	 * @author 구나은
	 */
	@Override
	public boolean exitHere(String user_id, String user_pw) {
		boolean result = database.exitHere(user_id, user_pw);
		return result;
	}
	
	/**
	 * 
	 * @param Map<String, Object> userCash {"user_id":user_id, "user_cash":user_cash}
	 * @return 충전후 총 금액 반환
	 * @author 구나은
	 */
	@Override
	public int addCash(Map<String, Object> userCash){
		int result = database.addCash(userCash);
		return result;
	}
	
	/**
	 * 
	 * @param ordD
	 * @return
	 */
	public boolean subStock(List<OrderDetailsVO> ordD){
		return database.subStock(ordD);
	}
	
	/**
	 * 
	 * @param ord
	 * @return 주문번호 DB에 추가 성공시 true, 실패 false
	 * 
	 */
	public boolean insertOrder(OrderVO ord){
		return database.insertOrder(ord);
	}

}