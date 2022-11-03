package com.tiagodeveloper.document;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.tiagodeveloper.converter.DocumentTypeConverter;
import com.tiagodeveloper.enums.DocumentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@MongoId
	private ObjectId id;
	private String name;
	private String email;
	@ValueConverter(value = DocumentTypeConverter.class)
	private DocumentType documentType;
	private String documentValue;
	@Builder.Default
	private Set<Address> address = new HashSet<>();
	
}
