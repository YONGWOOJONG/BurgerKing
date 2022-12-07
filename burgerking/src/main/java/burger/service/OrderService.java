package burger.service;

import java.util.List;

import burger.dto.BasketDto;
import burger.dto.OrderDto;

public interface OrderService {

	public int insertBasket(BasketDto basket2) throws Exception;

	// 마지막 오더 넘버 조회
	public int lastOrderNum() throws Exception;

	public int orderInsert(String loginEmail, int orderNum, String orderAddress, String orderList) throws Exception;

	public int basketDelete() throws Exception;

	public List<OrderDto> getOrderList(String loginEmail) throws Exception;

	public List<OrderDto> getLastOrder(String loginEmail) throws Exception;
}