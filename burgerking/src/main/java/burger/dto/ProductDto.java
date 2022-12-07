package burger.dto;

import lombok.Data;

@Data
public class ProductDto {
	private int productNum;
	private String productType;
	private String productName;
	private int productPrice;
	private String productImg;
	private int productMany;
}
