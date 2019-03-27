package com.yuesao.yuesao.convert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * @author sunshixiong
 * @date 2018/12/3
 */
public class JsonConverter implements AttributeConverter<Object, String> {


  private static ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String convertToDatabaseColumn(Object meta) {
    if (meta == null) {
      return null;
    }
    try {
      return objectMapper.writeValueAsString(meta);
    } catch (JsonProcessingException ex) {
      return null;
    }
  }

  @Override
  public Object convertToEntityAttribute(String dbData) {
    if (dbData == null) {
      return null;
    }
    try {
      return objectMapper.readValue(dbData, Object.class);
    } catch (IOException ex) {
      ex.printStackTrace();
      return null;
    }
  }

}
