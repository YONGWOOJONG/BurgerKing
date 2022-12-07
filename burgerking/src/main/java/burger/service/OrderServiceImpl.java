package burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burger.dto.BasketDto;
import burger.dto.OrderDto;
import burger.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public int insertBasket(BasketDto basket2) throws Exception {
		return orderMapper.insertBasket(basket2);
	}

	@Override
	public int lastOrderNum() throws Exception {
		return orderMapper.lastOrderNum();
	}

	@Override
	public int orderInsert(String loginEmail, int orderNum, String orderAddress, String orderList) throws Exception {
		return orderMapper.orderInsert(loginEmail, orderNum, orderAddress, orderList);
	}

	@Override
	public int basketDelete() throws Exception {
		return orderMapper.basketDelete();
	}

	@Override
	public List<OrderDto> getOrderList(String loginEmail) throws Exception {
		return orderMapper.getOrderList(loginEmail);
	}

	@Override
	public List<OrderDto> getLastOrder(String loginEmail) throws Exception {
		return orderMapper.getLastOrder(loginEmail);
	}

}
