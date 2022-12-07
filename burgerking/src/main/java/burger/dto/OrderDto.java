package burger.dto;

import lombok.Data;

@Data
public class OrderDto {
	private String orderEmail;
	private int orderNum;
	private String orderAddress;
	private String orderList;
	private String orderTime;

}
