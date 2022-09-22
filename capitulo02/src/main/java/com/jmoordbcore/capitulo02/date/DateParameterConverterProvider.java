/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo02.date;

/**
 *
 * 
 */
import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordb.core.annotation.date.DateTimeFormat;
import com.jmoordbcore.capitulo02.date.DateParameterConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;
 
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
 
@Provider
public class DateParameterConverterProvider implements ParamConverterProvider {
 
  @SuppressWarnings("unchecked")
  @Override
  public <T> ParamConverter<T> getConverter(final Class<T> rawType,
    final Type genericType, final Annotation[] annotations) {
    if (Date.class.equals(rawType)) {
      final DateParameterConverter dateParameterConverter =
        new DateParameterConverter();
 
      for (Annotation annotation : annotations) {
        if (DateTimeFormat.class.equals(
          annotation.annotationType())) {
      dateParameterConverter.
            setCustomDateTimeFormat((DateTimeFormat) annotation);
        } else if (DateFormat.class.equals(
          annotation.annotationType())) {
          dateParameterConverter.
            setCustomDateFormat((DateFormat) annotation);
        }
      }
      return (ParamConverter<T>) dateParameterConverter;
    }
    return null;
  }
    
}
