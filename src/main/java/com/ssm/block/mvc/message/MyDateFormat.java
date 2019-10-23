package com.ssm.block.mvc.message;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义日期格式化
 * @author		姜宝俊
 */
public class MyDateFormat extends DateFormat {
	private static final long serialVersionUID = 1L;

	private DateFormat defaultDateFormat = new SimpleDateFormat();
	
	/**
	 * 空参构造注入
	 */
	public MyDateFormat() {
		super();
	}

	public MyDateFormat(DateFormat defaultDateFormat) {
		super();
		this.defaultDateFormat = defaultDateFormat;
	}

	/**
	 * 格式化日期，返回数据，含有日期转换时调用
	 */
	@Override
	public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
		DateFormat df = getDf(date);
		if(df!=null) {
			return df.format(date, toAppendTo, fieldPosition);
		}else {
			return toAppendTo.append(date.getTime());
		}
//		return defaultDateFormat.format(date, toAppendTo, fieldPosition);
	}
 
	/**
	 * 根据日期对象类型，转换为相应的日期字符串
	 */
	private DateFormat getDf(Date date) {
		if(date instanceof Timestamp) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else if(date instanceof Time){
			return new SimpleDateFormat("HH:mm:ss");
		}else if(date instanceof Date) {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
		return null;
	}

	/**
	 * 解析日期
	 * 支持的日期格式：
	 */
	@Override
	public Date parse(String source, ParsePosition pos) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source, pos);
			if(date==null) {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(source, pos);
			}
			if(date==null) {
				date = new SimpleDateFormat("HH:mm:ss").parse(source, pos);
			}
		} catch (Exception e) {}
		return date;
	}
 
	
	@Override
	public Date parse(String source) throws ParseException {
		return parse(source,new ParsePosition(0));
	}
 
	// 这里装饰clone方法的原因是因为clone方法在jackson中也有用到
	@Override
	public Object clone() {
		return new MyDateFormat(defaultDateFormat);
	}
}