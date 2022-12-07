package burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import burger.dto.ProductDto;
import burger.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestManagerController {
	@Autowired
	private ProductService productservice;

	// REST
	// 상품 등록
	@RequestMapping(value = "/product/insert", method = RequestMethod.POST)
	public ResponseEntity<String> productInsert(@RequestBody ProductDto product) throws Exception {

		int result = productservice.insert(product);
		if (result > 0) {
			return ResponseEntity.status(HttpStatus.OK).body("등록성공");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록실패");
		}
	}

	// 상품 삭제
	@RequestMapping(value = "/product/delete/{productNum}", method = RequestMethod.DELETE)
	public void productDelete(@PathVariable("productNum") int productNum) throws Exception {
		productservice.delete(productNum);
	}

	// 상품 수정
	@RequestMapping(value = "/product/update/{productNum}", method = RequestMethod.PUT)
	public void productUpdate(@PathVariable("productNum") int productNum, @RequestBody ProductDto productDto)
			throws Exception {
		productDto.setProductNum(productNum);
		productservice.update(productDto);
	}

	// 전체 상품 등록 확인
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public List<ProductDto> productAll() throws Exception {
		return productservice.productAll();
	}

	// 단일 상품 등록 확인
	@RequestMapping(value = "/product/{productNum}", method = RequestMethod.GET)
	public ResponseEntity<ProductDto> product(@PathVariable("productNum") int productNum) throws Exception {
		ProductDto productDto = productservice.selectProduct(productNum);
		if (productDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(productDto);
		}
	}

}
