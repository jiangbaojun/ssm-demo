package com.ssm.block.mvc.message;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MyObjectMapper extends ObjectMapper {

    public MyObjectMapper() {

        SimpleModule se = new SimpleModule();
        //自定类型序列化
        se.addSerializer(Date.class, new MyDateSerializer());
        se.addSerializer(Timestamp.class, new MyTimestampSerializer());
        se.addSerializer(Time.class, new MyTimeSerializer());
        this.registerModule(se);
    }


    /**
     * 序列化日期
     */
    private class MyDateSerializer extends JsonSerializer<Date> {
    	@Override
    	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    		//序列化日期
    		if(value==null) {
    			gen.writeNull();
    		}else {
    			gen.writeString(new SimpleDateFormat("yyyy-MM-dd").format(value));
    		}
    	}
    }
    private class MyTimestampSerializer extends JsonSerializer<Timestamp> {
    	@Override
    	public void serialize(Timestamp value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    		//序列化日期
    		if(value==null) {
    			gen.writeNull();
    		}else {
    			gen.writeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value));
    		}
    	}
    }
    private class MyTimeSerializer extends JsonSerializer<Time> {
		@Override
		public void serialize(Time value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
			//序列化日期
			if(value==null) {
				gen.writeNull();
			}else {
				gen.writeString(new SimpleDateFormat("HH:mm:ss").format(value));
			}
		}
    }

}