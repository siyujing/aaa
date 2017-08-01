package com.example.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;

/**
 * Created by boxfish on 17/7/7.
 */
public class FormatUtils {

    // For json
    private static ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)       // 属性为空（“”）或者为 NULL 都不序列化
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .registerModule(new JodaModule());

    // For xml
    private static XmlMapper xmlMapper = (XmlMapper) new XmlMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);


    static public String toJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * 适用于日志输出时使用
     */
    static public String toJsonNoException(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    static public <T> T fromJson(String json, Class<T> type) throws IOException {
        return objectMapper.readValue(json, type);
    }


    static public String toXml(Object object) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(object);
    }

    static public <T> T fromXml(String xml, Class<T> type) throws IOException {
        return xmlMapper.readValue(xml, type);
    }

}

