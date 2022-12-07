package burger.service;

import java.util.List;

import burger.vo.RequestVo;
import burger.vo.ResponseVo;
import burger.dto.CustomerDto;

public interface CustomerService {

	public boolean join(burger.dto.CustomerDto customer) throws Exception;

	public CustomerDto getCustomerInfo(String loginEmail) throws Exception;

	
	public List<CustomerDto> selectAllCustomer() throws Exception;

	public int totalPay(String loginEmail) throws Exception;

	public int totalPayUpdate(int totalPay, String loginEmail) throws Exception;
	
	//REST
	public ResponseVo login(RequestVo requestVo) throws Exception;
	
	public boolean update(CustomerDto customer) throws Exception;
}