package burger.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import burger.dto.ProductDto;

@Mapper
public interface ProductMapper {
	//REST
	List<ProductDto> productAll() throws Exception;
	
	ProductDto selectProduct(int productNum) throws Exception;

	int updateProduct(ProductDto product) throws Exception;

	int insertProduct(ProductDto product) throws Exception;

	int deleteProduct(int productNum) throws Exception;
	
}
