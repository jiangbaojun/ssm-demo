package com.ssm.block.mybatis.example2.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

//@MappedTypes({String[].class})
//@MappedJdbcTypes({JdbcType.VARCHAR})
public class ExampleTypeHandler extends BaseTypeHandler<String[]> {

    /* 
     * 列为String[]类型，通过该方法处理。本例，实体类User的phones为String[]类型
     */
    @Override
    public String[] getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String str  = rs.getString(columnName);
        return str.split(",");
    }

    /* 
     * 根据列索引，获取可以为空的结果
     */
    @Override
    public String[] getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
    	String str  = rs.getString(columnIndex);
        return str.split(",");
    }

    /*47      * @see org.apache.ibatis.type.BaseTypeHandler#getNullableResult(java.sql.CallableStatement, int)
     */
    @Override
    public String[] getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
    	String str  = cs.getString(columnIndex);
        return str.split(",");
    }

    /* 
     *  当参数类型为String[]时，执行该方法，设置对应的sql参数
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String[] parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i,StringUtils.join(parameter, ","));
    }

    

}