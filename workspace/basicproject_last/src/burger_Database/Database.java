package burger_Database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import burger_Main.RegEx;
import burger_VO.AdminVO;
import burger_VO.KindVO;
import burger_VO.NotifyVO;
import burger_VO.OrderDetailsVO;
import burger_VO.OrderVO;
import burger_VO.ProductVO;
import burger_VO.UserVO;
import burger_VO.QnAVO;


public class Database {

	public static int qna_seq = 1;
	public static int order_seq = 2; 
	public static int orderDetail_seq = 3; 
	public static int product_seq = 0; 
	public static int notify_seq = 20; 
	public static int kind_seq = 0; 
	
	//회원목록
	private final List<UserVO> userList = new ArrayList<>();
	
	// 공지사항
	private final List<NotifyVO> notifyList = new ArrayList<NotifyVO>();
	
	// 질문 목록
	private final List<QnAVO> qnaList = new ArrayList<QnAVO>();
	
	// 상품 목록
	private final List<ProductVO> productList = new ArrayList<>();
	
	// 주문 상세내역 
	private final List<OrderDetailsVO> orderDetailList = new ArrayList<>();
	
	// 주문번호 리스트
	private final List<OrderVO> orderList = new ArrayList<>();
	
	// 종류 리스트
	private final List<KindVO> kindList = new ArrayList<>();
		
	public List<UserVO> getUserList() {
		return userList;
	}

	public List<NotifyVO> getNotifyList() {
		return notifyList;
	}

	public List<QnAVO> getQnaList() {
		return qnaList;
	}

	public List<ProductVO> getProductList() {
		return productList;
	}

	public List<OrderDetailsVO> getOrderDetailList() {
		return orderDetailList;
	}

	public List<OrderVO> getOrderList() {
		return orderList;
	}
	
	public List<KindVO> getKind() {
		return kindList;
	}

