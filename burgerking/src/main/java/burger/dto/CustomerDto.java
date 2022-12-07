package burger.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerDto {
	private int memberNum;
	private String email;
	private String name;
	private String phone;
	private boolean sex;
	private Date birth;
	private String year;
	private String month;
	private String day;
	private String password;
	private Date joinDate;

}
