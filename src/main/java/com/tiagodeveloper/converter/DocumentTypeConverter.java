package com.tiagodeveloper.converter;

import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;

import com.tiagodeveloper.enums.DocumentType;

public class DocumentTypeConverter implements PropertyValueConverter<DocumentType, String, ValueConversionContext<?>>{

	@Override
	public DocumentType read(String value, ValueConversionContext<?> context) {
		return DocumentType.findByName(value);
	}

	@Override
	public String write(DocumentType value, ValueConversionContext<?> context) {
		return value.name();
	}

}
