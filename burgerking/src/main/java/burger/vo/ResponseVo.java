package burger.vo;

import lombok.Data;

@Data
public class ResponseVo {
	private int memberNum ;
	private String name;
	private String email;
	private String manager;
}
