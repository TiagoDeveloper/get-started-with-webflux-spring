package com.tiagodeveloper.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tiagodeveloper.converter.DocumentTypeConverter;
import com.tiagodeveloper.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private String id;
	private String name;
	private String email;
	@ValueConverter(value = DocumentTypeConverter.class)
	private DocumentType documentType;
	private String documentValue;
	
}
