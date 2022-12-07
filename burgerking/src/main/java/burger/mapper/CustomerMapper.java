package burger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import burger.dto.CustomerDto;

@Mapper
public interface CustomerMapper {
	boolean join(CustomerDto customer) throws Exception;

	CustomerDto getCustomerInfo(String loginEmail) throws Exception;

	boolean update(CustomerDto customer) throws Exception;

	List<CustomerDto> selectAllCustomer() throws Exception;

	int totalPay(String loginEmail) throws Exception;

	int totalPayUpdate(int totalPay, String loginEmail) throws Exception;

	//REST
	CustomerDto login(CustomerDto memberDto) throws Exception;
}
