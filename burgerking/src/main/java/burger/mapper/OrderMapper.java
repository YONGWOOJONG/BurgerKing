package burger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import burger.dto.BasketDto;
import burger.dto.OrderDto;

@Mapper
public interface OrderMapper {
	int insertBasket(BasketDto basket2) throws Exception;

	// 마지막 오더 넘버 조회
	int lastOrderNum() throws Exception;

	int orderInsert(String loginEmail, int orderNum, String orderAddress, String orderList) throws Exception;

	int basketDelete() throws Exception;

	List<OrderDto> getOrderList(String loginEmail) throws Exception;

	List<OrderDto> getLastOrder(String loginEmail) throws Exception;
}
