package burger.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burger.dto.CustomerDto;
import burger.vo.RequestVo;
import burger.vo.ResponseVo;
import burger.mapper.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public boolean join(CustomerDto customer) throws Exception {
		return customerMapper.join(customer);
	}

	@Override
	public CustomerDto getCustomerInfo(String loginEmail) throws Exception {
		return customerMapper.getCustomerInfo(loginEmail);
	}

	@Override
	public boolean update(CustomerDto customer) throws Exception {
		return customerMapper.update(customer);
	}

	@Override
	public List<CustomerDto> selectAllCustomer() throws Exception {
		return customerMapper.selectAllCustomer();
	}

	@Override
	public int totalPay(String loginEmail) throws Exception {
		return customerMapper.totalPay(loginEmail);
	}

	@Override
	public int totalPayUpdate(int totalPay, String loginEmail) throws Exception {
		return customerMapper.totalPayUpdate(totalPay, loginEmail);
	}
	
	
//REST
	@Override
	public ResponseVo login(RequestVo requestVo) throws Exception {
		

		ModelMapper modelMapper = new ModelMapper(); //모델메퍼 객체생성
		CustomerDto memberDto = modelMapper.map(requestVo, CustomerDto.class);
		
		
		CustomerDto resultDto = customerMapper.login(memberDto);
		if (resultDto == null) 
			return null;
		
		ResponseVo responseVo = modelMapper.map(resultDto, ResponseVo.class);
		return responseVo;
	}

}
