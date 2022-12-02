package com.example.produces;
// <editor-fold defaultstate="collapsed" desc="imports">

import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ParamConverter;
import jakarta.ws.rs.ext.ParamConverterProvider;
import jakarta.ws.rs.ext.Provider;
import java.io.Serializable;
/**
* Java
*/
import java.util.Date;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
/**
* Jmoordb
*/
import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordb.core.annotation.date.DateTimeFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


// </editor-fold>
@Provider
public class DateParameterConverterProvider  implements ParamConverterProvider{
// <editor-fold defaultstate="collapsed" desc="code">

     @SuppressWarnings("unchecked")
     @Override
     public <T> ParamConverter<T> getConverter(final Class<T> rawType, final Type genericType, final Annotation[] annotations) {
       if (Date.class.equals(rawType)) {
           final DateParameterConverter dateParameterConverter = new DateParameterConverter();

           for (Annotation annotation : annotations) { 
               if (DateTimeFormat.class.equals(annotation.annotationType())) {
                   dateParameterConverter. setCustomDateTimeFormat((DateTimeFormat) annotation);
               } else if (DateFormat.class.equals(annotation.annotationType())) { 
                       dateParameterConverter.setCustomDateFormat((DateFormat) annotation);
               } 
           }
            return (ParamConverter<T>) dateParameterConverter;
     }
     return null;
     
     }

// </editor-fold>

}