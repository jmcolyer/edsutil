package ch.rasc.edsutil.jackson;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class ISO8601LocalDateDeserializer extends JsonDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException {
		return LocalDate.parse(jp.getText());
	}
}