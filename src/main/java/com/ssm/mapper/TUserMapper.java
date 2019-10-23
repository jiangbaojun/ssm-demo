package com.ssm.mapper;

import java.util.List;

import com.ssm.common.support.BaseMapper;
import com.ssm.model.Tuser;

public interface TUserMapper extends BaseMapper{
    List<Tuser> findByUsers();
}