package com.task.users.utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FlexibleDateDeserializer extends JsonDeserializer<LocalDate> {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("[yyyy-M-d][yyyy-MM-dd]");

	@Override
	public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		String dateStr = p.getText();
		return LocalDate.parse(dateStr, FORMATTER);
	}
}
