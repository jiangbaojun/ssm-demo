package com.ssm.common.constant;

import java.util.TimeZone;

/**
 * 全局常量
 */
public class ConfigConstant {
    /** 请求参数标识key */
    public static final String REQUESTMAP_KEY = "requestMapKey";
    /** 数据结果集key */
    public static String RESULT_LIST_KEY = "rows";
    /** 中国时区 */
    public static TimeZone TIMEZONE_CHINA = TimeZone.getTimeZone("GMT+:08:00");
    /** 日期格式 */
	public static String DATE_FORMAT = "yyyy-MM-dd";
    /** 时间格式 */
	public static String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /** 精确时间格式 */
	public static String DATETIME_EXACT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    /** 格式化日期数组 */
	public static String[] DATE_TIME_FORMAT = new String[]{
        DATETIME_EXACT_FORMAT,
        DATETIME_FORMAT,
        DATE_FORMAT
    };
	/** 编码 */
	public static String CODED_FORMAT = "UTF-8";
    /** 逗号分隔符（通常用于字符串分隔） */
	public static String  STRING_SPLIT = ",";
    /** 冒号分隔符（通常用于表达式分隔） */
	public static String  EXCEPTION_NAME_SPLIT = ":";
    /** 分页参数-当前页 */
	public static String PAGE_PARAM_PAGE_KEY = "page_currentPageNum";
    /** 分页参数-每页数量 */
	public static String PAGE_PARAM_SIZE_KEY = "page_size";
    /** 分页参数-排序 */
	public static String PAGE_PARAM_SORT_KEY = "page_sort";
    /** 分页返回数据-当前页 */
	public static String PAGE_PAGE_KEY = "page";
    /** 分页返回数据-每页数量 */
	public static String PAGE_SIZE_KEY = "size";
    /** 分页返回数据-总条数key */
	public static String PAGE_TOTAL_KEY = "total";
    /** 分页返回数据-数据key */
	public static String PAGE_LIMIT_KEY = "rows";
    /** 分页返回数据-默认每页数量值 */
	public static Integer PAGE_DEFAULT_SIZE_VALUE = 10;
    /** 分页返回数据-默认当前页码 */
	public static Integer PAGE_DEFAULT_PAGE_VALUE = 1;

    /** 全部应用appid */
	public static String SYSTEMALL = "SYSTEMALL";
    /** 鉴权token */
	public static String X_TOKEN = "X-Token";
    /** 内部token有效期（毫秒） */
	public static Long EXPIRATION_TIME = 15*24*3600*1000L;
    /** 当前账户所属应用参数key */
	public static String ACCOUNTAPPID = "accountAppId";
    /** 当前账户ID参数key */
	public static String ACCOUNTID = "optName";
    /** 当前账户信息参数key */
	public static String ACCOUNTINFO = "accountInfo";



}
