package ems.details.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto {
	
	@NotBlank(message="Name should not be empty")
	@NotNull(message="Name cannot be null")
	@Size(min=4,max=15,message="Name must contain 4-15 characters")
	private String name;
	
	@Min(value=21,message="Invalid Age,age should be above 20")
	@Max(value=28,message="Invalid Age, Age should be below 29")
	private int age;
	
	@Email(message="Invalid Email format")
	private String email;
	
	@NotBlank(message="Name should not be empty")
	@NotNull(message="Name cannot be null")
	private String desgination;
	
	@NotBlank(message="Name should not be empty")
	@NotNull(message="Name cannot be null")
	private String address;
	
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone Number !")
	private String mobileNo;

}
