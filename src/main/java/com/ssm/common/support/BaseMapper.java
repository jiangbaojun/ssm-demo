package com.ssm.common.support;

import java.util.Map;

public interface BaseMapper extends SqlMapper {
    int delete(Map<String, Object> params);

    int update(Map<String, Object> params);

    int add(Map<String, Object> params);
}