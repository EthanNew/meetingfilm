package com.stylefeng.guns.rest.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 21:26
 * @Description:
 */

public class StringArray2IntegerHandle extends BaseTypeHandler<Integer[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer("#");
        for (Integer integer : integers) {
            sb.append(integer).append("#");
        }
        preparedStatement.setString(i, sb.toString());
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new Integer[0];
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new Integer[0];
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new Integer[0];
    }
}
