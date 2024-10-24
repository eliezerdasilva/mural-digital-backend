package br.com.mural_digital_backend.molds;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ArrayListToStringConverter implements AttributeConverter<List<String>, String> {

	String delimiter = ";"; // Exemplo de um delimitador diferente

    @Override
    public String convertToDatabaseColumn(List<String> list) {
    	 return String.join(delimiter, list);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
    	return Arrays.asList(dbData.split(delimiter));
    }
}