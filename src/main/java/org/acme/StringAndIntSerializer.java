package org.acme;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class StringAndIntSerializer extends StdSerializer<StringAndInt> {

    public StringAndIntSerializer() {
        super(StringAndInt.class);
    }

    @Override
    public void serialize(StringAndInt value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value == null)
            gen.writeNull();
        else {
            gen.writeString(value.format());
        }
    }
}
