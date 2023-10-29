package com.jabaddon.learning.java.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonPrinter {
    public static String asPrettyJson(Object obj) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(stringWriter, obj);
        return stringWriter.toString();
    }
}
