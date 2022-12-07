package burger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burger.dto.ProductDto;
import burger.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;
	
//	@Override
//	public List<ProductDto> basketAll() throws Exception {
//		return productMapper.basketAll();
//	}
//
//	@Override
//	public String productName(String productNum) throws Exception {
//		return productMapper.productName(productNum);
//	}
//
//	@Override
//	public String productImg(String productNum) throws Exception {
//		return productMapper.productImg(productNum);
//	}

	@Override
	public ProductDto selectProduct(int productNum) throws Exception {
		return productMapper.selectProduct(productNum);
	}

	@Override
	public int update(ProductDto product) throws Exception {
		return productMapper.updateProduct(product);
	}

	@Override
	public int insert(ProductDto product) throws Exception {
		return productMapper.insertProduct(product);
	}

	@Override
	public int delete(int productNum) throws Exception {
		return productMapper.deleteProduct(productNum);
	}

	//REST
	@Override
	public List<ProductDto> productAll() throws Exception {
		return productMapper.productAll();
	}

}
