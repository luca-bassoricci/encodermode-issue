package org.acme;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.quarkus.jackson.ObjectMapperCustomizer;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OMCustomizer implements ObjectMapperCustomizer {

    @Override
    public void customize(ObjectMapper objectMapper) {
        SimpleModule m = new SimpleModule("test");

        m.addSerializer(new StringAndIntSerializer());
        m.addDeserializer(StringAndInt.class, new StringAndIntDeserializer());
        objectMapper.registerModule(m);
        System.out.println("OMCustomizer loaded: " + new Date());
    }

}
