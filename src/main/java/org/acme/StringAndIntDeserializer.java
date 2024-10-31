package org.acme;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class StringAndIntDeserializer extends StdDeserializer<StringAndInt> {

    public StringAndIntDeserializer() {
        super(StringAndInt.class);
        // TODO Auto-generated constructor stub
    }

    @Override
    public StringAndInt deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        if (p.currentToken() == JsonToken.VALUE_STRING) {
            return StringAndInt.parse(p.getText());
        } else if (p.currentToken() == JsonToken.VALUE_NULL) {
            return null;
        }
        return null;
    }
}
