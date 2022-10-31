package com.tiagodeveloper.enums;

public enum DocumentType {
	CPF, PJ, NULO;
	
	public static DocumentType findByName(String name) {
		for(DocumentType type: DocumentType.values()) {
			if(type.name().equals(name.toUpperCase()))
				return type;
		}
		
		return DocumentType.NULO;
	}
}
