package com.tiagodeveloper.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private String name;
	private String address;
	private String houseNumber;
	private String complement;
	

}
