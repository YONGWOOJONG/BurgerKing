package burger.service;

import java.util.List;

import burger.dto.ProductDto;

public interface ProductService {


	
//	public List<ProductDto> basketAll() throws Exception;
//
//	public String productName(String productNum) throws Exception;
//
//	public String productImg(String productNum) throws Exception;
	
	//REST
	public int update(ProductDto product) throws Exception;

	public int insert(ProductDto product) throws Exception;

	public int delete(int productNum) throws Exception;
	
	public ProductDto selectProduct(int productNum) throws Exception;
	
	public List<ProductDto> productAll() throws Exception;
}