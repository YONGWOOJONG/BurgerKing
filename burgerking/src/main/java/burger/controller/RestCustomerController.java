package burger.controller;


import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import burger.dto.CustomerDto;
import burger.vo.RequestVo;
import burger.vo.ResponseVo;
import burger.dto.CustomerDto;
import burger.service.CustomerService;

@RestController
@RequestMapping("/api")
public class RestCustomerController {

	@Autowired
	private CustomerService customerservice;

//	@RequestMapping("mypageUpdateForm")
//	public ModelAndView mypageUpdateForm(HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		String loginEmail = (String) session.getAttribute("loginEmail");
//		CustomerDto customer = service.getCustomerInfo(loginEmail);
//		mv.addObject("original", customer);
//		mv.setViewName("/customer/mypage_update_form");
//		return mv;
//	}

//	@RequestMapping("mypageForm")
//	public ModelAndView mypageForm(HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//		String loginEmail = (String) session.getAttribute("loginEmail");
//
//		List<OrderDto> orderListArray = service2.getLastOrder(loginEmail);
//		// 상목
//		HashMap<Integer, String[]> map = new HashMap<>();
//		// 상품 품목수
//		List<Integer> countList = new ArrayList<Integer>();
//
//		for (int i = 0; i < orderListArray.size(); i++) {
//			int count = 0;
//
//			String orderList = orderListArray.get(i).getOrderList();
//
//			String[] orderArray = orderList.split(",");
//			map.put(i, orderArray);
//
//			for (int j = 0; j < orderArray.length; j += 2) {
//				count += 1;
//			}
//			count -= 1;
//			countList.add(count);
//		}
//
//		// 상품이름 불러오기
//		Map<Integer, Object> map2 = new HashMap<>();
//		for (int i = 0; i < orderListArray.size(); i++) {
//			map2.put(i, service3.productName(map.get(i)[0]));
//			System.out.println(service3.productName(map.get(i)[0]));
//		}
//
//		if (loginEmail.equals("s5s5z@naver.com")) {
//			mv.setViewName("/manager/manager_form");
//		} else {
//			// 최근 주문내역 추가
//			mv.addObject("productCount", countList);
//			mv.addObject("productName", map2);
//			mv.addObject("orderInfo", service2.getLastOrder(loginEmail));
//
//			mv.addObject("email", session.getAttribute("loginEmail"));
//			mv.addObject("info", service.getCustomerInfo(loginEmail));
//			mv.addObject("totalPay", service.totalPay(loginEmail));
//			mv.setViewName("/customer/mypage_form");
//		}
//		return mv;
//
//	}

//	@RequestMapping("orderHistoryForm")
//	public ModelAndView orderHistoryForm(HttpSession session) {
//		ModelAndView mv = new ModelAndView();
//
//		String loginEmail = (String) session.getAttribute("loginEmail");
//
//		List<OrderDto> orderListArray = service2.getOrderList(loginEmail);
//
//		HashMap<Integer, String[]> map = new HashMap<>();
//		// 상품 품목수
//		List<Integer> countList = new ArrayList<Integer>();
//
//		for (int i = 0; i < orderListArray.size(); i++) {
//			int count = 0;
//
//			String orderList = orderListArray.get(i).getOrderList();
//
//			String[] orderArray = orderList.split(",");
//			map.put(i, orderArray);
//
//			for (int j = 0; j < orderArray.length; j += 2) {
//				count += 1;
//			}
//			count -= 1;
//			countList.add(count);
//		}
//
//		// 상품이름 불러오기
//		Map<Integer, Object> map2 = new HashMap<>();
//		for (int i = 0; i < orderListArray.size(); i++) {
//			map2.put(i, service3.productName(map.get(i)[0]));
//			System.out.println(service3.productName(map.get(i)[0]));
//		}
//
//		// 상품이미지 불러오기
//		Map<Integer, Object> map3 = new HashMap<>();
//		for (int i = 0; i < orderListArray.size(); i++) {
//			map3.put(i, service3.productImg(map.get(i)[0]));
//		}
//
//		mv.addObject("productCount", countList);
//		mv.addObject("productImg", map3);
//		mv.addObject("productName", map2);
//		mv.addObject("orderInfo", service2.getOrderList(loginEmail));
//		mv.addObject("info", service.getCustomerInfo(loginEmail));
//		mv.addObject("totalPay", service.totalPay(loginEmail));
//		mv.setViewName("/customer/order_history_form");
//		return mv;
//	}

	// REST
	// 회원가입
	@RequestMapping(value = "member", method = RequestMethod.POST)
	public ResponseEntity<String> join(@RequestBody CustomerDto customer) throws Exception {

		String birth = customer.getYear() + "-" + customer.getMonth() + "-" + customer.getDay();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tempDate = format.parse(birth);
		customer.setBirth(tempDate);

		if (customerservice.join(customer)) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}
	}

	// 로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public ResponseEntity<ResponseVo> login(@RequestBody RequestVo requestVo) throws Exception {
		ResponseVo responseVo = customerservice.login(requestVo);
		if (responseVo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(responseVo);
		}
	}

	// 로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.POST)
	public void logout() {
		
	}
	//회원정보 수정
	@RequestMapping(value = "/member/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateMy(@RequestBody CustomerDto customerDto) throws Exception {

		boolean result = customerservice.update(customerDto);

		if (result) {
			return ResponseEntity.status(HttpStatus.OK).body("수정성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("수정실패");
		}
		
	}
	
	

}