	/**
	 * 
	 * user_id가 userList에 있는지 체크하는 메서드
	 * 
	 * @param user_id
	 * @return user_id가 DB에 있으면 true, 없으면 false 리턴 (false일 때 가입 가능)
	 * @author 이경민
	 */
	public boolean idUniqueCheck(String user_id){
		boolean result = false;
		for(UserVO user: userList){
			if(user_id.equals(user.getId())){
				result = true;
			}
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
	public boolean idMatchPw(String user_id,String user_pw){
		boolean result = false;
		for(UserVO user: userList){
			if(user_id.equals(user.getId()) && user_pw.equals(user.getPw())){
				result = true;
				break;
			}
		}
		return result;
	}
	

	/**
	 * 
	 * DB에 신규 유저 정보 등록
	 * 
	 * @param user
	 * @return 가입 성공시 true, 아니면 false반환
	 * @author 이경민
	 */
	public boolean insertUser(UserVO user){
		return userList.add(user);
	}
	
	
	/**
	 * 
	 * login성공한 유저 객체를 보내는 메서드
	 * 
	 * @param user_id, user_pw
	 * @return
	 * @author 이경민
	 */
	public UserVO sendUser(String user_id,String user_pw){
		UserVO userR = new UserVO();
		for(UserVO user: userList){
			if(user_id.equals(user.getId()) && user_pw.equals(user.getPw())){
				userR = user;
				break;
			}
		}
		return userR;
	}
	
	/**
	 * 
	 * 신규 공지를 DB에 저장하는 메서드
	 * 
	 * @param notify
	 * @return 공지 추가에 성공하면 true, 아니면 false 리턴
	 * @author 이경민
	 */
	public boolean insertNotify(NotifyVO notify){
		return notifyList.add(notify);
	} 
	
	/**
	 * 
	 * 수정한 공지 내용을 DB에 저장하는 메서드
	 * 
	 * @param notify
	 * @return 공지 추가에 성공하면 true, 아니면 false 리턴
	 * @author 이경민
	 */
	public boolean updateNotify(Map<String, Object> updateNotifyInfo){
		boolean result = false;
		List<NotifyVO> notiList = getNotifyList();
		for(NotifyVO noti : notiList){
			if(noti.getSeq() == (int)updateNotifyInfo.get("seq")){
				noti.setTitle((String)updateNotifyInfo.get("title"));
				noti.setContents((String)updateNotifyInfo.get("contents"));
				result = true;
			}
		}
		return result;
	} 
	
	/**
	 * @param seq
	 * @return 해당하는 seq의 공지가 삭제되면 true, 아니면 false
	 */
	public boolean deleteNotify(int seq){
		List<NotifyVO> notiList = getNotifyList();
		boolean result = false;
		for(NotifyVO noti : notiList){
			if(noti.getSeq() == seq){
				result = notiList.remove(noti);
				break;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * 같은 이름의 물품이 DB에 있는지 확인하는 메서드
	 * 
	 * @param name
	 * @return 있으면 true, 없으면 false 리턴
	 * @author 이경민
	 */
	public boolean checkProductName(String name){
		boolean result = false;
		List<ProductVO> prodList = getProductList();
		for(ProductVO prod : prodList){
			if(name.equals(prod.getName())){
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * DB에 물품 추가하는 메서드
	 * 
	 * @param product
	 * @return DB의 productList에 product객체가 없으면 추가 후 true리턴,
	 * 		      있으면 추가하지 않고 false리턴.
	 * @author 이경민
	 */
	public boolean insertProduct(ProductVO product) {
		return productList.add(product);
	}
	
	/**
	 * 
	 * 물품 수정 메서드 - 관리자 메서드
	 * 
	 * @param Map<String, Object> updateProductInfo
	 * @return 수정 성공하면 true 아니면 false
	 * @author 이경민
	 */
	public boolean updateProduct(Map<String, Object> updateProductInfo){
		boolean result = false;
		List<ProductVO> prodList = getProductList();
		for(ProductVO prod : prodList){
			if(prod.getSeq() == (int)updateProductInfo.get("seq")){
				if(!(updateProductInfo.get("product_name") == null)){
					prod.setName((String)updateProductInfo.get("product_name"));
				}
				if(!(updateProductInfo.get("product_price")== null)){
					prod.setPrice((int)updateProductInfo.get("product_price"));
				}
				if(!(updateProductInfo.get("product_kind") == null)){
					prod.setKind_name((String)updateProductInfo.get("product_kind"));
				}
				result = true;
				break;
			}
		}
		return result;
	}
	
	/**
	 * 
	 * 물품 판매 상태 변경 메서드 - 관리자 메서드
	 * 
	 * @param seq
	 * @return 일치하는 seq값을 가지고 있는 Product객체의 isActivate = !isActive로 현재 상태 리턴
	 * @author 이경민
	 */
	public boolean changeProductAct(int seq) {
		boolean result = false;
		List<ProductVO> prodList = getProductList();
		for(ProductVO prod : prodList){
			if(prod.getSeq() == seq){
				prod.setActivate(!prod.isActivate());
				result = prod.isActivate();
				break;
			}
		}
		return result;
	}
	
	
	/**
	 * 
	 * DB에 주문 상세 내역 추가하는 메서드
	 * 
	 * @param product
	 * @return DB의 productList에 product객체가 없으면 추가 후 true리턴,
	 * 		      있으면 추가하지 않고 false리턴.
	 * @author 이경민
	 */
	public boolean insertOrderDetails(OrderDetailsVO orderDetails) {
		return orderDetailList.add(orderDetails);
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
	public boolean answerRegister(Map<String, Object> updateComment){
		boolean result = false;
		List<QnAVO> qnaList = getQnaList();
		for(QnAVO qna : qnaList){
			if(qna.getSeq() == (int)updateComment.get("seq")){
				qna.setComment((String)updateComment.get("comment"));
				result = true;
				break;
			}
		}
		return result;
	}
	
	////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param 
	 * @return List<NotifyVO> 공지 리스트 반환
	 * @author 구나은
	 */
	
	public List<NotifyVO> showNoti() {
		return notifyList;
	}
	
	/**
	 * 유저가 공지 번호 눌러서 들어와서 공지사항 확인하는 메서드임
	 * @param 
	 * @return 
	 * @author 구나은
	 */
	public NotifyVO userNotiDetail(int notify_seq) {
		NotifyVO notiDetail = new NotifyVO();
		for(NotifyVO noti : notifyList){
			if(noti.getSeq()==notify_seq){
				notiDetail = noti;
				
			}
		}
		return notiDetail;	
	}
	
	

	/**
	 * 
	 * @param QnAVO userAsk
	 * @return 질문 리스트에 업로드 성공시 true 반환, 실패시 false
	 * @author 구나은
	 */
 
	public boolean insertQnA(QnAVO userAsk) {
		boolean result = qnaList.add(userAsk);
		return result;
	}
	
	

	/**
	 * 
	 * [유저] 유저의 질문목록 보여주는 메서드임 
	 * @param String user_id
	 * @return List<QnAVO> qList
	 * @author 구나은
	 */
	 
	public List<QnAVO> showMyQnA(String user_id) {
		List<QnAVO> qnaList = getQnaList();
		List<QnAVO> result = new ArrayList<>();
		for(QnAVO qna : qnaList){
			if(user_id.equals(qna.getUser_id())){
				result.add(qna);
			}					
		}		
		return result;
	}
	
	/**
	 * 주문내역 보여주는 리스트임 
	 * @param String user_id
	 * @return List<OrderDetailsVO> 구매목록 반환
	 * @author 구나은
	 */
	 
	public List<OrderVO> showAllOrderList(String user_id) {
		List<OrderVO> orderList = getOrderList();
		List<OrderVO> myOrder = new ArrayList<>();
		for(OrderVO order : orderList){
			if(user_id.equals(order.getUser_id())){
				myOrder.add(order);
			}	
		}
		return myOrder;
	}
	
	/**
	 * 
	 * 선택한 번호에 대한 오더정보 호출 
	 * 오더넘버에 맞는 오더디테일
	 * 
	 * @param int ord_seq
	 * @return 주문 상세내역 리스트 리턴
	 * @author 구나은
	 */
	public List<OrderDetailsVO> orderDetail(int ord_seq) {
		List<OrderDetailsVO> odList = getOrderDetailList();
		List<OrderDetailsVO> myOd = new ArrayList<>();
		
		for(OrderDetailsVO od : odList){
			if(ord_seq == od.getOrder_seq()){
				myOd.add(od);
			}
		}
		return myOd;
	}
	
	/**
	 * [유저] 개인정보 업데이트 메서드
	 * 
	 * @param userInfo
	 *            아이디는 바꿀 수 없게 해야함
	 *            <"user_pw", user_pw>
	 *            <"user_name", user_name> 
	 *            <"user_cash", user_cash> 
	 *            <"user_point", user_point> 
	 * @return 성공 true, 실패 false boolean 
	 * @author 구나은
	 */
	public boolean modifyUser(Map<String, Object> userInfo){
		boolean result= false;
		UserVO user = showUser((String)userInfo.get("user_id"));
		if(userInfo.get("user_cash") != null){
			user.setCash((Integer)userInfo.get("user_cash"));
			result = true;
		} else if(userInfo.get("user_pw") != null){
			if(RegEx.pwCheck((String)userInfo.get("user_pw"))){
				user.setPw((String)userInfo.get("user_pw"));
				result = true;				
			} else {
				result = false;
			}
		} else if(userInfo.get("user_name")!=null){
			if(RegEx.nameCheck((String)userInfo.get("user_name"))){
				user.setName((String)userInfo.get("user_name"));
				result = true;	
			}else {
				result = false;
			}
		}
		 return result;
		
	}
	
	/**
	 * 
	 * @param userCash
	 * @return 충전하고 난 최종금액을 반환해줌
	 * @author 구나은 
	 */
	
	public int addCash(Map<String, Object> userCash){
		int total = 0;
		if(modifyUser(userCash)){
			UserVO user = showUser((String)userCash.get("user_id"));
			user.setCash((Integer)userCash.get("user_cash"));
			total = user.getCash();
		}
		return total;
	}
	
	/**
	 * @param user_id
	 * @return 유저 아이디가 성공적으로 비활성화되면 true, 아니면 false
	 * @author 구나은
	 */
	public boolean exitHere(String user_id, String user_pw) {
		boolean result = false;
		UserVO user = sendUser(user_id, user_pw);
		user.setActivate(false);
		result = true;
		return result;
	}
	
	/**
	 * 
	 * @param String user_id
	 * @return 유저 객체 정보 반환 ( 입력받은 아이디로 일치하는 유저 골라서 반환함 )
	 * @author 구나은
	 */

	public UserVO showUser(String user_id){
		UserVO userInfo = new UserVO();		
		for(UserVO user : getUserList()){
			if(user_id.equals(user.getId())){
				userInfo = user;				
			}
		}
		return userInfo;
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////		

	/**
	 * 고기 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	public List<ProductVO> showMeat() {
		List<ProductVO> meatList = new ArrayList<>();
		for(ProductVO prod : getProductList()){
			if(prod.getKind_name().equals("패티")){					
				meatList.add(prod);
			}
		}
		return meatList;
	}
	
	/**
	 * 빵 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	public List<ProductVO> showBread() {
		List<ProductVO> breadList = new ArrayList<>();
		for(ProductVO bread : getProductList()){
			if(bread.getKind_name().equals("빵")){
				breadList.add(bread);
			}
		}
		return breadList;
	}
	
	/**
	 * 야채 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	
	public List<ProductVO> showVegetable() {
		List<ProductVO> vegetableList = new ArrayList<>();
		for(ProductVO vegetable : getProductList()){
			if(vegetable.getKind_name().equals("야채")){
				vegetableList.add(vegetable);
			}
		}
		return vegetableList;
	}
	
	/**
	 * 소스 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	public List<ProductVO> showSauce() {
		List<ProductVO> saucelist = new ArrayList<>();
			for(ProductVO sauce : productList){
				if(sauce.getKind_name().equals("소스")){
					saucelist.add(sauce);
				}
			}
		return saucelist;
	}
	/**
	 * 사이드 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	
	public List<ProductVO> showSide() {
		List<ProductVO> sidelist = new ArrayList<>();
			for(ProductVO side : productList){
				if(side.getKind_name().equals("사이드")){
					sidelist.add(side);
				}
			}
		return sidelist;
	}
	/**
	 * 음료 목록 불러오기 - 관리자 메서드
	 * 
	 * @return ProductVO
	 * @author 신민경
	 * 
	 */
	public List<ProductVO> showBever() {
		List<ProductVO> beverlist = new ArrayList<>();
			for(ProductVO bever : productList){
				if(bever.getKind_name().equals("음료")){
					beverlist.add(bever);
				}
			}
		return beverlist;
	}	
	
	
	/**
	 * 장바구니에 담겨있던 주문내역 저장하는거임 
	 * @param ord
	 * @return
	 */
	public boolean insertOrderDetails(List<OrderDetailsVO> ordD){
		boolean result = false;
		for(OrderDetailsVO od : ordD){
			result = orderDetailList.add(od);			
		}
		return result;
	}
	
	/**
	 * 
	 * @param ordD
	 * @return 재고 감소 성공시 true, 실패 false
	 */
	public boolean subStock(List<OrderDetailsVO> ordD){
		boolean result = false;
		//고객이 seq번째 주문한 상품들만 있는 리스트에서 
		for(OrderDetailsVO ord : ordD){
			for(ProductVO prod : getProductList()){
				if(ord.getProduct_seq() == prod.getSeq()){
					prod.setStock(prod.getStock()-ord.getUserStock());
					result = true;
				}
			}
		}	
		return result;
	}
	
	/**
	 * 
	 * @param ord
	 * @return 주문번호 DB에 추가 성공시 true, 실패 false
	 * 
	 */
	public boolean insertOrder(OrderVO ord){
		boolean result = orderList.add(ord);
		return result;
	}
		
	
	
	
	
	
	
	//kind 초기화 블럭
	{
		KindVO k1 = new KindVO();
		k1.setName("빵");
		kindList.add(k1);
		
		KindVO k2 = new KindVO();
		k2.setName("패티");
		kindList.add(k2);
		
		KindVO k3 = new KindVO();
		k3.setName("야채");
		kindList.add(k3);
		
		KindVO k4 = new KindVO();
		k4.setName("소스");
		kindList.add(k4);
		
		KindVO k5 = new KindVO();
		k5.setName("사이드");
		kindList.add(k5);
		
		KindVO k6 = new KindVO();
		k6.setName("음료");
		kindList.add(k6);
		
	}
	
	
			
	// qna목록 초기화 블럭
		{
			SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			String time1 = f1.format(time);
			
			QnAVO q1 = new QnAVO();
		    q1.setUser_id("number3");
		    q1.setTitle("빵 종류 더 추가할 수는 없나요?");
		    q1.setDate("2021-02-01 03:04:05");
		    q1.setContent("호밀빵하고 플랫브레드 밖에 없는데 \n다른 종류도 추가해주시면 좋을 것 같아요ㅠㅠ\n여기 햄버거 좋아하는데 너무 질려요ㅠ");
		    q1.setComment("원하시는 빵의 종류가 있다면 말씀해주세요.\n적극 반영하도록 하겠습니다.");
		    q1.setSeq(++qna_seq);
		    qnaList.add(q1);
		    
		    QnAVO q2 = new QnAVO();
		    q2.setUser_id("asdasd");
		    q2.setTitle("혹시 프렌차이즈 내실 생각은 없나요?");
		    q2.setDate("2021-02-01 11:11:11");
		    q2.setContent("저 다른 곳으로 이사가는데 거기가 햄벅이랑 너무 멀어서\n여기로 오기가 힘들어요ㅠㅠㅠ");
		    q2.setSeq(++qna_seq);
		    qnaList.add(q2);
			
			QnAVO q3 = new QnAVO();
			q3.setUser_id("number5");
			q3.setTitle("질문하고싶은게 없네요");
			q3.setDate("2021-02-02 10:29:00");
			q3.setContent("발표를 잘하는 이경민입니다.");
			q3.setComment("동감합니다.");
			q3.setSeq(++qna_seq);
			qnaList.add(q3);
			
			QnAVO q4 = new QnAVO();
			q4.setUser_id("number3");
			q4.setTitle("직원분이 너무 친절하셨어요~!");
			q4.setDate(time1);
			q4.setContent("햄버거가 친절하고 직원이 맛있어요!");
			q4.setSeq(++qna_seq);
			qnaList.add(q4);

			
			QnAVO q5 = new QnAVO();
			q5.setUser_id("asdasd");
			q5.setTitle("배가고파요");
			q5.setDate(time1);
			q5.setContent("오늘 점심은 삶은달걀과 포테이토팝스입니다.");
			q5.setComment("돼지.");
			q5.setSeq(++qna_seq);
			qnaList.add(q5);

			QnAVO q6 = new QnAVO();
			q6.setUser_id("number3");
			q6.setTitle("도시락 주문 하셨나요?");
			q6.setDate(time1);
			q6.setContent("늦으면 주문 못함 ㅅㄱ");
			q6.setSeq(++qna_seq);
			qnaList.add(q6);
			
		}

		//UserVO 회원목록 초기화블럭
		{
			UserVO user1 = new UserVO();
			user1.setId("asdasd"); 
			user1.setPw("asdasd");
			user1.setName("구나은");
			user1.setCash(100000);
			user1.setPoint(500);
			user1.setActivate(true);
			userList.add(user1);
		
			UserVO user2 = new UserVO();
			user2.setId("number3"); 
			user2.setPw("number3");
			user2.setName("신민경");
			user2.setCash(10000);
			user2.setPoint(500);
			user2.setActivate(true);
			userList.add(user2);
			
			UserVO user3 = new UserVO();
			user3.setId("number5"); 
			user3.setPw("number5");
			user3.setName("이경민");
			user3.setCash(10000);
			user3.setPoint(500);
			user3.setActivate(true);
			userList.add(user3);
			
			UserVO user4 = new UserVO();
			user4.setId("number10"); 
			user4.setPw("number10");
			user4.setName("박상빈");
			user4.setCash(10000);
			user4.setPoint(500);
			user4.setActivate(true);
			userList.add(user4);
			
			UserVO user5 = new UserVO();
			user5.setId("number11"); 
			user5.setPw("number11");
			user5.setName("길민선");
			user5.setCash(10000);
			user5.setPoint(500);
			user5.setActivate(true);
			userList.add(user5);
			
		}
				
				
		
		//NotifyVO 공지목록 초기화블럭
		{
			SimpleDateFormat f1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			String time1 = f1.format(time);
			
			NotifyVO n1 = new NotifyVO();
			n1.setSeq(++notify_seq);
			n1.setTitle("안녕하세요, 햄벅입니다!");
			n1.setDate("2020-12-16 03:04:05");
			n1.setContents("안녕하세요, 매장 신규 이벤트가 곧 진행될 예정이오니 잠시 기다려주세요!");
			notifyList.add(n1);
			
			NotifyVO n2 = new NotifyVO();
			n2.setSeq(++notify_seq);
			n2.setTitle("연말 이벤트 안내");
			n2.setDate("2020-12-20 03:04:05");
			n2.setContents("곧 다가올 크리스마스를 대비해 햄벅에서 할인 이벤트를 진행합니다! 자세한건 매장 직원에게 문의해주세요!");
			notifyList.add(n2);
			
			NotifyVO n3 = new NotifyVO();
			n3.setSeq(++notify_seq);
			n3.setTitle("새해 복 많이 받으세요");
			n3.setDate("2021-01-01 01:24:28");
			n3.setContents("햄벅은 연중무휴 언제나 영업중입니다!");
			notifyList.add(n3);
			
			NotifyVO n4 = new NotifyVO();
			n4.setSeq(++notify_seq);
			n4.setTitle("매장 리뉴얼 안내 [02/01 ~ 02/04]");
			n4.setDate("2021-02-01");
			n4.setContents("곧 새로운 햄벅으로 찾아뵙겠습니다. 잠시 기다려주세요!");
			notifyList.add(n4);
			
			NotifyVO n5 = new NotifyVO();
			n5.setSeq(++notify_seq);
			n5.setTitle("신규 매장 개설 안내");
			n5.setDate(time1);
			n5.setContents("대전에 신규 매장이 입점했습니다, 많은 이용 부탁드립니다.");
			notifyList.add(n5);

		}
				
		//제품목록 초기화 블럭
		//seq 1: 호밀빵, 2: 플랫브레드, 3: 비프, 4: 포크, 5: 치킨, 6: 양상추
		//    7: 양파, 8: 토마토, 9: 핫소스, 10: 마요네즈, 11: 케첩, 12: 코울슬로, 13: 치킨랩
		//   14: 감자튀김, 15: 스프라이트, 16: 콜라, 17: 아메리카노
		{
			ProductVO p1 = new ProductVO();
			p1.setSeq(++product_seq);
			p1.setKind_name("빵");	
			p1.setName("호밀빵");
			p1.setPrice(1500);
			p1.setStock(3000);
			p1.setActivate(true);
			insertProduct(p1);
			
			ProductVO p2 = new ProductVO();
			p2.setSeq(++product_seq);
			p2.setKind_name("빵");
			p2.setName("플랫브레드");
			p2.setPrice(2000);
			p2.setStock(3000);
			p2.setActivate(true);
			insertProduct(p2);
			
			ProductVO p3 = new ProductVO();
			p3.setSeq(++product_seq);
			p3.setKind_name("패티");
			p3.setName("소고기 패티");
			p3.setPrice(2500);
			p3.setStock(3000);
			p3.setActivate(true);
			insertProduct(p3);
			
			ProductVO p4 = new ProductVO();
			p4.setSeq(++product_seq);
			p4.setKind_name("패티");
			p4.setName("포크");
			p4.setPrice(2100);
			p4.setStock(3000);
			p4.setActivate(true);
			insertProduct(p4);
			
			ProductVO p5 = new ProductVO();
			p5.setSeq(++product_seq);
			p5.setKind_name("패티");
			p5.setName("닭다리살");
			p5.setPrice(1800);
			p5.setStock(3000);
			p5.setActivate(true);
			insertProduct(p5);
			
			ProductVO p6 = new ProductVO();
			p6.setSeq(++product_seq);
			p6.setKind_name("야채");
			p6.setName("양상추");
			p6.setPrice(500);
			p6.setStock(3000);
			p6.setActivate(true);
			insertProduct(p6);
			
			ProductVO p7 = new ProductVO();
			p7.setSeq(++product_seq);
			p7.setKind_name("야채");
			p7.setName("양파");
			p7.setPrice(500);
			p7.setStock(3000);
			p7.setActivate(true);
			insertProduct(p7);
			
			
			ProductVO p8 = new ProductVO();
			p8.setSeq(++product_seq);
			p8.setKind_name("야채");
			p8.setName("토마토");
			p8.setPrice(500);
			p8.setStock(3000);
			p8.setActivate(true);	
			insertProduct(p8);
			
			ProductVO p9 = new ProductVO();
			p9.setSeq(++product_seq);
			p9.setKind_name("소스");
			p9.setName("핫소스");
			p9.setPrice(200);
			p9.setStock(3000);
			p9.setActivate(true);
			insertProduct(p9);
			
			ProductVO p10 = new ProductVO();
			p10.setSeq(++product_seq);
			p10.setKind_name("소스");
			p10.setName("마요네즈");
			p10.setPrice(200);
			p10.setStock(3000);
			p10.setActivate(true);
			insertProduct(p10);
			
			ProductVO p11 = new ProductVO();
			p11.setSeq(++product_seq);
			p11.setKind_name("소스");
			p11.setName("케첩");
			p11.setPrice(200);
			p11.setStock(3000);
			p11.setActivate(true);
			insertProduct(p11);
						
			ProductVO p12 = new ProductVO();
			p12.setSeq(++product_seq);
			p12.setKind_name("사이드");
			p12.setName("코울슬로");
			p12.setPrice(2400);
			p12.setStock(3000);
			p12.setActivate(true);
			insertProduct(p12);
			
			ProductVO p13 = new ProductVO();
			p13.setSeq(++product_seq);
			p13.setKind_name("사이드");
			p13.setName("치킨랩");
			p13.setPrice(2400);
			p13.setStock(3000);
			p13.setActivate(true);
			insertProduct(p13);
			
			ProductVO p14 = new ProductVO();
			p14.setSeq(++product_seq);
			p14.setKind_name("사이드");
			p14.setName("감자튀김");
			p14.setPrice(2400);
			p14.setStock(3000);
			p14.setActivate(true);
			insertProduct(p14);
			
			ProductVO p15 = new ProductVO();
			p15.setSeq(++product_seq);
			p15.setKind_name("음료");
			p15.setName("사이다");
			p15.setPrice(1100);
			p15.setStock(3000);
			p15.setActivate(true);
			insertProduct(p15);
			
			ProductVO p16 = new ProductVO();
			p16.setSeq(++product_seq);
			p16.setKind_name("음료");
			p16.setName("콜라");
			p16.setPrice(1100);
			p16.setStock(3000);
			p16.setActivate(true);
			insertProduct(p16);
			
			ProductVO p17 = new ProductVO();
			p17.setSeq(++product_seq);
			p17.setKind_name("음료");
			p17.setName("아메리카노");
			p17.setPrice(1100);
			p17.setStock(3000);
			p17.setActivate(true);
			insertProduct(p17);
			
			
		}
		
		{
			OrderDetailsVO od1 = new OrderDetailsVO();
			od1.setOrder_seq(++order_seq);
			od1.setSeq(++orderDetail_seq);
			od1.setTotalPrice(10000);
			od1.setUserStock(4);
			insertOrderDetails(od1);
			
			OrderDetailsVO od2 = new OrderDetailsVO();
			od2.setOrder_seq(++order_seq);
			od2.setSeq(++orderDetail_seq);
			od2.setTotalPrice(105550);
			od2.setUserStock(4);
			insertOrderDetails(od2);
			
			OrderDetailsVO od3 = new OrderDetailsVO();
			od3.setOrder_seq(++order_seq);
			od3.setSeq(++orderDetail_seq);
			od3.setTotalPrice(102220);
			od3.setUserStock(4);
			insertOrderDetails(od3);
			
			OrderDetailsVO od4 = new OrderDetailsVO();
			od4.setOrder_seq(++order_seq);
			od4.setSeq(++orderDetail_seq);
			od4.setTotalPrice(104400);
			od4.setUserStock(4);
			insertOrderDetails(od4);
			
			OrderDetailsVO od5 = new OrderDetailsVO();
			od5.setOrder_seq(++order_seq);
			od5.setSeq(++orderDetail_seq);
			od5.setTotalPrice(10000);
			od5.setUserStock(4);
			insertOrderDetails(od5);
		}
		
		
		
		
		
	

}